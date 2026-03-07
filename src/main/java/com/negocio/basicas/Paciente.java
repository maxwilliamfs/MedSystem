package com.negocio.basicas;

//Bibliotecas
import java.util.ArrayList;

public class Paciente extends Pessoa {
    private String nomeConvenio, tipoSanguineo;
    private double porcentagemDescontoConvenio;

    //Construtor
    public Paciente(Pessoa p, String nomeConvenio, String tipoSanguineo, double porcentagemDescontoConvenio){
        super(p);
        this.setPorcentagemDescontoConvenio(porcentagemDescontoConvenio);
        this.setnomeConvenio(nomeConvenio);
        this.setTipoSanguineo(tipoSanguineo);
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ",\nPlano de Saude: " + this.getnomeConvenio() + ",\nPorcentagem de Desconto: " + this.getPorcentagemDescontoConvenio() +"%,\nTipo Sanguineo: " + this.getTipoSanguineo() + "\n";
    }

    //Metodos
    public String toCSV(){
        return super.toCSV() + "," + this.getnomeConvenio() + "," + this.getPorcentagemDescontoConvenio() + "," + this.getTipoSanguineo();
    }

    //Getters e Setters
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    public String getnomeConvenio() {
        return nomeConvenio;
    }
    public void setnomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }
    public double getPorcentagemDescontoConvenio() {
        return porcentagemDescontoConvenio;
    }
    public void setPorcentagemDescontoConvenio(double porcentagemDescontoConvenio) {
        this.porcentagemDescontoConvenio = porcentagemDescontoConvenio;
    }
}
