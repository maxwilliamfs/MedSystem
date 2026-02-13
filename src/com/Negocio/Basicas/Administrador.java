package com.Negocio.Basicas;

public class Administrador extends Funcionario {
    //Construtor
    public Administrador(Pessoa p){
        this.setNome(p.getNome());
        this.setEndereco(p.getEndereco());
        this.setDataNascimento(p.getDataNascimento());
        this.setcPF(p.getcPF());
    }
    public Administrador(){}
}
