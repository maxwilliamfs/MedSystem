package com.negocio.basicas.secundarias;

//Bibliotecas
import java.util.ArrayList;

public class PrescricaoMedica {
    private String observacoes;
    private ArrayList<Medicamento> medicamentos;

    //Construtor
    public PrescricaoMedica(String observacoes, ArrayList<Medicamento> medi){
        setMedicamentos(medi);
        setObservacoes(observacoes);
    }

    //Metodos
    public String toCSV(){
        String obser = this.getObservacoes().replace(",","-");
        String retorno = obser + ",";
        if(this.getMedicamentos().isEmpty()){
            retorno += "NADA";
            return retorno;
        }
        for(int i = 0; i < this.getMedicamentos().size(); i++){
            if(i == 0){
                retorno += this.getMedicamentos().get(i).toCSV();
            } else {
                retorno += "/" + this.getMedicamentos().get(i).toCSV();
            }
        }
        return retorno;
    }


    //toString
    public String toString(){
        String retorno = "Observacoes: " + this.getObservacoes() + ",\n Medicamentos:";
        for(int i = 0; i < medicamentos.size(); i++){
            retorno +=  medicamentos.get(i).toString();
        }
        return retorno;
    }

    //Getters e Setters
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
