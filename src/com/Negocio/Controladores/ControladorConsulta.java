package com.Negocio.Controladores;

//Bibliotecas
import java.util.ArrayList;
import com.Dados.Interfaces.IRepositorioConsulta;
import com.Negocio.Excessoes.MedSystemException;
import com.Dados.RepositoriosSerialize.RepositorioConsultaSerialize;
import com.Negocio.Basicas.ConsultaAbstrata;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;
import com.Negocio.Basicas.Secundarias.Data;

public class ControladorConsulta {
    //Atributos
    IRepositorioConsulta repositorioConsulta = new RepositorioConsultaSerialize();

    //CRUD
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException{
        repositorioConsulta.adicionar(consulta);
    }
    public void cancelar(int id) throws MedSystemException{
        repositorioConsulta.cancelar(id);
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

    //Metodos Enfermeiro
    public ArrayList<ConsultaAbstrata> listarTriagem() throws MedSystemException{
        return repositorioConsulta.listarTriagem();
    }
    public void realizarTriagem(int id, String sintomas, GravidadeConsulta gravidade) throws MedSystemException{
        repositorioConsulta.realizarTriagem(id, sintomas, gravidade);
    }

    //Metodos do Medico
    public ArrayList<ConsultaAbstrata> agendaMedica(String CPF, Data dataAgenda) throws MedSystemException{
        return repositorioConsulta.agendaMedica(CPF, dataAgenda);
    }
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica) throws MedSystemException {
        repositorioConsulta.realizarConsulta(id, procedimentos, prescricaoMedica);
    }


}