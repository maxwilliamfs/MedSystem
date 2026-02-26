//Bibliotecas
package com.Negocio.Basicas.Secundarias;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Data implements Serializable{
    //Atributos
    private int dia,mes,ano;

    //toString
    public String toString(){
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
    }
    //Equals
    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Data d = (Data) obj;
        if(this.getDia() == d.getDia() && this.getMes() == d.getMes() && this.getAno() == d.getAno()){
            return true;
        } else {
            return false;
        }
    }

    //Metodos
    public static Data getDataHoje(){
        Data hoje = new Data();
        LocalDate sistema = LocalDate.now();
        hoje.setDia(sistema.getDayOfMonth());
        hoje.setMes(sistema.getMonthValue());
        hoje.setAno(sistema.getYear());
        return hoje;
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
