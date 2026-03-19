package com.maxwilliam.MedSystem.dto;

import com.maxwilliam.MedSystem.model.enuns.GravidadeConsulta;

public class RealizarTriagemDTO {
   private int id;
   private String sintomas;
   private GravidadeConsulta gravidade;

    public String getSintomas() {
        return sintomas;
    }
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
    public GravidadeConsulta getGravidade() {
        return gravidade;
    }
    public void setGravidade(GravidadeConsulta gravidade) {
        this.gravidade = gravidade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
