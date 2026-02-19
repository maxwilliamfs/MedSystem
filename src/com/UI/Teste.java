package com.UI;

import com.Negocio.Basicas.Administrador;
import com.Negocio.Basicas.Medico;
import com.Negocio.Basicas.Pessoa;
import com.Negocio.Basicas.Recepcionista;
import com.Negocio.Basicas.Enuns.Especialidade;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Endereco;

public class Teste {
    public static void main(String[] args) {
        Endereco end1 = new Endereco();
        end1.setEstado("Pernambuco");
        end1.setCep("55385-000");
        end1.setLogradouro("Rua da Silva");
        end1.setMunicipio("Lajedo");
        end1.setNumero("184");

        Endereco end2 = new Endereco();
        end1.setEstado("Alagoas");
        end1.setCep("55555-55");
        end1.setLogradouro("Rua travessao dos macacos");
        end1.setMunicipio("Maceio");
        end1.setNumero("666");
        
        Data dat1 = new Data();
        dat1.setAno(2000);
        dat1.setMes(11);
        dat1.setDia(15);

        Data dat2 = new Data();
        dat1.setAno(2002);
        dat1.setMes(2);
        dat1.setDia(30);

        Pessoa p = new Pessoa("Julio da silva souza","123.456.789-10",end1,dat1);
        Pessoa p2 = new Pessoa("Maria pereira dos santos", "109.876.543-21", end2, dat2);
        Pessoa p3 = new Pessoa("Neymar junior cabral", "109.876.543-21", end2, dat2);
        Medico med = new Medico(p, "12345-PE", Especialidade.CARDIOLOGISTA);   
        Recepcionista rep = new Recepcionista(p2);

    }
}
