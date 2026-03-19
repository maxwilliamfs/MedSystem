package com.maxwilliam.MedSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Administrador extends Funcionario {
    //Construtores
    public Administrador(Funcionario f){
        super(f);
    }
    @JsonCreator
    public Administrador(){
        super();
    }

    //toString
    public String toString(){
        return super.toString() + ".\n";
    }
}
