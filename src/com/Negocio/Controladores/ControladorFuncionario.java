package com.Negocio.Controladores;

import java.util.ArrayList;

import com.Dados.Interfaces.IRepositorioFuncionario;
import com.Dados.RepositoriosCSV.RepositorioFuncionarioCSV;
import com.Dados.RepositoriosSerialize.RepositorioFuncionarioSerialize;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.MedSystemException;

public class ControladorFuncionario {
    //Atributos
    private IRepositorioFuncionario repositorioFuncionario = new RepositorioFuncionarioSerialize();

    //Metodos Funcionarios
    public void adicionar(Funcionario funcionario) throws MedSystemException{
        repositorioFuncionario.adicionar(funcionario);
    }
    public void excluir(String CPF) throws MedSystemException{
        repositorioFuncionario.excluir(CPF);
    }
    public Funcionario logar(String login, String senha) throws MedSystemException{
        return repositorioFuncionario.logar(login, senha);
    }
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException{
        repositorioFuncionario.modificar(CPF, funcionario);
    }
    public ArrayList<Funcionario> listar() throws MedSystemException{
        return repositorioFuncionario.listar();
    }
    public Funcionario buscar(String CPF) throws MedSystemException{
        return repositorioFuncionario.buscar(CPF);
    }
}
