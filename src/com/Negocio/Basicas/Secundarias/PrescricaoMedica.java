package com.Negocio.Basicas.Secundarias;

//Bibliotecas
import java.util.ArrayList;

public class PrescricaoMedica {
    private String observacoes;
    private ArrayList<Medicamento> medicamentos;

    //Metodos
    public PrescricaoMedica(String obser, ArrayList<Medicamento> medi){
        setMedicamentos(medi);
        setObservacoes(obser);
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
