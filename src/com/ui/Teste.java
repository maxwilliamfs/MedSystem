package com.ui;

/*
import java.io.IOException;
import java.util.ArrayList;
import com.Fachada.Fachada;
import com.Negocio.Basicas.ConsultaAbstrata;
import com.Negocio.Basicas.ConsultaParticular;
import com.Negocio.Basicas.Enfermeiro;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Basicas.Medico;
import com.Negocio.Basicas.Paciente;
import com.Negocio.Basicas.Pessoa;
import com.Negocio.Basicas.Recepcionista;
import com.Negocio.Basicas.Enuns.Especialidade;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Procedimento;
import com.Negocio.Basicas.Secundarias.TabelaProcedimento;
import com.Negocio.Basicas.Secundarias.Endereco;
import com.Negocio.Basicas.Secundarias.Horario;
import com.Negocio.Basicas.Secundarias.Medicamento;
import com.Negocio.Basicas.Secundarias.PrescricaoMedica;
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
        end2.setEstado("Alagoas");
        end2.setCep("55555-55");
        end2.setLogradouro("Rua travessao dos macacos");
        end2.setMunicipio("Maceio");
        end2.setNumero("666");

        Endereco end3 = new Endereco();
        end3.setEstado("Sao Paulo");
        end3.setCep("66666-66");
        end3.setLogradouro("Rua campao redondo");
        end3.setMunicipio("Sao Paulo");
        end3.setNumero("1");
        
        Data dat1 = new Data();
        dat1.setAno(2000);
        dat1.setMes(11);
        dat1.setDia(15);

        Data dat2 = new Data();
        dat2.setAno(2002);
        dat2.setMes(2);
        dat2.setDia(30);

        Data dat3 = new Data();
        dat3.setAno(2022);
        dat3.setMes(1);
        dat3.setDia(1);

        //Funcionarios
        Funcionario f = new Funcionario("Julio da silva souza","123.456.789-10",end1,dat1, "12345678");
        Funcionario f2 = new Funcionario("Maria pereira dos santos", "109.876.543-21", end2, dat2, "87654321");
        Funcionario f3 = new Funcionario("Neymar junior cabral", "109.876.543-21", end3, dat3, "Ney12345");
        Medico med = new Medico(f, "12345-PE", Especialidade.CARDIOLOGISTA);   
        Recepcionista rep = new Recepcionista(f2);
        Enfermeiro enf = new Enfermeiro(f3, "12345-SP");

        //Consultas
        Pessoa p2 = new Pessoa("Carlos Andre", "102.342.167-32", end1, dat2);
        ArrayList<ConsultaAbstrata> pront2 = new ArrayList<>();
        Paciente pa2 = new Paciente(p2, "UniMaia", "O+", 40, pront2);

        Horario h = new Horario(10,30);
        Horario h2 = new Horario(11,00);
        ConsultaParticular con = new ConsultaParticular(med, pa2, dat3, h, h2, "dor de cabeca", 1);
        Medicamento medi = new Medicamento("Dipirona", "De 8 em 8 horas", "3ml");
        Medicamento medi2 = new Medicamento("Doralgina", "De 4 em 4 horas", "1 comprimido");
        ArrayList<Medicamento> medics = new ArrayList<>();
        medics.add(medi);
        medics.add(medi2);
        ArrayList<Procedimento> proces = new ArrayList<>();
        Procedimento pro = TabelaProcedimento.getListaProcedimentos().get(2);
        Procedimento pro2 = TabelaProcedimento.getListaProcedimentos().get(1);
        proces.add(pro2);
        proces.add(pro);
        PrescricaoMedica pres = new PrescricaoMedica("Nao pode tomar sol por mais de 2 horas ao dia", medics);
        con.setPrescricaoMedica(pres);
        con.setProcedimentos(proces);

        //Pacientes
        Pessoa p = new Pessoa("Carlos Andre", "102.342.167-32", end1, dat2);
        ArrayList<ConsultaAbstrata> pront = new ArrayList<>();
        pront.add(con);
        Paciente pa = new Paciente(p, "UniMaia", "O+", 40, pront);
        pa.setProntuario(pront);

        //---------------------------Execucao-------------------------------
        clear();

    }

    //Gerais
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //Funcionarios
    public static void logFunc(String cpf, String senha){
        try{
            clear();
            System.out.println(Fachada.getInstance().logar(cpf, senha));
        } catch (MedSystemException Ex){
            System.err.println(Ex.getMessage());
        }
    }
    public static void addFunc(Funcionario f){
        try{
            Fachada.getInstance().adicionarFuncionario(f);
        } catch (MedSystemException Ex) {
            System.err.println(Ex.getMessage());
        }
    }
    public static void remfunc(String cpf){
        try{
            Fachada.getInstance().excluirFuncionario(cpf);
        } catch (MedSystemException Ex) {
            System.err.println(Ex.getMessage());
        }
    }
    public static void modfunc(String cpf,Funcionario f){
        try{
            Fachada.getInstance().modificarFuncionario(cpf,f);
        } catch (MedSystemException Ex) {
            System.err.println(Ex.getMessage());
        }
    }
    public static void busfunc(String cpf){
        clear();
        try{
            System.out.println(Fachada.getInstance().buscarFuncionario(cpf));
        } catch (MedSystemException Ex){
            System.err.println(Ex.getMessage());
        }
    }
    public static void prifunc(){
        clear();
        try{
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
*/
