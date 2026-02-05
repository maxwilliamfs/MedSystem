package com.Dados.Interfaces;

//Bibliotecas
import java.util.ArrayList;
import com.Negocio.Basicas.Funcionario;

public interface IRepositorioFuncionario {
    void adicionar(Funcionario funcionario);
    void excluir(String CPF);
    Funcionario logar(String login, String senha);
    void modificar(String CPF, Funcionario funcionario);
    ArrayList<Funcionario> listar();
    Funcionario buscar(String CPF);
} 
