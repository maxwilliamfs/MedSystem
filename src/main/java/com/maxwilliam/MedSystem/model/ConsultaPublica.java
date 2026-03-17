package com.maxwilliam.MedSystem.model;

import com.maxwilliam.MedSystem.model.secundarias.Horario;
import com.maxwilliam.MedSystem.model.secundarias.Data;

public class ConsultaPublica extends ConsultaAbstrata{
    //Construtor
    public ConsultaPublica(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas) {
        super(medico, paciente, data, horarioInicio, horarioFim, sintomas);
    }

    //Metodos
    @Override
    public double precoFinal(){
        return 0;
    }
}
