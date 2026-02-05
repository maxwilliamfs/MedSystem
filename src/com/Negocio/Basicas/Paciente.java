package com.Negocio.Basicas;

//Bibliotecas
import java.util.ArrayList;

public class Paciente extends Pessoa {
    private String nomePlanoDeSaude;
    private double porcentagemDescontoPlano;
    private ArrayList<ConsultaAbstrata> prontuario;

    //Getters e Setters
    public String getNomePlanoDeSaude() {
        return nomePlanoDeSaude;
    }
    public void setNomePlanoDeSaude(String nomePlanoDeSaude) {
        this.nomePlanoDeSaude = nomePlanoDeSaude;
    }
    public double getPorcentagemDescontoPlano() {
        return porcentagemDescontoPlano;
    }
    public void setPorcentagemDescontoPlano(double porcentagemDescontoPlano) {
        this.porcentagemDescontoPlano = porcentagemDescontoPlano;
    }
    public ArrayList<ConsultaAbstrata> getProntuario() {
        return prontuario;
    }
    public void setProntuario(ArrayList<ConsultaAbstrata> prontuario) {
        this.prontuario = prontuario;
    }
}
