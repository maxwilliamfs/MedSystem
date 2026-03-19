package com.maxwilliam.MedSystem.dto;
import com.maxwilliam.MedSystem.model.secundarias.PrescricaoMedica;
import com.maxwilliam.MedSystem.model.secundarias.Procedimento;
import java.util.ArrayList;

public class RealizarConsultaDTO {
    private int id;
    private ArrayList<Procedimento> procedimentos;
    private PrescricaoMedica prescricaoMedica;

    //Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<Procedimento> getProcedimentos() {
        return procedimentos;
    }
    public PrescricaoMedica getPrescricaoMedica() {
        return prescricaoMedica;
    }
    public void setPrescricaoMedica(PrescricaoMedica prescricaoMedica) {
        this.prescricaoMedica = prescricaoMedica;
    }
    public void setProcedimentos(ArrayList<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }
}
