package com.UI;

import java.util.ArrayList;

import com.Fachada.Fachada;
import com.Negocio.Basicas.Administrador;
import com.Negocio.Basicas.Enfermeiro;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Basicas.Medico;
import com.Negocio.Basicas.Pessoa;
import com.Negocio.Basicas.Recepcionista;
import com.Negocio.Basicas.Enuns.Especialidade;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Endereco;
import com.Negocio.Excessoes.MedSystemException;

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

        Endereco end3 = new Endereco();
        end1.setEstado("Sao Paulo");
        end1.setCep("66666-66");
        end1.setLogradouro("Rua campao redondo");
        end1.setMunicipio("Sao Paulo");
        end1.setNumero("1");
        
        Data dat1 = new Data();
        dat1.setAno(2000);
        dat1.setMes(11);
        dat1.setDia(15);

        Data dat2 = new Data();
        dat1.setAno(2002);
        dat1.setMes(2);
        dat1.setDia(30);

        Data dat3 = new Data();
        dat1.setAno(2022);
        dat1.setMes(1);
        dat1.setDia(1);

        Pessoa p = new Pessoa("Julio da silva souza","123.456.789-10",end1,dat1);
        Pessoa p2 = new Pessoa("Maria pereira dos santos", "109.876.543-21", end2, dat2);
        Pessoa p3 = new Pessoa("Neymar junior cabral", "109.876.543-21", end3, dat3);
        Medico med = new Medico(p, "12345-PE", Especialidade.CARDIOLOGISTA);   
        Recepcionista rep = new Recepcionista(p2);
        Enfermeiro enf = new Enfermeiro(rep, "12345-SP");

        //Execucao
        try{
            Fachada.getInstance().adicionarFuncionario(med);
            Fachada.getInstance().adicionarFuncionario(rep);
            Fachada.getInstance().adicionarFuncionario(enf);
            ArrayList<Funcionario> funcs = new ArrayList<>();
            funcs = Fachada.getInstance().listarFuncionario();
            for(int i = 0; i < funcs.size(); i++){
                System.out.println(funcs.get(i));
            }
        } catch (MedSystemException Ex) {
            System.err.println(Ex.getMessage());
        }
    }
}
