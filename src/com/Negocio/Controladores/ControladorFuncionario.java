package com.Negocio.Controladores;

import java.util.ArrayList;

import com.Dados.Interfaces.IRepositorioFuncionario;
import com.Dados.RepositoriosSerialize.RepositorioFuncionarioSerialize;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.InformacaoInvalidaException;
import com.Negocio.Excessoes.MedSystemException;

public class ControladorFuncionario {
    //Atributos
    private IRepositorioFuncionario repositorioFuncionario = new RepositorioFuncionarioSerialize();

    //Metodos Funcionarios
    public void adicionar(Funcionario funcionario) throws MedSystemException{
        verificarFuncionario(funcionario);
        repositorioFuncionario.adicionar(funcionario);
    }
    public void excluir(String CPF) throws MedSystemException{
        verificarCPF(CPF);
        repositorioFuncionario.excluir(CPF);
    }
    public Funcionario logar(String login, String senha) throws MedSystemException{
        return repositorioFuncionario.logar(login, senha);
    }
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException{
        verificarCPF(CPF);
        verificarFuncionario(funcionario);
        repositorioFuncionario.modificar(CPF, funcionario);
    }
    public ArrayList<Funcionario> listar() throws MedSystemException{
        return repositorioFuncionario.listar();
    }
    public Funcionario buscar(String CPF) throws MedSystemException{
        verificarCPF(CPF);
        return repositorioFuncionario.buscar(CPF);
    }

    //Metodos Privados
    private void verificarFuncionario(Funcionario funcionario) throws MedSystemException{
        if(funcionario == null || funcionario.getNome().trim().isBlank() || !funcionario.getDataNascimento().isDataValida()){
            throw new InformacaoInvalidaException("Informacao Invalida");
        }
    }
    private void verificarCPF(String CPF) throws MedSystemException{
        if(!CPF.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new InformacaoInvalidaException("CPF em formato invalido");
        }
    }
}
