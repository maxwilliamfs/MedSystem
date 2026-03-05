package com.negocio.basicas;

import com.negocio.basicas.secundarias.Endereco;
import com.negocio.basicas.secundarias.Data;


public class Funcionario extends Pessoa {
    private String senha;

    //toString
    @Override
    public String toString(){
        return super.toString();
    }

    //Constutor
    public Funcionario(String nome, String cPF, Endereco endereco, Data dataNascimento, String senha) {
        this.setNome(nome); 
        this.setcPF(cPF);
        this.setEndereco(endereco);
        this.setDataNascimento(dataNascimento);
        this.setSenha(senha);
    }
    public Funcionario(Funcionario f){
        super(f);
        this.setSenha(f.getSenha());
    }
    public Funcionario(){
        super();
    } 

    //Metodos
    public String toCSV(){
        return super.getCSV() + "," + this.getSenha();
    }

    //Getters e Setters
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
