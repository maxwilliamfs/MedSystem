package com.Dados.Interfaces;

//Bibliotecas
import java.util.ArrayList;
import com.Negocio.Basicas.ConsultaAbstrata;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;
import com.Negocio.Excessoes.MedSystemException;

public interface IRepositorioConsulta {
    //CRUD
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException;
    public void cancelar(int id) throws MedSystemException;
    public void modificar(int id, ConsultaAbstrata consulta) throws MedSystemException;
    public ArrayList<ConsultaAbstrata> listar() throws MedSystemException;
    public ConsultaAbstrata buscar(int id) throws MedSystemException;

    //Especiais
    public int buscarID(int id, ArrayList<ConsultaAbstrata> consultas) throws MedSystemException;
}
