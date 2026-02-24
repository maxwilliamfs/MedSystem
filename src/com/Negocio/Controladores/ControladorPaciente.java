package com.Negocio.Controladores;

import com.Dados.Interfaces.IRepositorioPaciente;
import com.Dados.RepositoriosSerialize.RepositorioPacienteSerialize;
import com.Negocio.Basicas.Paciente;
import com.Negocio.Excessoes.MedSystemException;
import java.util.ArrayList;

public class ControladorPaciente {
    //Atributos
    IRepositorioPaciente repositorioPaciente =  new RepositorioPacienteSerialize();

    public void adicionar(Paciente paciente) throws MedSystemException{
        repositorioPaciente.adicionar(paciente);
    }
    public void excluir(String CPF) throws MedSystemException{
        repositorioPaciente.excluir(CPF);
    }
    public void modificar(String CPF, Paciente paciente) throws MedSystemException{
        repositorioPaciente.modificar(CPF, paciente);
    }
    public ArrayList<Paciente> listar() throws MedSystemException{
        return repositorioPaciente.listar();
    }
    public Paciente buscar(String CPF) throws MedSystemException{
        return repositorioPaciente.buscar(CPF);
    }
}
