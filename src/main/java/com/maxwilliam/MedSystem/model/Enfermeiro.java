package com.maxwilliam.MedSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Enfermeiro extends Funcionario {
    private String corem;

    //Construtor
    public Enfermeiro(Funcionario f, String corem){
        super(f);
        this.setCorem(corem);
    }
    @JsonCreator
    public Enfermeiro(){}

    //toString
    @Override
    public String toString(){
        return super.toString() + ",\nCOREM:" + this.getCorem() + ".\n";
    }

    //Getters e Setters
    public String getCorem() {
        return corem;
    }
    public void setCorem(String corem) {
        this.corem = corem;
    } 
}
