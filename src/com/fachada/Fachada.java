package com.fachada;

import java.util.ArrayList;
import com.negocio.basicas.ConsultaAbstrata;
import com.negocio.basicas.Funcionario;
import com.negocio.basicas.Paciente;
import com.negocio.basicas.secundarias.PrescricaoMedica;
import com.negocio.basicas.secundarias.Procedimento;
import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.enuns.GravidadeConsulta;
import com.negocio.controladores.ControladorConsulta;
import com.negocio.controladores.ControladorFuncionario;
import com.negocio.controladores.ControladorPaciente;
import com.negocio.excessoes.MedSystemException;

public class Fachada {
    //Atributos
    private static Fachada instance = null;
    private static ControladorFuncionario controladorFuncionario = new ControladorFuncionario();
    private static ControladorConsulta controladorConsulta = new ControladorConsulta();
    private static ControladorPaciente controladorPaciente = new ControladorPaciente();

    //Metodos da Fachada
    private Fachada(){}
    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }

    //Metodos Funcionario
    public void adicionarFuncionario(Funcionario funcionario) throws MedSystemException{
        controladorFuncionario.adicionar(funcionario);
    }
    public void excluirFuncionario(String CPF) throws MedSystemException{
        controladorFuncionario.excluir(CPF);
    }
    public Funcionario logar(String login, String senha) throws MedSystemException{
        return controladorFuncionario.logar(login, senha);
    }
    public void modificarFuncionario(String CPF, Funcionario funcionario) throws MedSystemException{
        controladorFuncionario.modificar(CPF, funcionario);
    }
    public ArrayList<Funcionario> listarFuncionario() throws MedSystemException{
        return controladorFuncionario.listar();
    }
    public Funcionario buscarFuncionario(String CPF) throws MedSystemException{
        return controladorFuncionario.buscar(CPF);
    }

    //Metodos Pacientes
    public void adicionarPaciente(Paciente paciente) throws MedSystemException{
        controladorPaciente.adicionar(paciente);
    }
    public void excluirPaciente(String CPF) throws MedSystemException{
        controladorPaciente.excluir(CPF);
    }
    public void modificarPaciente(String CPF, Paciente paciente) throws MedSystemException{
        controladorPaciente.modificar(CPF, paciente);
    }
    public ArrayList<Paciente> listarPaciente() throws MedSystemException{
        return controladorPaciente.listar();
    }
    public Paciente buscarPaciente(String CPF) throws MedSystemException{
        return controladorPaciente.buscar(CPF);
    }

    //Metodos Consultas
    public void adicionarConsulta(ConsultaAbstrata consulta) throws MedSystemException{
        controladorConsulta.adicionar(consulta);
    }
    public void cancelarConsulta(int id) throws MedSystemException{
        controladorConsulta.cancelar(id);
    }
    public void modificarConsulta(int id, ConsultaAbstrata consulta) throws MedSystemException{
        controladorConsulta.modificar(id, consulta);
    }
    public ArrayList<ConsultaAbstrata> listarConsulta() throws MedSystemException{
        return controladorConsulta.listar();
    }
    public ConsultaAbstrata buscarConsulta(int id) throws MedSystemException{
        return controladorConsulta.buscar(id);
    }

    //Metodos do Enfermeiro
    public ArrayList<ConsultaAbstrata> listarTriagem() throws MedSystemException{
        return controladorConsulta.listarTriagem();
    }
    public void realizarTriagem(int id, String sintomas, GravidadeConsulta gravidade) throws MedSystemException {
        controladorConsulta.realizarTriagem(id, sintomas, gravidade);
    }

    //Metodos do Medico
    public ArrayList<ConsultaAbstrata> agendaMedica(String CPF, Data dataAgenda) throws MedSystemException {
        return controladorConsulta.agendaMedica(CPF, dataAgenda);
    }
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica) throws MedSystemException {
        controladorConsulta.realizarConsulta(id, procedimentos, prescricaoMedica);
    }



}
