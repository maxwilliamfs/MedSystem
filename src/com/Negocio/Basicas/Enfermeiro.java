package com.Negocio.Basicas;

public class Enfermeiro extends Funcionario {
    private String corem;

    //Construtor
    public Enfermeiro(Pessoa p, String corem){
        super(p);
        this.setCorem(corem);
    }

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
