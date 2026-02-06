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

        System.out.println("Bem Vindo ao MedSystem!!!");
        Leitor.linhas();
        System.out.println("Informe seu login:");
        login = Leitor.scanner.nextLine();
        System.out.println("Informe sua senha:");
        senha = Leitor.scanner.nextLine();

        try{
            Funcionario loged = Fachada.getInstance().logar(login,senha);
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
       
    }
    private static void menuEnfermeiro(){
        
    }
    private static void menuRecepcionista(){
        
    }
    
}
