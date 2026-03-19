package com.maxwilliam.MedSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.model.secundarias.Endereco;
import jakarta.validation.constraints.NotBlank;


public class Funcionario extends Pessoa {
    @NotBlank(message = "Informe uma senha")
    private String senha;

    //toString
    @Override
    public String toString(){
        return super.toString();
    }

    //Constutor
    public Funcionario(String nome, String cPF, Endereco endereco, Data dataNascimento, String senha) {
        this.setNome(nome); 
        this.setCPF(cPF);
        this.setEndereco(endereco);
        this.setDataNascimento(dataNascimento);
        this.setSenha(senha);
    }
    public Funcionario(Funcionario f){
        super(f);
        this.setSenha(f.getSenha());
    }
    @JsonCreator
    public Funcionario(){
        super();
    } 

    //Getters e Setters
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
