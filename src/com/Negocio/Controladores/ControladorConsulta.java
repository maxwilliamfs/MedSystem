package com.Negocio.Controladores;

import java.util.ArrayList;

import com.Dados.Interfaces.IRepositorioConsulta;
import com.Negocio.Excessoes.MedSystemException;
import com.Dados.RepositoriosSerialize.RepositorioConsultaSerialize;
import com.Negocio.Basicas.ConsultaAbstrata;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;

public class ControladorConsulta {
    //Atributos
    IRepositorioConsulta repositorioConsulta = new RepositorioConsultaSerialize();

    //CRUD
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException{
        repositorioConsulta.adicionar(consulta);
    }
    public void excluir(int id) throws MedSystemException{
        repositorioConsulta.excluir(id);
    }
    public void modificar(int id, ConsultaAbstrata consulta) throws MedSystemException{
        repositorioConsulta.modificar(id, consulta);
    }
    public ArrayList<ConsultaAbstrata> listar() throws MedSystemException{
        return repositorioConsulta.listar();
    }
    public ConsultaAbstrata buscar(int id) throws MedSystemException{
        return repositorioConsulta.buscar(id);
    }

    //Outros Metodos
    //public ArrayList<ConsultaAbstrata> listarTriagem(){}
    public void realizarTriagem(int id, String sintomas, GravidadeConsulta gravidade){}
    //Metodos do Medico
    //public ArrayList<ConsultaAbstrata> agendaMedica(String CPF){}
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica){}


}