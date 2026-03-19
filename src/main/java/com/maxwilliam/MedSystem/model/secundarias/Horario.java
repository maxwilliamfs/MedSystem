package com.maxwilliam.MedSystem.model.secundarias;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;

public class Horario implements Serializable {
    //Atributos
    private int hora,minuto;

    //toString
    @Override
    public String toString(){
        return "" + this.getHora() + ":" + this.getMinuto();
    }


    //Construtor
    public Horario(int h, int m){
        this.setHora(h);
        this.setMinuto(m);
    }
    @JsonCreator
    public Horario() {}
    //Getters e Stters
    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
