package com.UI;

import com.Fachada.Fachada;
import com.Negocio.Basicas.Administrador;
import com.Negocio.Basicas.Enfermeiro;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Basicas.Medico;
import com.Negocio.Basicas.Pessoa;
import com.Negocio.Basicas.Recepcionista;
import com.Negocio.Basicas.Enuns.Especialidade;
import com.Negocio.Excessoes.MedSystemException;

public class MenuAdministrador {
    public static void adicionarFuncionario(){
        Pessoa base = Leitor.lerPessoa();
        Funcionario novo = null;
        System.out.println("1 - Recepcionista");
        System.out.println("2 - Administrador");
        System.out.println("3 - Medico");
        System.out.println("4 - Enfermeiro");
        int op = Leitor.lerInteiros("Informe o tipo de funcionario para ser cadastrado:", 1, 4);
        switch (op) {
            case 1:
                novo = new Recepcionista(base);
                break;
            case 2:
                novo = new Administrador(base);
                break;
            case 3:
                novo = adicionarMedico(base);
                break;
            case 4:
                System.out.println("Informe o COREM do enfermeiro:");
                String corem = Leitor.getScanner().nextLine();
                novo = new Enfermeiro(novo, corem);
        }
        try{
            Fachada.getInstance().adicionarFuncionario(novo);
        } catch (MedSystemException Ex){
            System.err.println(Ex.getMessage());
        }
    }
    public static void listarFuncionarios(){

    }
    public static void excluirFuncionario(){

    }
    //public static Funcionario buscarFuncionario(){
    
    //}
    public static void modificarFuncionario(){

    }
    private static Medico adicionarMedico(Pessoa pessoa){
        System.out.println("Informe o CRM do medico:");
        String crm = Leitor.getScanner().nextLine();
        System.out.println("1 - CARDIOLOGISTA");
        System.out.println("2 - DERMATOLOGISTA");
        System.out.println("3 - UROLOGISTA");
        System.out.println("4 - PEDIATRA");
        System.out.println("5 - CLINICO");
        System.out.println("6 - OUTRO");
        Especialidade espe = null;
        int op = Leitor.lerInteiros("Informe a especialidade do medico", 
    1, 6);
        switch (op) {
            case 1:
                espe = Especialidade.CARDIOLOGISTA;
                break;
            case 2:
                espe = Especialidade.DERMATOLOGISTA;
                break;
            case 3:
                espe = Especialidade.UROLOGISTA;
                break;
            case 4:
                espe = Especialidade.PEDIATRA;
                break;
            case 5:
                espe = Especialidade.CLINICO;
                break;
            case 6:
                espe = Especialidade.OUTRO;
                break;
        }
        Medico medico = new Medico(pessoa, crm, espe);
        return medico;
    }
}
