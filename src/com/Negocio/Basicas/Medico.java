package com.Negocio.Basicas;

//Bibliotecas
import com.Negocio.Basicas.Enuns.Especialidade;

public class Medico extends Funcionario {
    private String crm;
    private Especialidade especialidade;

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
