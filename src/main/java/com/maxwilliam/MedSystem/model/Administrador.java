package com.maxwilliam.MedSystem.model;

public class Administrador extends Funcionario {
    //Construtores
    public Administrador(Funcionario f){
        super(f);
    }
    public Administrador(){
        super();
    }

    //toString
    public String toString(){
        return super.toString() + ".\n";
    }
}
