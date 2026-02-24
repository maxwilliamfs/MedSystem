package com.Dados.Interfaces;

import java.util.ArrayList;
import com.Negocio.Basicas.Paciente;
import com.Negocio.Excessoes.MedSystemException;

public interface IRepositorioPaciente {
    public void adicionar(Paciente paciente) throws MedSystemException;
    public void excluir(String CPF) throws MedSystemException;
    public void modificar(String CPF, Paciente paciente) throws MedSystemException;
    public ArrayList<Paciente> listar() throws MedSystemException;
    public Paciente buscar(String CPF) throws MedSystemException;
}
