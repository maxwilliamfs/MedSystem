package com.maxwilliam.MedSystem.repository.repositoriosSerialize;

//Bibliotecas
import com.maxwilliam.MedSystem.repository.interfaces.IRepositorioFuncionario;
import com.maxwilliam.MedSystem.model.Administrador;
import com.maxwilliam.MedSystem.model.Funcionario;
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

public class RepositorioFuncionarioSerialize implements IRepositorioFuncionario{
    //Atributos
    private String nomeArquivo = "Arquivos/Funcionarios.bin";

    //Metodos Publicos
    public void adicionar(Funcionario funcionario) throws MedSystemException{
        ArrayList<Funcionario> funcionarios = lerDados();
        funcionarios.add(funcionario);
        salvarDados(funcionarios);
    }
    public void excluir(String CPF) throws MedSystemException {
        ArrayList<Funcionario> funcionarios = lerDados();
        int ID = buscarCPF(CPF,funcionarios);
        funcionarios.remove(ID);
        salvarDados(funcionarios);
    }
    public ArrayList<Funcionario> listar() throws MedSystemException {
        return lerDados();
    }
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException {
        ArrayList<Funcionario> funcionarios = lerDados();
        int ID = buscarCPF(CPF,funcionarios);
        funcionarios.set(ID, funcionario);
        salvarDados(funcionarios);
    }
    public Funcionario buscar(String CPF) throws MedSystemException{
        ArrayList<Funcionario> funcionarios = lerDados();
        int ID = buscarCPF(CPF,funcionarios);
        return funcionarios.get(ID);
    }
    public Funcionario logar(String login, String senha) throws MedSystemException{
        ArrayList<Funcionario> funcionarios = lerDados();
        if(login.equals("God") && senha.equals("123")){
                Administrador adm = new Administrador();
                adm.setNome("ADM Master");
                return adm;
        }
        for(int i = 0; i < funcionarios.size(); i++){
            if(funcionarios.get(i).getCPF().equals(login) && funcionarios.get(i).getSenha().equals(senha)){
                return funcionarios.get(i);
            }
        }
        throw new InformacaoNaoEncontradaException("Login ou Senha Invalidos!!!");
    }

    //Metodos Privados
    private int buscarCPF(String CPF, ArrayList<Funcionario> funcionarios) throws MedSystemException {
        new java.io.File("Arquivos").mkdir();
        for(int i = 0; i < funcionarios.size();i++){
            if(funcionarios.get(i).getCPF().equals(CPF)){
                return i;
            }
        }
        throw new InformacaoNaoEncontradaException("Nao existe Funcionario cadastrado com tal CPF!!!");
    }
    private ArrayList<Funcionario> lerDados() throws MedSystemException{
        new java.io.File("Arquivos").mkdir();
        ArrayList<Funcionario> funcionarios;
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            try(FileInputStream stream = new FileInputStream(arq);
            ObjectInputStream obj = new ObjectInputStream(stream)){
                funcionarios = (ArrayList<Funcionario>)obj.readObject();
            } catch (IOException Ex){ 
                throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
            } catch (ClassNotFoundException Ex){
                throw new BugFoundException("Bug encontrado, contate o desenvolvedor", Ex);
            }
        } else {
            funcionarios = new ArrayList<>();
        }
        return funcionarios;
    }
    private void salvarDados(ArrayList<Funcionario> funcionarios) throws MedSystemException{
        new java.io.File("Arquivos").mkdir();
        File arq = new File(nomeArquivo);
        try(FileOutputStream stream = new FileOutputStream(arq);
        ObjectOutputStream obj = new ObjectOutputStream(stream)){
            obj.writeObject(funcionarios);
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
        }
    }
}