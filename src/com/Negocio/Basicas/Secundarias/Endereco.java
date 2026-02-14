package com.Negocio.Basicas.Secundarias;

public class Endereco {
    //Atributos
    private String logradouro,municipio,estado,cep,numero;

    //toString
    public String toString(){
        return "Logradouro: " + this.getLogradouro() + ",\nMunicipio: " + this.getMunicipio() + ",\nEstado: " + this.getEstado() + ",\nNumero: " + this.getNumero() + ",\nCEP:" + this.getCep();
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