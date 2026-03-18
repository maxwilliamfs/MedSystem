//Bibliotecas
package com.maxwilliam.MedSystem.model.secundarias;
import java.io.Serializable;
import java.time.LocalDate;

public class Data implements Serializable{
    //Atributos
    private int dia,mes,ano;
    //Construtor
    public Data (int dia, int mes, int ano){
        this.setAno(ano);
        this.setDia(dia);
        this.setMes(mes);
    }
    public Data(){}
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
    public boolean isDataValida(){
        try {
            LocalDate dataDigitada = LocalDate.of(this.getAno(), this.getMes(), this.getDia());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isDataPassada() {
        LocalDate dataDigitada = LocalDate.of(this.getAno(), this.getMes(), this.getDia());
        LocalDate hoje = LocalDate.now();
        return dataDigitada.isBefore(hoje);
    }
    public boolean isDataFutura() {
        LocalDate dataDigitada = LocalDate.of(this.getAno(), this.getMes(), this.getDia());
        LocalDate hoje = LocalDate.now();
        return dataDigitada.isAfter(hoje);
    }
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
