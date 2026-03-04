package com.negocio.basicas;

import com.negocio.basicas.secundarias.Horario;
import com.negocio.basicas.secundarias.Data;


public class ConsultaParticular extends ConsultaAbstrata {
    //Construtor
    public ConsultaParticular(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas) {
        super(medico, paciente, data, horarioInicio, horarioFim, sintomas);
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
