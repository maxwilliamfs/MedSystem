package com.negocio.basicas;

public class Enfermeiro extends Funcionario {
    private String corem;

    //Construtor
    public Enfermeiro(Funcionario f, String corem){
        super(f);
        this.setCorem(corem);
    }

    //toString
    @Override
    public String toString(){
        return super.toString() + ",\nCOREM:" + this.getCorem() + ".\n";
    }

    //Metodos
    @Override
    public String toCSV(){
        return super.toCSV() + ",Enfermeiro," + this.getCorem();
    }

    //Getters e Setters
    public String getCorem() {
        return corem;
    }
    public void setCorem(String corem) {
        this.corem = corem;
    } 
}
