package com.Negocio.Basicas;

//Bibliotecas
import java.util.ArrayList;

public class Paciente extends Pessoa {
    private String nomeConvenio, tipoSanguineo;
    private double porcentagemDescontoConvenio;
    private ArrayList<ConsultaAbstrata> prontuario;

    //Construtor
    public Paciente(Pessoa p, String nomeConvenio, String tipoSanguineo, double porcentagemDescontoConvenio, ArrayList<ConsultaAbstrata> prontuario){
        super(p);
        this.setPorcentagemDescontoConvenio(porcentagemDescontoConvenio);
        this.setProntuario(prontuario);
        this.setnomeConvenio(nomeConvenio);
        this.setTipoSanguineo(tipoSanguineo);
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ",\nPlano de Saude: " + this.getnomeConvenio() + ",\nPorcentagem de Desconto: " + this.getPorcentagemDescontoConvenio() +"%,\nTipo Sanguineo: " + this.getTipoSanguineo() + ",\n\nProntuario: " + printProtuario() + "\n"; 
    }

    //Metodos
    private String printProtuario(){
        if(this.getProntuario().isEmpty()){
            return "Nao ha prontuario ate o momento";
        } else {
            String printacao = "";
            for(ConsultaAbstrata con : this.getProntuario()){
                printacao += "\n\n" + con ;
            }
            return printacao;
        }
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
    public ArrayList<ConsultaAbstrata> getProntuario() {
        return prontuario;
    }
    public void setProntuario(ArrayList<ConsultaAbstrata> prontuario) {
        this.prontuario = prontuario;
    }
}
