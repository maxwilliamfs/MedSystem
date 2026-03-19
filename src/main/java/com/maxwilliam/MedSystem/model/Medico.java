package com.maxwilliam.MedSystem.model;

//Bibliotecas
import com.fasterxml.jackson.annotation.JsonCreator;
import com.maxwilliam.MedSystem.model.enuns.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class Medico extends Funcionario {
    @NotBlank(message = "Informe um CRM")
    private String crm;
    @NotNull(message = "Informe uma especialidade")
    private Especialidade especialidade;

    //Contrutor
    public Medico(Funcionario f, String crm, Especialidade especialidade){
        super(f);
        this.setCrm(crm);
        this.setEspecialidade(especialidade);
    }
    @JsonCreator
    public Medico(){}

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
