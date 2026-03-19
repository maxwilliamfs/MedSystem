package com.maxwilliam.MedSystem.model.secundarias;

//Bibliotecas
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class Endereco implements Serializable{
    //Atributos
    @NotBlank(message = "Informe o endereco completo")
    private String logradouro,municipio,estado,cep,numero;

    //toString
    public String toString(){
        return "Logradouro: " + this.getLogradouro() + ",\nMunicipio: " + this.getMunicipio() + ",\nEstado: " + this.getEstado() + ",\nNumero: " + this.getNumero() + ",\nCEP:" + this.getCep();
    }

    //Contrutor
    public Endereco(String logradouro, String Municipio, String Estado, String cep,
    String numero){
        this.setCep(cep);
        this.setEstado(estado);
        this.setLogradouro(logradouro);
        this.setMunicipio(municipio);
        this.setNumero(numero);
    }

    //Getters e Stters
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}