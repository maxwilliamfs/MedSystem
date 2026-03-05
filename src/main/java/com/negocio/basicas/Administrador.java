package com.negocio.basicas;

public class Administrador extends Funcionario {
    //Construtores
    public Administrador(Funcionario f){
        super(f);
    }
    public Administrador(){
        super();
    }

    //Metodos
    @Override
    public String toCSV(){
        return super.toCSV() + ",Administrador";
    }

    //toString
    public String toString(){
        return super.toString() + ".\n";
    }
}
