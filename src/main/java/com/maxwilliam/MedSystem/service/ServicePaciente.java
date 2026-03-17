package com.maxwilliam.MedSystem.service;

import com.maxwilliam.MedSystem.repository.interfaces.IRepositorioPaciente;
import com.maxwilliam.MedSystem.repository.repositoriosSerialize.RepositorioPacienteSerialize;
import com.maxwilliam.MedSystem.model.Paciente;
import com.maxwilliam.MedSystem.exception.InformacaoInvalidaException;
import com.maxwilliam.MedSystem.exception.InformacaoNaoEncontradaException;
import com.maxwilliam.MedSystem.exception.MedSystemException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ServicePaciente {
    //Atributos
    private IRepositorioPaciente repositorioPaciente =  new RepositorioPacienteSerialize();

    //CRUD
    public void adicionar(Paciente paciente) throws MedSystemException{
        verificarPaciente(paciente);
        try{
            repositorioPaciente.buscar(paciente.getcPF());
            throw new InformacaoInvalidaException("CPF ja existente no sistema!");
        } catch (InformacaoNaoEncontradaException Ex){
            repositorioPaciente.adicionar(paciente);
        }
        
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
