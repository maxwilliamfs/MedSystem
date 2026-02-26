package com.Negocio.Controladores;

import com.Dados.Interfaces.IRepositorioPaciente;
import com.Dados.RepositoriosSerialize.RepositorioPacienteSerialize;
import com.Negocio.Basicas.Paciente;
import com.Negocio.Excessoes.InformacaoInvalidaException;
import com.Negocio.Excessoes.MedSystemException;
import java.util.ArrayList;

public class ControladorPaciente {
    //Atributos
    private IRepositorioPaciente repositorioPaciente =  new RepositorioPacienteSerialize();

    //CRUD
    public void adicionar(Paciente paciente) throws MedSystemException{
        verificarPaciente(paciente);
        repositorioPaciente.adicionar(paciente);
    }
    public void excluir(String CPF) throws MedSystemException{
        verificarCPF(CPF);
        repositorioPaciente.excluir(CPF);
        
    }
    public void modificar(String CPF, Paciente paciente) throws MedSystemException{
        verificarPaciente(paciente);
        verificarCPF(CPF);
        repositorioPaciente.modificar(CPF, paciente);;
    }
    public ArrayList<Paciente> listar() throws MedSystemException{
        return repositorioPaciente.listar();
    }
    public Paciente buscar(String CPF) throws MedSystemException{
        verificarCPF(CPF);
        return repositorioPaciente.buscar(CPF);

    }

    //Metodos Privados
    private void verificarPaciente(Paciente paciente) throws MedSystemException {
        if(paciente == null || paciente.getNome().trim().isBlank() || paciente.getcPF().trim().isBlank() || !paciente.getDataNascimento().isDataValida()){
            throw new InformacaoInvalidaException("Informacao Invalida");
        } 
        verificarCPF(paciente.getcPF());
    }
    private void verificarCPF(String CPF) throws MedSystemException{
        if(!CPF.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new InformacaoInvalidaException("CPF em formato invalido");
        }
    }
}
