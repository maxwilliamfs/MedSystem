package com.negocio.basicas;

import com.negocio.basicas.secundarias.Horario;
import com.negocio.basicas.secundarias.Data;

public class ConsultaPublica extends ConsultaAbstrata{
    //Construtor
    public ConsultaPublica(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas) {
        super(medico, paciente, data, horarioInicio, horarioFim, sintomas);
    }

    //Metodos
    @Override
    public String toCSV() {
        return super.toCSV() + ",Publica";
    }

    @Override
    public double precoFinal(){
        return 0;
    }
}
