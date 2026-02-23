package com.Negocio.Basicas.Secundarias;

public class Medicamento {
    //Atributos
    private String nome, frequencia;
    private double dosagem;

    //toString
    @Override
    public String toString(){
        return "Nome: " + this.getNome() + "/ Dosagem:" + this.getDosagem() + "/ Frequencia" + this.getFrequencia();
    }

    //Getters e Sstters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getDosagem() {
        return dosagem;
    }
    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }
    public String getFrequencia() {
        return frequencia;
    }
    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }
}
