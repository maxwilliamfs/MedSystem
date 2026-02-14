package com.Negocio.Basicas;

public class ConsultaParticular extends ConsultaAbstrata {
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
        if(porcentagemDesconto != 0){
            return (1 - porcentagemDesconto) * precoBruto;
        } else {
            return precoBruto;
        }
    }
}
