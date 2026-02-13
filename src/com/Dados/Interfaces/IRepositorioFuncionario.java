package com.Dados.Interfaces;

//Bibliotecas
import java.util.ArrayList;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.MedSystemException;

public interface IRepositorioFuncionario {
    public void adicionar(Funcionario funcionario) throws MedSystemException;
    public void excluir(String CPF) throws MedSystemException;
    public Funcionario logar(String login, String senha) throws MedSystemException;
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException;
    public ArrayList<Funcionario> listar() throws MedSystemException;
    public Funcionario buscar(String CPF) throws MedSystemException;
} 
