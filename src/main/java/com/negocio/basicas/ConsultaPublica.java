package com.negocio.basicas;

import com.negocio.basicas.enuns.GravidadeConsulta;
import com.negocio.basicas.enuns.StatusConsulta;
import com.negocio.basicas.secundarias.Horario;
import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.secundarias.PrescricaoMedica;
import com.negocio.basicas.secundarias.Procedimento;

import java.util.ArrayList;

public class ConsultaPublica extends ConsultaAbstrata{
    //Construtores
    public ConsultaPublica(Medico medico, Paciente paciente, Data data, Horario horarioInicio, Horario horarioFim, String sintomas) {
        super(medico, paciente, data, horarioInicio, horarioFim, sintomas);
    }
    public ConsultaPublica(int id, Medico m, Paciente p, Data d, Horario hI, Horario hF, String s, GravidadeConsulta g, PrescricaoMedica pres, ArrayList<Procedimento> pros, StatusConsulta st) {
        super(id, m, p, d, hI, hF, s, g, pres, pros, st);
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
