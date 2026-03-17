package com.maxwilliam.MedSystem.model;

//Bibliotecas
import com.maxwilliam.MedSystem.model.enuns.Especialidade;

public class Medico extends Funcionario {
    private String crm;
    private Especialidade especialidade;

    //Contrutor
    public Medico(Funcionario f, String crm, Especialidade especialidade){
        super(f);
        this.setCrm(crm);
        this.setEspecialidade(especialidade);
    }

    //ToString
    @Override
    public String toString(){
        return super.toString() + ",\nCRM: " + this.getCrm() + ",\nEspecialidade: " + this.getEspecialidade() + ".\n";
    }
    
    //Getters e Setters
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
