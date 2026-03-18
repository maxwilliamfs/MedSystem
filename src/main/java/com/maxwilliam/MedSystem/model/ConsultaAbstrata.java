package com.maxwilliam.MedSystem.model;

///Bibliotecas
import java.io.Serializable;
import java.util.ArrayList;
import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.model.secundarias.Horario;
import com.maxwilliam.MedSystem.model.secundarias.Medicamento;
import com.maxwilliam.MedSystem.model.secundarias.PrescricaoMedica;
import com.maxwilliam.MedSystem.model.secundarias.Procedimento;
import com.maxwilliam.MedSystem.model.enuns.GravidadeConsulta;
import com.maxwilliam.MedSystem.model.enuns.StatusConsulta;

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
    public ConsultaAbstrata(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas) {
        this.setMedico(medico);
        this.setPaciente(paciente);
        this.setData(data);
        this.setHorarioFim(horarioFim);
        this.setHorarioInicio(horarioInicio);
        this.setSintomas(sintomas);
        this.setGravidade(GravidadeConsulta.NAO_AVALIADA);
        this.setStatus(StatusConsulta.TRIAGEM);
        ArrayList<Medicamento> meds = new ArrayList<>();
        PrescricaoMedica pres = new PrescricaoMedica("Nenhuma observacao ate o momento", meds);
        this.setPrescricaoMedica(pres);
        ArrayList<Procedimento> procedimentos = new ArrayList<>();
        this.setProcedimentos(procedimentos);
    }

    //toString
    @Override
    public String toString(){
        return "ID: " + this.getId() + ",\nNome do Medico: " + this.getMedico().getNome() + ",\nCPF do Medico: " + this.getMedico().getCPF() + ",\nNome do Paciente: " + this.getPaciente().getNome() + ",\nCPF do Paciente: " + this.getPaciente().getCPF() + ",\nData: " + this.getData() + "\nHorario inicio: " + this.getHorarioInicio() + ",\nHorario Fim: " + this.getHorarioFim() + ",\nSintomas: " + this.getSintomas() + ",\nGravidade: " + this.getGravidade() + ",\nStatus: " + this.getStatus() + ",\nObservacoes: " + this.getPrescricaoMedica().getObservacoes() + ",\n\nMedicamentos: " + printMedicamentos() + "\nProcedimentos: \n"+ printProcedimentos() + "Preco: " + printPreco() + ".\n";
    }

    //Metodos
    private String printMedicamentos(){
        if(this.getPrescricaoMedica().getMedicamentos().size() == 0){
            return "Nenhum medicamento ate o momento";
        } else {
            String printacao = "\n";
            for(Medicamento m : this.getPrescricaoMedica().getMedicamentos()){
                printacao += m.toString();
            }
            return printacao;
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
        if(this.getProcedimentos().size() == 0){
            return "Nenhum procedimento ate o momento";
        }
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
