package com.Negocio.Basicas;

import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Endereco;

public abstract class Pessoa {
    //Atributos
    protected String nome,cPF,tipoSanguineo;
    protected Endereco endereco;
    protected Data dataNascimento;

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
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
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
