package com.dados.repositoriosCSV;


//Bibliotecas
import com.dados.interfaces.IRepositorioConsulta;
import com.negocio.Excessoes.ErroNoDiscoException;
import com.negocio.basicas.*;
import com.negocio.basicas.enuns.GravidadeConsulta;
import com.negocio.basicas.enuns.StatusConsulta;
import com.negocio.basicas.secundarias.*;
import com.negocio.Excessoes.InformacaoNaoEncontradaException;
import com.negocio.Excessoes.MedSystemException;

import java.io.*;
import java.util.ArrayList;

public class RepositorioConsultaCSV implements IRepositorioConsulta{
    //Atributos
    private String nomeArquivo = "Arquivos/Consultas.CSV";

    //Metodos CRUD
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        if(consultas.isEmpty()){
            consulta.setId(1);
        } else {
            consulta.setId(consultas.get(consultas.size() - 1).getId() + 1);
        }
        consultas.add(consulta);
        salvarDados(consultas);
    }
    public void cancelar(int id) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int ID = buscarID(id,consultas);
        consultas.get(ID).setStatus(StatusConsulta.CANCELADA);
        salvarDados(consultas);
    }
    public ArrayList<ConsultaAbstrata> listar() throws MedSystemException {
        return lerDados();
    }
    public void modificar(int id, ConsultaAbstrata consulta) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int ID = buscarID(id,consultas);
        consultas.set(ID, consulta);
        salvarDados(consultas);
    }
    public ConsultaAbstrata buscar(int id) throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int ID = buscarID(id,consultas);
        return consultas.get(ID);
    }

    //Metodos Especiais
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int iD = buscarID(id, consultas);
        consultas.get(iD).setPrescricaoMedica(prescricaoMedica);
        consultas.get(iD).setProcedimentos(procedimentos);
        salvarDados(consultas);
    }

    //Metodos Privados
    public int buscarID(int id, ArrayList<ConsultaAbstrata> consultas) throws MedSystemException {
        for(int i = 0; i < consultas.size();i++){
            if(consultas.get(i).getId() == id){
                return i;
            }
        }
        throw new InformacaoNaoEncontradaException("Nao existe consulta cadastrado com tal ID!!!");
    }
    private ArrayList<ConsultaAbstrata> lerDados() throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(nomeArquivo))) {
            String linhaAtual;
            while((linhaAtual = buffer.readLine()) != null){

                String[] dados = linhaAtual.split(",");

                int id = Integer.parseInt(dados[0]);

                RepositorioFuncionarioCSV repoFunc = new RepositorioFuncionarioCSV();
                RepositorioPacienteCSV repoPaci = new RepositorioPacienteCSV();
                Medico m = (Medico) repoFunc.buscar(dados[1]);
                Paciente p = (Paciente) repoPaci.buscar(dados[2]);

                String[] data = dados[3].split("/");
                int d = Integer.parseInt(data[0]), me = Integer.parseInt(data[1]), a = Integer.parseInt(data[2]);
                Data novaData = new Data(d,me,a);

                GravidadeConsulta novaGrav = GravidadeConsulta.valueOf(dados[4]);
                StatusConsulta statusNovo = StatusConsulta.valueOf(dados[5]);

                String[] inicio = dados[6].split(":");
                int iniH = Integer.parseInt(inicio[0]), iniM = Integer.parseInt(inicio[1]);
                Horario novoInicio = new Horario(iniH,iniM);
                String[] fim = dados[7].split(":");
                int fimH = Integer.parseInt(fim[0]), fimM = Integer.parseInt(fim[1]);
                Horario novoFim = new Horario(fimH,fimM);

                String novosSintomas = dados[8].replace("-",",");
                String novaObse = dados[9].replace("-",",");
                String medicamentos[] = dados[10].split("/");
                ArrayList<Medicamento> novosMedicamentos = new ArrayList<>();
                if(!medicamentos[0].equals("NADA")) {
                    for (int i = 0; i < medicamentos.length; i++) {
                        String[] info = medicamentos[i].split("\\|");
                        String nome = info[0], freq = info[1], dose = info[2];
                        Medicamento med = new Medicamento(nome, freq, dose);
                        novosMedicamentos.add(med);
                    }
                }
                PrescricaoMedica novaPres = new PrescricaoMedica(novaObse,novosMedicamentos);

                String procedimentos[] = dados[11].split("/");
                ArrayList<Procedimento> novosProce = new ArrayList<>();
                if(!procedimentos[0].equals("NADA")){
                    for(int i = 0; i < procedimentos.length ; i++){
                        String[] info = procedimentos[i].split("\\|");
                        String nome = info[0], preco = info[1];
                        double precoo = Double.parseDouble(preco);
                        Procedimento pro = new Procedimento(nome,precoo);
                        novosProce.add(pro);
                    }
                }

                String tipo = dados[12];
                if(tipo.equals("Particular")){
                    ConsultaParticular c = new ConsultaParticular(id,m,p,novaData,novoInicio,novoFim,novosSintomas,novaGrav,novaPres,novosProce,statusNovo);
                    consultas.add(c);
                } else {
                    ConsultaPublica c = new ConsultaPublica(id,m,p,novaData,novoInicio,novoFim,novosSintomas,novaGrav,novaPres,novosProce,statusNovo);
                    consultas.add(c);
                }
            }
            return consultas;
        } catch (FileNotFoundException Ex) {
            return consultas;
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao ler no disco", Ex);
        }

    }
    private void salvarDados(ArrayList<ConsultaAbstrata> consultas) throws MedSystemException{
        new File(nomeArquivo).getParentFile().mkdirs();
        try (FileWriter file = new FileWriter(nomeArquivo);
        PrintWriter writer = new PrintWriter(file)) {
            for(ConsultaAbstrata c : consultas){
                writer.println(c.toCSV());
            }
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao salvar no disco",Ex);
        }
    }
}