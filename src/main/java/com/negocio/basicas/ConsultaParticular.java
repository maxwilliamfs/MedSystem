package com.negocio.basicas;

import com.negocio.basicas.enuns.GravidadeConsulta;
import com.negocio.basicas.enuns.StatusConsulta;
import com.negocio.basicas.secundarias.Horario;
import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.secundarias.PrescricaoMedica;
import com.negocio.basicas.secundarias.Procedimento;

import java.util.ArrayList;


public class ConsultaParticular extends ConsultaAbstrata {
    //Construtores
    public ConsultaParticular(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas) {
        super(medico, paciente, data, horarioInicio, horarioFim, sintomas);
    }
    public ConsultaParticular(int id, Medico m, Paciente p, Data d, Horario hI, Horario hF, String s, GravidadeConsulta g, PrescricaoMedica pres, ArrayList<Procedimento> pros, StatusConsulta st) {
        super(id, m, p, d, hI, hF, s, g, pres, pros, st);
    }
        //Metodos
    @Override
    public String toCSV() {
        return super.toCSV() + ",Particular";
    }

    private double calcularPrecoBruto(){
        double bruto = 0;
        for(int i = 0; i < getProcedimentos().size(); i++){
            bruto += this.getProcedimentos().get(i).getPreco();
        }
        return bruto;
    }
    @Override
    public double precoFinal(){
        double porcentagemDesconto = getPaciente().getPorcentagemDescontoConvenio()/100;
        double precoBruto = calcularPrecoBruto();
        if(this.getProcedimentos().size() == 0){
            System.out.println("Valor a ser calculado");
            return -1;
        }
        if(porcentagemDesconto != 0){
            return (1 - porcentagemDesconto) * precoBruto;
        } else {
            return precoBruto;
        }
    }
}
