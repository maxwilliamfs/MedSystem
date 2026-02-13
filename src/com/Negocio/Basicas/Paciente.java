package com.Negocio.Basicas;

//Bibliotecas
import java.util.ArrayList;

public class Paciente extends Pessoa {
    private String nomeConvenio, tipoSanguineo;
    private double porcentagemDescontoConvenio;
    private ArrayList<ConsultaAbstrata> prontuario;

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
    public ArrayList<ConsultaAbstrata> getProntuario() {
        return prontuario;
    }
    public void setProntuario(ArrayList<ConsultaAbstrata> prontuario) {
        this.prontuario = prontuario;
    }
}
