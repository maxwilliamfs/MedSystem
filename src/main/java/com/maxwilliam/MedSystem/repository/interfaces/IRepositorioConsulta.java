package com.maxwilliam.MedSystem.repository.interfaces;

//Bibliotecas
import java.util.ArrayList;
import com.maxwilliam.MedSystem.model.ConsultaAbstrata;
import com.maxwilliam.MedSystem.exception.MedSystemException;

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
