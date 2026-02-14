package com.Fachada;

import java.util.ArrayList;

import com.Negocio.Basicas.ConsultaAbstrata;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Basicas.Paciente;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Controladores.ControladorFuncionario;
import com.Negocio.Excessoes.MedSystemException;

public class Fachada {
    //Atributos
    private static Fachada instance = null;
    private static ControladorFuncionario controladorFuncionario = new ControladorFuncionario();

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
    public void adicionarPaciente(Paciente paciente) throws MedSystemException{}
    public void excluirPaciente(String CPF) throws MedSystemException{}
    public void modificarPaciente(String CPF, Paciente paciente) throws MedSystemException{}
    //public ArrayList<Paciente> listarPaciente() throws MedSystemException{}
    //public Paciente buscarPaciente(String CPF) throws MedSystemException{}

    //Metodos Consultas
    public void adicionarConsulta(ConsultaAbstrata consulta) throws MedSystemException{}
    public void excluirConsulta(String CPF) throws MedSystemException{}
    public void modificarConsulta(String CPF, ConsultaAbstrata consulta) throws MedSystemException{}
    //public ArrayList<ConsultaAbstrata> listarConsulta() throws MedSystemException{}
    //public ConsultaAbstrata buscarConsulta(String CPF) throws MedSystemException{}

    //Metodos do Enfermeiro
    //public ArrayList<ConsultaAbstrata> listarTriagem(){}
    public void realizarTriagem(int id, String sintomas, GravidadeConsulta gravidade){}

    //Metodos do Medico
    //public ArrayList<ConsultaAbstrata> agendaMedica(String CPF){}
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica){}



}
