package com.Negocio.Basicas.Secundarias;

import java.util.ArrayList;
import java.util.List;

public class Procedimento {
    //Atributos
    private String nome;
    private double preco;

    //Metodos
    public Procedimento(String nome, double preco){
        setNome(nome);
        setPreco(preco);
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
