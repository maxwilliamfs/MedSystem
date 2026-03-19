package com.maxwilliam.MedSystem.model;

//Bibliotecas
import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.model.secundarias.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public class Paciente extends Pessoa {
    private String nomeConvenio;
    @NotNull(message = "Informe se ha convenio")
    private boolean convenio;
    @NotBlank(message = "Informe o tipo sanguineo")
    private String tipoSanguineo;
    private double porcentagemDescontoConvenio;
    private ArrayList<ConsultaAbstrata> prontuario;

    //Construtor
    public Paciente(Pessoa p, String nomeConvenio, String tipoSanguineo, double porcentagemDescontoConvenio, ArrayList<ConsultaAbstrata> prontuario, boolean convenio){
        super(p);
        this.setPorcentagemDescontoConvenio(porcentagemDescontoConvenio);
        this.setProntuario(prontuario);
        this.setConvenio(convenio);
        this.setnomeConvenio(nomeConvenio);
        this.setTipoSanguineo(tipoSanguineo);
    }
    public Paciente(){}
    public Paciente(String nome, String cPF, Endereco endereco, Data dataNascimento, String nomeConvenio, String tipoSanguineo, double porcentagemDescontoConvenio, ArrayList<ConsultaAbstrata> prontuario, boolean convenio) {
        this.setNome(nome);
        this.setConvenio(convenio);
        this.setCPF(cPF);
        this.setEndereco(endereco);
        this.setDataNascimento(dataNascimento);
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

    public boolean isConvenio() {
        return convenio;
    }
    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }
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
