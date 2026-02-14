package com.Negocio.Basicas;

///Bibliotecas
import java.io.Serializable;
import java.util.ArrayList;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Horario;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Enuns.StatusConsulta;

public abstract class ConsultaAbstrata implements Serializable {
    private Medico medico;
    private Paciente paciente;
    private Data data;
    private Horario horarioInicio;
    private Horario horarioFim;
    private String sintomasInciais;
    private GravidadeConsulta gravidade;
    private StatusConsulta status;
    private PrescricaoMedica prescricaoMedica;
    private int id;
    private ArrayList<Procedimento> procedimentos = new ArrayList<>();

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
    public GravidadeConsulta getGravidade() {
        return gravidade;
    }
    public void setGravidade(GravidadeConsulta gravidade) {
        this.gravidade = gravidade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    } 
    public PrescricaoMedica getPrescricaoMedica() {
        return prescricaoMedica;
    }
    public void setPrescricaoMedica(PrescricaoMedica prescricaoMedica) {
        this.prescricaoMedica = prescricaoMedica;
    }
    public String getSintomasInciais() {
        return sintomasInciais;
    }
    public void setSintomasInciais(String sintomasInciais) {
        this.sintomasInciais = sintomasInciais;
    }
}
