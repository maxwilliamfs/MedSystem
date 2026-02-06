package com.UI;

//Bibliotecas
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;
import java.io.IOException;
import com.Negocio.Basicas.Pessoa;
import com.Negocio.Basicas.Secundarias.Data;
import com.Negocio.Basicas.Secundarias.Endereco;

public class Leitor {
    //Atributos
    private static Scanner scanner = new Scanner(System.in);

    //Metodos
    public static Scanner getScanner(){
        return scanner;
    }
    public static void linhas(){
        System.out.println("----------------------------------------");
    }
    public static int lerInteiros(String mensagem){
        while(true){
            System.out.println("\n" + mensagem);
            String temp = scanner.nextLine();
            int op;
            try{
                op = Integer.parseInt(temp);
                return op;
            } catch (NumberFormatException Ex){
                System.err.print("ERRO: Formato Invalido!!!!!");
                System.err.println("ERRO: Informe um Numero!!!!!");
            }
        }
    }
    public static int lerInteiros(String mensagem, int limiteInferior, int limiteSuperior){
        while(true){
            System.out.println("\n" + mensagem);
            String temp = scanner.nextLine();
            int op;
            try{
                op = Integer.parseInt(temp);
                if((op < limiteInferior || op > limiteSuperior) && op != 0){
                    System.err.println("ERRO: Numero Invalido!!!!");
                } else {
                    return op;
                }
            } catch (NumberFormatException Ex){
                System.err.print("ERRO: Formato Invalido!!!!!");
                System.err.println("ERRO: Informe um Numero!!!!!");
            }
        }
    }
    public static float lerFloats(String mensagem){
        while (true) {
            System.out.println("\n" + mensagem);
            String temp = getScanner().nextLine();
            float valor;
            try{
                valor = Float.parseFloat(temp);
                return valor;
            } catch (NumberFormatException Ex){
                System.err.println("ERRO: Formato invalido!!!");
                System.err.println("Informe um valor valido:");
            }
        }
    }
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
    public static Pessoa lerPessoa(){
        //Intancias
        Pessoa novo = new Pessoa();
        Data dataNascimento = new Data();
        Endereco endereco = new Endereco();

        //Leituras
        System.out.println("Informe o nome:");
        novo.setNome(Leitor.getScanner().nextLine());
        System.out.println("Informe o CPF:");
        novo.setcPF(Leitor.getScanner().nextLine());
        System.out.println("Informe o logradouro:");
        endereco.setLogradouro(Leitor.getScanner().nextLine());
        System.out.println("Informe o numero da residencia:");
        endereco.setNumero(Leitor.getScanner().nextLine());
        System.out.println("Informe o municipio:");
        endereco.setNumero(Leitor.getScanner().nextLine());
        System.out.println("Informe o estado:");
        endereco.setEstado(Leitor.getScanner().nextLine());
        System.out.println("Informe o CEP:");
        endereco.setCep(Leitor.getScanner().nextLine());

        //Formatacao da Data
        System.out.println("Informe a data de nascimento (Formato: DD/MM/AAAA)");
        String dataTexto = Leitor.getScanner().nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate data = LocalDate.parse(dataTexto, formato);
            dataNascimento.setDia(data.getDayOfMonth());
            dataNascimento.setMes(data.getMonthValue());
            dataNascimento.setAno(data.getYear());
        } catch (DateTimeParseException e) {
            System.out.println("ERRO: Data inválida! Use o formato dia/mês/ano.");
        }

        return novo;
    }
}
