package com.Negocio.Basicas;

import java.util.ArrayList;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Enuns.StatusConsulta;
import com.Negocio.Basicas.Secundarias.Horario;
import com.Negocio.Basicas.Secundarias.Medicamento;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
import com.Negocio.Basicas.Secundarias.Procedimento;

public class ConsultaParticular extends ConsultaAbstrata {
    //Construtor
    public ConsultaParticular(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas, int id) {
        super(medico, paciente, data, horarioInicio, horarioFim, sintomas, id);
    }
    
    //Metodos
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
