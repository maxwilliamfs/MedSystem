package com.negocio.basicas.secundarias;

//Bibliotecas
import java.io.Serializable;

public class Endereco implements Serializable{
    //Atributos
    private String logradouro,municipio,estado;

    //Construtor
    public Endereco(String logradouro, String municipio, String estado){
        this.setLogradouro(logradouro);
        this.setMunicipio(municipio);
        this.setEstado(estado);
    }

    //toString
    public String toString(){
        return "Logradouro: " + this.getLogradouro() + ",\nMunicipio: " + this.getMunicipio() + ",\nEstado: " + this.getEstado();
    }

    //Metodos
    public String toCSV(){
        return this.getLogradouro() + "," + this.getMunicipio() + "," + this.getEstado();
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
}