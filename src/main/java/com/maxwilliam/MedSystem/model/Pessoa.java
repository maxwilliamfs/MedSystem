package com.maxwilliam.MedSystem.model;

import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.model.secundarias.Endereco;
import java.io.Serializable;

public class Pessoa implements Serializable {
    //Atributos
    private String nome,cpf;
    private Endereco endereco;
    private Data dataNascimento;

    //toString
    @Override
    public String toString(){
        return "Nome: " + this.getNome() + ",\nCPF: " + this.getCPF() + ",\n" + this.getEndereco().toString() + ",\nData de Nascimento: " + this.getDataNascimento().toString();
    }

    //Construtores
    public Pessoa(String nome, String cPF, Endereco endereco, Data dataNascimento) {
        this.setNome(nome); 
        this.setCPF(cPF);
        this.setEndereco(endereco);
        this.setDataNascimento(dataNascimento);
    }
    public Pessoa(Funcionario f) {
        this.setNome(f.getNome()); 
        this.setCPF(f.getCPF());
        this.setEndereco(f.getEndereco());
        this.setDataNascimento(f.getDataNascimento());
    }
    public Pessoa(Pessoa p) {
        this.setNome(p.getNome()); 
        this.setCPF(p.getCPF());
        this.setEndereco(p.getEndereco());
        this.setDataNascimento(p.getDataNascimento());
    }
    public Pessoa(){}

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return cpf;
    }
    public void setCPF(String cPF) {
        this.cpf = cPF;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Data getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
