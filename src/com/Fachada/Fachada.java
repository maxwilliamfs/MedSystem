package com.Fachada;

import java.util.ArrayList;

import com.Negocio.ControladorFuncionario;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.MedSystemException;

public class Fachada {
    //Atributos
    private static Fachada instance = null;
    private static ControladorFuncionario controladorFuncionario = new ControladorFuncionario();

    //Metodos da Fachada
    private Fachada(){}
    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }

    //Metodos Funcionario
    public void adicionar(Funcionario funcionario) throws MedSystemException{
        controladorFuncionario.adicionar(funcionario);
    }
    public void excluir(String CPF) throws MedSystemException{
        controladorFuncionario.excluir(CPF);
    }
    public Funcionario logar(String login, String senha) throws MedSystemException{
        return controladorFuncionario.logar(login, senha);
    }
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException{
        controladorFuncionario.modificar(CPF, funcionario);
    }
    public ArrayList<Funcionario> listar() throws MedSystemException{
        return controladorFuncionario.listar();
    }
    public Funcionario buscar(String CPF) throws MedSystemException{
        return controladorFuncionario.buscar(CPF);
    }
}
