package com.negocio.Controladores;

import java.util.ArrayList;

import com.dados.interfaces.IRepositorioFuncionario;
import com.dados.repositoriosSerialize.RepositorioFuncionarioSerialize;
import com.negocio.basicas.Funcionario;
import com.negocio.Excessoes.InformacaoInvalidaException;
import com.negocio.Excessoes.InformacaoNaoEncontradaException;
import com.negocio.Excessoes.MedSystemException;

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
        repositorioFuncionario.excluir(CPF);
    }
    public Funcionario logar(String login, String senha) throws MedSystemException{
        return repositorioFuncionario.logar(login, senha);
    }
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException{
        verificarFuncionario(funcionario);
        repositorioFuncionario.modificar(CPF, funcionario);
    }
    public ArrayList<Funcionario> listar() throws MedSystemException{
        return repositorioFuncionario.listar();
    }
    public Funcionario buscar(String CPF) throws MedSystemException{
        return repositorioFuncionario.buscar(CPF);
    }

    //Metodos Privados
    private void verificarFuncionario(Funcionario funcionario) throws MedSystemException{
        if(funcionario == null  || !funcionario.getDataNascimento().isDataValida()){
            throw new InformacaoInvalidaException("Informacao Invalida");
        }
        if(funcionario.getDataNascimento().getAno() < 1900){
            throw new InformacaoInvalidaException("Data de Nascimento invalida!");
        }
    }
}
