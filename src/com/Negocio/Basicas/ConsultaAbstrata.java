package com.Negocio.Basicas;

///Bibliotecas
import java.io.Serializable;
import java.util.ArrayList;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Horario;
import com.Negocio.Basicas.Secundarias.Procedimento;
import com.Negocio.Basicas.Enuns.StatusConsulta;

public abstract class ConsultaAbstrata implements Serializable {
    protected Medico medico;
    protected Paciente paciente;
    protected Data data;
    protected Horario horarioInicio;
    protected Horario horarioFim;
    protected StatusConsulta status;
    protected ArrayList<Procedimento> procedimentos = new ArrayList<>();


    //Metodos Abstratos
    protected abstract double precoFinal();

    //Getters e Setters
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public Horario getHorarioInicio() {
        return horarioInicio;
    }
    public void setHorarioInicio(Horario horarioInicio) {
        this.horarioInicio = horarioInicio;
    }
    public Horario getHorarioFim() {
        return horarioFim;
    }
    public void setHorarioFim(Horario horarioFim) {
        this.horarioFim = horarioFim;
    }
    public StatusConsulta getStatus() {
        return status;
    }
    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
    public ArrayList<Procedimento> getProcedimentos() {
        return procedimentos;
    }
    public void setProcedimentos(ArrayList<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }
}
