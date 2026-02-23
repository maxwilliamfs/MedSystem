package com.Negocio.Basicas.Secundarias;

//Bibliotecas
import java.util.ArrayList;

public class PrescricaoMedica {
    private String observacoes;
    private ArrayList<Medicamento> medicamentos;

    //Metodos
    public PrescricaoMedica(String observacoes, ArrayList<Medicamento> medi){
        setMedicamentos(medi);
        setObservacoes(observacoes);
    }

    //toString
    public String PrescricaoMedica(){
        String retorno = "Observacoes: " + this.getObservacoes() + ",\n Medicamentos:";
        for(int i = 0; i < medicamentos.size(); i++){
            if(i != 0){
                retorno += ",\n";
            }
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
