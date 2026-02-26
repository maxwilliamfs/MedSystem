package com.Dados.RepositoriosSerialize;


//Bibliotecas
import com.Negocio.Basicas.Administrador;
import com.Dados.Interfaces.IRepositorioConsulta;
import com.Negocio.Basicas.ConsultaAbstrata;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Enuns.StatusConsulta;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;
import com.Negocio.Excessoes.BugFoundException;
import com.Negocio.Excessoes.ErroNoDiscoException;
import com.Negocio.Excessoes.InformacaoNaoEncontradaException;
import com.Negocio.Excessoes.MedSystemException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RepositorioConsultaSerialize implements IRepositorioConsulta{
    //Atributos
    private String nomeArquivo = "Arquivos/Consultas.bin";

    //Metodos CRUD
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        if(consultas.isEmpty()){
            consulta.setId(1);
        } else {
            consulta.setId(consultas.size() - 1);
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
    public ArrayList<ConsultaAbstrata> listarTriagem() throws MedSystemException{
        ArrayList<ConsultaAbstrata> triagem = new ArrayList<>();
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        for(int i = 0; i < consultas.size(); i++){
            if(consultas.get(i).getData().equals(Data.getDataHoje())){
                triagem.add(consultas.get(i));
            }
        }
        return triagem;
    }
    public void realizarTriagem(int id, String sintomas, GravidadeConsulta gravidade) throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int iD = buscarID(id, consultas);
        consultas.get(iD).setSintomas(sintomas);
        consultas.get(iD).setGravidade(gravidade);
        consultas.get(iD).setStatus(StatusConsulta.AGUARDANDO);
        salvarDados(consultas);
    }
    public ArrayList<ConsultaAbstrata> agendaMedica(String CPF, Data dataAgenda) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        ArrayList<ConsultaAbstrata> agenda = new ArrayList<>();
        for(int i = 0; i < consultas.size(); i++){
            if(consultas.get(i).getData().equals(dataAgenda) && consultas.get(i).getMedico().getcPF().equals(CPF)){
                agenda.add(consultas.get(i));
            }
        }
        return agenda;
    }
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int iD = buscarID(id, consultas);
        consultas.get(iD).setPrescricaoMedica(prescricaoMedica);
        consultas.get(iD).setProcedimentos(procedimentos);
        salvarDados(consultas);
    }

    //Metodos Privados
    private int buscarID(int id, ArrayList<ConsultaAbstrata> consultas) throws MedSystemException {
        for(int i = 0; i < consultas.size();i++){
            if(consultas.get(i).getId() == id){
                return i;
            }
        }
        throw new InformacaoNaoEncontradaException("Nao existe consulta cadastrado com tal CPF!!!");
    }
    private ArrayList<ConsultaAbstrata> lerDados() throws MedSystemException{
        
        ArrayList<ConsultaAbstrata> consultas;
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            try(FileInputStream stream = new FileInputStream(arq);
            ObjectInputStream obj = new ObjectInputStream(stream)){
                consultas = (ArrayList<ConsultaAbstrata>)obj.readObject();
            } catch (IOException Ex){ 
                throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
            } catch (ClassNotFoundException Ex){
                throw new BugFoundException("Bug encontrado, contate o desenvolvedor", Ex);
            }
        } else {
            consultas = new ArrayList<>();
        }
        return consultas;
    }
    private void salvarDados(ArrayList<ConsultaAbstrata> consultas) throws MedSystemException{
        File arq = new File(nomeArquivo);
        try(FileOutputStream stream = new FileOutputStream(arq);
        ObjectOutputStream obj = new ObjectOutputStream(stream)){
            obj.writeObject(consultas);
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
        }
    }
}