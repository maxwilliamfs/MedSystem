package com.Dados.Interfaces;

import java.util.ArrayList;
import com.Negocio.Basicas.ConsultaAbstrata;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.MedSystemException;

public interface IRepositorioConsulta {
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException;
    public void excluir(int id) throws MedSystemException;
    public void modificar(int id, ConsultaAbstrata consulta) throws MedSystemException;
    public ArrayList<ConsultaAbstrata> listar() throws MedSystemException;
    public ConsultaAbstrata buscar(int id) throws MedSystemException;
}
