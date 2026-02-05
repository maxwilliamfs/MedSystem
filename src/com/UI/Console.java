package com.UI;

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
    }   
}
