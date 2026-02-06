package com.Negocio.Basicas;

public class Recepcionista extends Funcionario{
    //Construtor
    public Recepcionista(Pessoa p){
        this.setNome(p.getNome());
        this.setEndereco(p.getEndereco());
        this.setDataNascimento(p.getDataNascimento());
        this.setcPF(p.getcPF());
    }   
}
