package com.negocio.basicas.secundarias;

public class Procedimento {
    //Atributos
    private String nome;
    private double preco;

    //Metodos
    public Procedimento(String nome, double preco){
        setNome(nome);
        setPreco(preco);
    }
    public String toCSV(){
        return this.getNome() + "|" + this.getPreco();
    }

    //toString
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " / Preco: " + this.getPreco() + ",\n";
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
