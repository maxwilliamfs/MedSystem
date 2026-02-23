package com.Negocio.Basicas.Secundarias;

public class Horario {
    //Atributos
    private int hora,minuto;

    //Construtor
    public Horario(int h, int m){
        this.setHora(h);
        this.setMinuto(m);
    }
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
