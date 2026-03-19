package com.maxwilliam.MedSystem.model.secundarias;

import jakarta.validation.constraints.NotBlank;

public class Medicamento {
    //Atributos
    @NotBlank(message = "Informe as informacoes do medicamento corretamente")
    private String nome, frequencia;
    @NotBlank(message = "Informe a dosagem do medicamento")
    private String dosagem;

    //toString
    @Override
    public String toString(){
        return "Nome: " + this.getNome() + " / Dosagem: " + this.getDosagem() + " / Frequencia: " + this.getFrequencia() + ",\n";
    }

    //Construtor
    public Medicamento(String nome, String frequencia, String dosagem){
        this.setDosagem(dosagem);
        this.setFrequencia(frequencia);
        this.setNome(nome);
    }

    //Getters e Sstters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDosagem() {
        return dosagem;
    }
    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }
    public String getFrequencia() {
        return frequencia;
    }
    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }
}
