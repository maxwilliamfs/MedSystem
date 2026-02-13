package com.Negocio.Basicas;

public class Enfermeiro extends Funcionario {
    private String corem;

    //Construtor
    public Enfermeiro(Pessoa p, String corem){
        this.setNome(p.getNome());
        this.setEndereco(p.getEndereco());
        this.setDataNascimento(p.getDataNascimento());
        this.setcPF(p.getcPF());
        this.setCorem(corem);
    }

    //Getters e Setters
    public String getCorem() {
        return corem;
    }
    public void setCorem(String corem) {
        this.corem = corem;
    } 
}
