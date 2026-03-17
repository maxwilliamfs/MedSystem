package com.negocio.basicas.secundarias;

import java.util.ArrayList;
import java.util.List;

public class TabelaProcedimento {
    static private ArrayList<Procedimento> listaProcedimentos = new ArrayList<>(List.of(
        new Procedimento("Hemograma", 50.0),
        new Procedimento("Raio-X", 300.0),
        new Procedimento("Gesso", 100.0),
        new Procedimento("Ultrassom", 150.0),
        new Procedimento("Endoscopia", 500.0)
    ));
    public static ArrayList<Procedimento> getListaProcedimentos(){
        return listaProcedimentos;
    }
}
