package com.maxwilliam.MedSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.model.secundarias.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public class Pessoa implements Serializable {
    //Atributos
    @NotBlank(message = "Informe um Nome")
    private String nome;
    @NotBlank(message = "Informe um CPF")
    @CPF(message = "CPF invalido")
    @JsonProperty("cpf")
    private String cpf;
    @Valid
    @NotNull(message = "Informe um Endereco")
    private Endereco endereco;
    @Valid
    @NotNull(message = "Informe uma data")
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
    @JsonCreator
    public Pessoa(){}

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @JsonProperty("cpf")
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
