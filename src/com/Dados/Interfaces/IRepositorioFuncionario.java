package com.Dados.Interfaces;

//Bibliotecas
import java.util.ArrayList;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.MedSystemException;

public interface IRepositorioFuncionario {
    void adicionar(Funcionario funcionario) throws MedSystemException;
    void excluir(String CPF) throws MedSystemException;
    Funcionario logar(String login, String senha) throws MedSystemException;
    void modificar(String CPF, Funcionario funcionario) throws MedSystemException;
    ArrayList<Funcionario> listar() throws MedSystemException;
    Funcionario buscar(String CPF) throws MedSystemException;
} 
