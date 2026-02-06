package com.UI;

import com.Fachada.Fachada;
import com.Negocio.Basicas.Administrador;
import com.Negocio.Basicas.Enfermeiro;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Basicas.Medico;
import com.Negocio.Basicas.Recepcionista;
import com.Negocio.Excessoes.MedSystemException;

public class Console {
    public static void main(String[] args) {
        boolean repetir = true;
        while (repetir) {
            menuPrincipal();
        }
    }

    private static void menuPrincipal(){
        String login,senha;
        Leitor.clear();
        Leitor.linhas();
        System.out.println("Bem Vindo ao MedSystem!!!");
        Leitor.linhas();
        System.out.println("Informe seu login:");
        login = Leitor.getScanner().nextLine();
        System.out.println("Informe sua senha:");
        senha = Leitor.getScanner().nextLine();

        try{
            Funcionario loged = Fachada.getInstance().logar(login,senha);
            Leitor.clear();
            System.out.println("\nLogado com Sucesso!!!");
            System.out.println("Bem vindo(a), " + loged.getNome() + "!!!\n");
            if(loged instanceof Medico){
                menuMedico();
            } else if(loged instanceof Recepcionista){
                menuRecepcionista();
            } else if(loged instanceof Administrador){
                menuAdministrador();
            } else if(loged instanceof Enfermeiro){
                menuEnfermeiro();
            }
        } catch (MedSystemException Ex){
            System.err.println(Ex.getMessage());
        }
        
    }   
    private static void menuMedico(){

    }
    private static void menuAdministrador(){
        Leitor.linhas();
        System.out.println("1 - Cadastrar funcionario");
        System.out.println("2 - Listar funcionarios");
        System.out.println("3 - Modificar funcionario");
        System.out.println("4 - Buscar funcionario");
        System.out.println("5 - Excluir funcionario");
        System.out.println("6 - Voltar a tela de login");
        System.out.println("7 - Fechar programa");
        int op = Leitor.lerInteiros("Informe a opcao desejada:", 1, 7);
        switch (op) {
            case 1:
                MenuAdministrativo.adicionar();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }

    }
    private static void menuEnfermeiro(){
        
    }
    private static void menuRecepcionista(){
        
    }
    
}
