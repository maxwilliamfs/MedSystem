package com.maxwilliam.MedSystem.model;

public class Recepcionista extends Funcionario{
    //Construtor
    public Recepcionista(Funcionario f){
        super(f);
    }   

    //toString
    @Override
    public String toString(){
        return super.toString() + ".\n";
    }
}
