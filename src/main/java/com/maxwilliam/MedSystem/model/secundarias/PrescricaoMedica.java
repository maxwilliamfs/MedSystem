package com.maxwilliam.MedSystem.model.secundarias;

//Bibliotecas
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public class PrescricaoMedica {
    @NotBlank(message = "Informe as observacoes")
    private String observacoes;
    @NotNull(message = "Informe os medicamentos")
    private ArrayList<Medicamento> medicamentos;

    //Metodos
    public PrescricaoMedica(String observacoes, ArrayList<Medicamento> medi){
        setMedicamentos(medi);
        setObservacoes(observacoes);
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
