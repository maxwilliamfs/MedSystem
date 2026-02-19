package com.Negocio.Basicas;

//Bibliotecas
import com.Negocio.Basicas.Enuns.Especialidade;

public class Medico extends Funcionario {
    private String crm;
    private Especialidade especialidade;

    //Contrutor
    public Medico(Pessoa p, String crm, Especialidade especialidade){
        super(p);
        this.setCrm(crm);
        this.setEspecialidade(especialidade);
    }

    //ToString
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
