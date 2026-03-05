package com.negocio.basicas;

import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.secundarias.Endereco;
import java.io.Serializable;

public class Pessoa implements Serializable {
    //Atributos
    private String nome,cPF;
    private Endereco endereco;
    private Data dataNascimento;

    //toString
    @Override
    public String toString(){
        return "Nome: " + this.getNome() + ",\nCPF: " + this.getcPF() + ",\n" + this.getEndereco().toString() + ",\nData de Nascimento: " + this.getDataNascimento().toString();
    }

    //Construtores
    public Pessoa(String nome, String cPF, Endereco endereco, Data dataNascimento) {
        this.setNome(nome); 
        this.setcPF(cPF);
        this.setEndereco(endereco);
        this.setDataNascimento(dataNascimento);
    }
    public Pessoa(Funcionario f) {
        this.setNome(f.getNome()); 
        this.setcPF(f.getcPF());
        this.setEndereco(f.getEndereco());
        this.setDataNascimento(f.getDataNascimento());
    }
    public Pessoa(Pessoa p) {
        this.setNome(p.getNome()); 
        this.setcPF(p.getcPF());
        this.setEndereco(p.getEndereco());
        this.setDataNascimento(p.getDataNascimento());
    }
    public Pessoa(){}

    //Metodos
    public String toCSV(){
        return this.getNome() + "," + this.getcPF() + "," + this.getEndereco().toCSV() + "," + this.getDataNascimento().toCSV();
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getcPF() {
        return cPF;
    }
    public void setcPF(String cPF) {
        this.cPF = cPF;
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
