package com.Negocio.Basicas.Secundarias;

public class Medicamento {
    //Atributos
    private String nome, recomendacoes;
    private double preco;
    private double dosagem;

    //Getters e Sstters
    
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
    public double getDosagem() {
        return dosagem;
    }
    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }
    public String getRecomendacoes() {
        return recomendacoes;
    }
    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }
}
