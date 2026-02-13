package com.Negocio.Basicas;

public class ConsultaParticular extends ConsultaAbstrata {
    //Metodos
    private double calcularPrecoBruto(){
        double bruto = 0;
        for(int i = 0; i < procedimentos.size(); i++){
            bruto += procedimentos.get(i).getPreco();
        }
        return bruto;
    }
    @Override
    public double precoFinal(){
        double porcentagemDesconto = paciente.getPorcentagemDescontoConvenio()/100;
        double precoBruto = calcularPrecoBruto();
        if(porcentagemDesconto != 0){
            return (1 - porcentagemDesconto) * precoBruto;
        } else {
            return precoBruto;
        }
    }
}
