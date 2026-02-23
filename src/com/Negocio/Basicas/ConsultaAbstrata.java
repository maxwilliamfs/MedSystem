package com.Negocio.Basicas;

///Bibliotecas
import java.io.Serializable;
import java.util.ArrayList;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Horario;
import com.Negocio.Basicas.Secundarias.Medicamento;
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
    private String sintomas;
    private GravidadeConsulta gravidade;
    private StatusConsulta status;
    private PrescricaoMedica prescricaoMedica;
    private int id;
    private ArrayList<Procedimento> procedimentos = new ArrayList<>();

    //Metodos Abstratos
    protected abstract double precoFinal();

    //Construtor
    public ConsultaAbstrata(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas, int id) {
        this.setMedico(medico);
        this.setPaciente(paciente);
        this.setData(data);
        this.setHorarioFim(horarioFim);
        this.setHorarioInicio(horarioInicio);
        this.setSintomas(sintomas);
        this.setGravidade(GravidadeConsulta.NAO_AVALIADA);
        this.setStatus(StatusConsulta.TRIAGEM);
        ArrayList<Medicamento> meds = new ArrayList<>();
        PrescricaoMedica pres = new PrescricaoMedica("", meds);
        this.setPrescricaoMedica(pres);
        this.setId(id);
        ArrayList<Procedimento> procedimentos = new ArrayList<>();
        this.setProcedimentos(procedimentos);
    }

    //toString
    @Override
    public String toString(){
        return "ID: " + this.getId() + ",\nNome do Medico: " + this.getMedico().getNome() + ",\nCPF do Medico: " + this.getMedico().getcPF() + ",\nNome do Paciente: " + this.getPaciente().getNome() + ",\nCPF do Paciente: " + this.getPaciente().getcPF() + ",\nData: " + this.getData() + "\nHorario inicio: " + this.getHorarioInicio() + ",\nHorario Fim: " + this.getHorarioFim() + ",\nSintomas: " + this.getSintomas() + ",\nGravidade: " + this.getGravidade() + ",\nStatus: " + this.getStatus() + ",\nObservacoes: " + this.getPrescricaoMedica().getObservacoes() + printMedicamentos() + ",\nProcedimentos:\n"+ printProcedimentos() + ",\n" + "Preco: " + printPreco() + ".\n";
    }

    //Metodos
    private String printMedicamentos(){
        if(this.getPrescricaoMedica().getMedicamentos().size() == 0){
            return "Nenhum medicamento foi passado ate o momento";
        } else {
            return this.getPrescricaoMedica().getMedicamentos().toString();
        }
    }
    private String printPreco(){
        if(procedimentos.size() == 0){
            return "Valor a ser calculado";
        } else {
            return "" + precoFinal();
        }
    }
    private String printProcedimentos(){
        String printacao = "";
        for(Procedimento p : procedimentos){
            printacao = printacao + p.toString();
        }
        return printacao;
    }

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
    public String getSintomas() {
        return sintomas;
    }
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
}
