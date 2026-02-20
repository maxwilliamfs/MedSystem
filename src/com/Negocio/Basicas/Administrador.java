package com.Negocio.Basicas;

public class Administrador extends Funcionario {
    //Construtores
    public Administrador(Pessoa p){
        super(p);
    }
    public Administrador(){
        super();
    }

    //toString
    public String toString(){
        return super.toString() + ".\n";
    }
}
