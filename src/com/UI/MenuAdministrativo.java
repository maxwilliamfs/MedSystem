package com.UI;

import com.Fachada.Fachada;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Basicas.Pessoa;
import com.Negocio.Basicas.Recepcionista;

public class MenuAdministrativo {
    public static void adicionar(){
        Pessoa base = Leitor.lerPessoa();
        Funcionario novo;
        System.out.println("Informe o tipo de funcionario para ser cadastrado:");
        System.out.println("1 - Recepcionista");
        System.out.println("2 - Administrador");
        System.out.println("3 - Medico");
        System.out.println("4 - Enfermeiro");
        int op = Leitor.lerInteiros("", 1, 4);
        switch (op) {
            case 1:
                novo = new Recepcionista(base);
                break;
            default:
                break;
        }
        Fachada.getInstance().adicionar(novo);
    }
}
