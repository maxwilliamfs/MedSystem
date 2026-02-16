package com.Negocio.Controladores;

import java.util.ArrayList;

import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;

public class ControladorConsulta {

    //CRUD
    /*public void adicionar(Consulta consulta) throws MedSystemException{
        repositorioConsulta.adicionar(consulta);
    }
    public void excluir(String CPF) throws MedSystemException{
        repositorioConsulta.excluir(CPF);
    }
    public Consulta logar(String login, String senha) throws MedSystemException{
        return repositorioConsulta.logar(login, senha);
    }
    public void modificar(String CPF, Consulta consulta) throws MedSystemException{
        repositorioConsulta.modificar(CPF, consulta);
    }
    public ArrayList<Consulta> listar() throws MedSystemException{
        return repositorioConsulta.listar();
    }
    public Consulta buscar(String CPF) throws MedSystemException{
        return repositorioConsulta.buscar(CPF);
    }*/

    //Outros Metodos
    //public ArrayList<ConsultaAbstrata> listarTriagem(){}
    public void realizarTriagem(int id, String sintomas, GravidadeConsulta gravidade){}
    //Metodos do Medico
    //public ArrayList<ConsultaAbstrata> agendaMedica(String CPF){}
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica){}


}