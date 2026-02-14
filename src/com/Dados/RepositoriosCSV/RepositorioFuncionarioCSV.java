package com.Dados.RepositoriosCSV;

import java.util.ArrayList;
import com.Dados.Interfaces.IRepositorioFuncionario;
import com.Negocio.Basicas.Administrador;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.MedSystemException;

public class RepositorioFuncionarioCSV implements IRepositorioFuncionario{
    public void adicionar(Funcionario funcionario) throws MedSystemException {

    }
    public void excluir(String CPF) throws MedSystemException {

    }
    public Funcionario logar(String login, String senha) throws MedSystemException {
        Funcionario func = new Administrador();
        return func;
    }
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException {

    }
    public ArrayList<Funcionario> listar() throws MedSystemException {
        ArrayList<Funcionario> funcs = new ArrayList<>();
        return funcs;
    }
    public Funcionario buscar(String CPF) throws MedSystemException {
        Funcionario func = new Administrador();
        return func;
    }
}
