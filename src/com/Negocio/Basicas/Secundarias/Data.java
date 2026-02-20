//Bibliotecas
package com.Negocio.Basicas.Secundarias;
import java.io.Serializable;

public class Data implements Serializable{
    //Atributos
    private int dia,mes,ano;

    //toString
    public String toString(){
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
    }

    //Getters e Setters
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    
}
