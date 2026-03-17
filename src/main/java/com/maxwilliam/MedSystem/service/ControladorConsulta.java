package com.maxwilliam.MedSystem.service;

//Bibliotecas
import java.util.ArrayList;
import com.dados.interfaces.IRepositorioConsulta;
import com.negocio.excessoes.InformacaoInvalidaException;
import com.negocio.excessoes.MedSystemException;
import com.dados.repositoriosSerialize.RepositorioConsultaSerialize;
import com.negocio.basicas.ConsultaAbstrata;
import com.negocio.basicas.enuns.GravidadeConsulta;
import com.negocio.basicas.enuns.StatusConsulta;
import com.negocio.basicas.secundarias.PrescricaoMedica;
import com.negocio.basicas.secundarias.Procedimento;
import com.negocio.basicas.secundarias.Data;

public class ControladorConsulta {
    //Atributos
    private IRepositorioConsulta repositorioConsulta = new RepositorioConsultaSerialize();

    //CRUD
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException{
        verificarConsulta(consulta);
        repositorioConsulta.adicionar(consulta);
    }
    public void cancelar(int id) throws MedSystemException{
        repositorioConsulta.cancelar(id);
    }
    public void modificar(int id, ConsultaAbstrata consulta) throws MedSystemException{
        verificarConsulta(consulta);
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
        ArrayList<ConsultaAbstrata> triagem = new ArrayList<>();
        ArrayList<ConsultaAbstrata> consultas = repositorioConsulta.listar();
        for(int i = 0; i < consultas.size(); i++){
            if(consultas.get(i).getData().equals(Data.getDataHoje()) && consultas.get(i).getStatus() == StatusConsulta.TRIAGEM){
                triagem.add(consultas.get(i));
            }
        }
        return triagem;
    }
    public void realizarTriagem(int id, String sintomas, GravidadeConsulta gravidade) throws MedSystemException{
        ConsultaAbstrata consulta = repositorioConsulta.buscar(id);
        consulta.setSintomas(sintomas);
        consulta.setGravidade(gravidade);
        consulta.setStatus(StatusConsulta.AGUARDANDO);
        repositorioConsulta.modificar(id, consulta);
    }

    //Metodos do Medico
    public ArrayList<ConsultaAbstrata> agendaMedica(String CPF, Data dataAgenda) throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = repositorioConsulta.listar();
        ArrayList<ConsultaAbstrata> agenda = new ArrayList<>();
        for(int i = 0; i < consultas.size(); i++){
            if(consultas.get(i).getData().equals(dataAgenda) && consultas.get(i).getMedico().getcPF().equals(CPF)){
                agenda.add(consultas.get(i));
            }
        }
        return agenda;
    }
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica) throws MedSystemException {
        ConsultaAbstrata consulta = repositorioConsulta.buscar(id);
        consulta.setProcedimentos(procedimentos);
        consulta.setPrescricaoMedica(prescricaoMedica);
        consulta.setStatus(StatusConsulta.FINALIZADA);
        repositorioConsulta.modificar(id, consulta);
    }

    //Metodos Privados
    private void verificarConsulta(ConsultaAbstrata consulta) throws MedSystemException{
        //Informacoes Basicas
        if(consulta == null){
            throw new InformacaoInvalidaException("Informacao invalida!");
        }

        //Horario
        int inicioTotal = (consulta.getHorarioInicio().getHora() * 60) + consulta.getHorarioInicio().getMinuto();
        int finalTotal = (consulta.getHorarioFim().getHora() * 60) + consulta.getHorarioFim().getMinuto();
        if(inicioTotal >= finalTotal){
            throw new InformacaoInvalidaException("Informe horarios validos!");
        }

        //Data
        if(consulta.getData().isDataPassada() || !consulta.getData().isDataValida()){
            throw new InformacaoInvalidaException("Informe uma data valida!");
        }

        //Verificacao de choque de horarios
        ArrayList<ConsultaAbstrata> consultas = repositorioConsulta.listar();
        for(int i = 0; i < consultas.size(); i++){
            
            int inicioExistente = (consultas.get(i).getHorarioInicio().getHora() * 60) + consultas.get(i).getHorarioInicio().getMinuto();
            int finalExistente = (consultas.get(i).getHorarioFim().getHora() * 60) + consultas.get(i).getHorarioFim().getMinuto();

            if(consulta.getMedico().getcPF().equals(consultas.get(i).getMedico().getcPF()) && consulta.getData().equals(consultas.get(i).getData()) && consultas.get(i).getStatus() != StatusConsulta.CANCELADA && (inicioTotal < finalExistente) && (finalTotal > inicioExistente)){

                throw new InformacaoInvalidaException("O medico informado ja tem consulta marcada para o dia e horario informado");

            } else if(consulta.getPaciente().getcPF().equals(consultas.get(i).getPaciente().getcPF()) && consulta.getData().equals(consultas.get(i).getData()) && consultas.get(i).getStatus() != StatusConsulta.CANCELADA && (inicioTotal < finalExistente) && (finalTotal > inicioExistente)){

                throw new InformacaoInvalidaException("O paciente informado ja tem consulta marcada para o dia e horario informado");
            }
        }
    }
}