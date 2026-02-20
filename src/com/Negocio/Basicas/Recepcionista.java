package com.Negocio.Basicas;

public class Recepcionista extends Funcionario{
    //Construtor
    public Recepcionista(Pessoa p){
        super(p);
    }   

    //toString
    public String toString(){
        return super.toString() + ".\n";
    }
}
