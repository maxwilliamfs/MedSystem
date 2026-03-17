package com.maxwilliam.MedSystem.repository.repositoriosCSV;

//Bibliotecas
import com.maxwilliam.MedSystem.repository.interfaces.IRepositorioPaciente;
import com.maxwilliam.MedSystem.model.Paciente;
import com.maxwilliam.MedSystem.exception.BugFoundException;
import com.maxwilliam.MedSystem.exception.ErroNoDiscoException;
import com.maxwilliam.MedSystem.exception.InformacaoNaoEncontradaException;
import com.maxwilliam.MedSystem.exception.MedSystemException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RepositorioPacienteSerialize implements IRepositorioPaciente{
    //Atributos
    private String nomeArquivo = "Arquivos/Pacientes.bin";

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
        
        ArrayList<Paciente> pacientes;
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            try(FileInputStream stream = new FileInputStream(arq);
            ObjectInputStream obj = new ObjectInputStream(stream)){
                pacientes = (ArrayList<Paciente>)obj.readObject();
            } catch (IOException Ex){ 
                throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
            } catch (ClassNotFoundException Ex){
                throw new BugFoundException("Bug encontrado, contate o desenvolvedor", Ex);
            }
        } else {
            pacientes = new ArrayList<>();
        }
        return pacientes;
    }
    private void salvarDados(ArrayList<Paciente> pacientes) throws MedSystemException{
        File arq = new File(nomeArquivo);
        try(FileOutputStream stream = new FileOutputStream(arq);
        ObjectOutputStream obj = new ObjectOutputStream(stream)){
            obj.writeObject(pacientes);
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
        }
    }
}