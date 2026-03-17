package com.negocio.controladores;

import java.util.ArrayList;

import com.dados.interfaces.IRepositorioFuncionario;
import com.dados.repositoriosSerialize.RepositorioFuncionarioSerialize;
import com.negocio.basicas.Funcionario;
import com.negocio.excessoes.InformacaoInvalidaException;
import com.negocio.excessoes.InformacaoNaoEncontradaException;
import com.negocio.excessoes.MedSystemException;

public class ControladorFuncionario {
    //Atributos
    private IRepositorioFuncionario repositorioFuncionario = new RepositorioFuncionarioSerialize();

    //Metodos Funcionarios
    public void adicionar(Funcionario funcionario) throws MedSystemException{
        verificarFuncionario(funcionario);
        try{
            repositorioFuncionario.buscar(funcionario.getcPF());
            throw new InformacaoInvalidaException("CPF ja existente no sistema!");
        } catch (InformacaoNaoEncontradaException Ex){
            repositorioFuncionario.adicionar(funcionario);
        }
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
        if(funcionario.getDataNascimento().getAno() < 1900){
            throw new InformacaoInvalidaException("Data de Nascimento invalida!");
        }
    }
    private void verificarCPF(String CPF) throws MedSystemException{
        if(!CPF.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new InformacaoInvalidaException("CPF em formato invalido");
        }
    }
}
