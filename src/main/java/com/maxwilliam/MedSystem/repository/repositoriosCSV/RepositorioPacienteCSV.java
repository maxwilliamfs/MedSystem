/*
package com.maxwilliam.MedSystem.repository.repositoriosCSV;

//Bibliotecas
import com.dados.interfaces.IRepositorioPaciente;
import com.negocio.basicas.Paciente;
import com.negocio.Excessoes.BugFoundException;
import com.negocio.Excessoes.ErroNoDiscoException;
import com.negocio.Excessoes.InformacaoNaoEncontradaException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Pessoa;
import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.secundarias.Endereco;

import java.io.*;
import java.util.ArrayList;

public class RepositorioPacienteCSV implements IRepositorioPaciente{
    //Atributos
    private String nomeArquivo = "Arquivos/Pacientes.CSV";

    //Metodos Publicos
    public void adicionar(Paciente paciente) throws MedSystemException{
        ArrayList<Paciente> pacientes = lerDados();
        pacientes.add(paciente);
        salvarDados(pacientes);
    }
    public void excluir(String CPF) throws MedSystemException {
        ArrayList<Paciente> pacientes = lerDados();
        int ID = buscarCPF(CPF,pacientes);
        pacientes.remove(ID);
        salvarDados(pacientes);
    }
    public ArrayList<Paciente> listar() throws MedSystemException {
        return lerDados();
    }
    public void modificar(String CPF, Paciente paciente) throws MedSystemException {
        ArrayList<Paciente> pacientes = lerDados();
        int ID = buscarCPF(CPF,pacientes);
        pacientes.set(ID, paciente);
        salvarDados(pacientes);
    }
    public Paciente buscar(String CPF) throws MedSystemException{
        ArrayList<Paciente> pacientes = lerDados();
        int ID = buscarCPF(CPF,pacientes);
        return pacientes.get(ID);
    }

    //Metodos Privados
    private int buscarCPF(String CPF, ArrayList<Paciente> pacientes) throws MedSystemException {
        for(int i = 0; i < pacientes.size();i++){
            if(pacientes.get(i).getcPF().equals(CPF)){
                return i;
            }
        }
        throw new InformacaoNaoEncontradaException("Nao existe paciente cadastrado com tal CPF!!!");
    }
    private ArrayList<Paciente> lerDados() throws MedSystemException{
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try(BufferedReader buffer = new BufferedReader(new FileReader(nomeArquivo))){
            String linhaAtual;
            while((linhaAtual = buffer.readLine()) != null){
                String[] dados = linhaAtual.split(",");
                String nome = dados[0];
                String cpf = dados[1];

                String logra = dados[2];
                String muni = dados[3];
                String estado = dados[4];
                Endereco novoEnd = new Endereco(logra,muni,estado);

                String dataNascimento = dados[5];
                String[] datas = dataNascimento.split("/");
                int dia = Integer.parseInt(datas[0]);
                int mes = Integer.parseInt(datas[1]);
                int ano = Integer.parseInt(datas[2]);
                Data novaData = new Data(dia,mes,ano);

                String novoNmConvenio = dados[6];
                String novoPcCon = dados[7];
                double novoPcConvenio = Double.parseDouble(novoPcCon);
                String novoTipoS = dados[8];

                Pessoa pe = new Pessoa(nome,cpf,novoEnd,novaData);
                Paciente p = new Paciente(pe,novoNmConvenio,novoTipoS,novoPcConvenio);
                pacientes.add(p);
            }
            return pacientes;
        } catch (FileNotFoundException Ex) {
            return pacientes;
        } catch (IOException Ex){
            throw new ErroNoDiscoException("Falha ao ler o disco", Ex);
        }


    }
    private void salvarDados(ArrayList<Paciente> pacientes) throws MedSystemException{
        new File(nomeArquivo).getParentFile().mkdirs();
        try (FileWriter file = new FileWriter(nomeArquivo);
        PrintWriter writer = new PrintWriter(file)) {
            for(Paciente p : pacientes){
                writer.println(p.toCSV());
            }
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao salvar no disco", Ex);
        }
    }
}

 */