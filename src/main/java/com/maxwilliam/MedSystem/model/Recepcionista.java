package com.maxwilliam.MedSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Recepcionista extends Funcionario{
    //Construtor
    public Recepcionista(Funcionario f){
        super(f);
    }
    @JsonCreator
    public Recepcionista(){}

    //toString
    @Override
    public String toString(){
        return super.toString() + ".\n";
    }
}
