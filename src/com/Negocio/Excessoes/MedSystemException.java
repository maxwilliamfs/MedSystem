package com.Negocio.Excessoes;

public class MedSystemException extends Exception{
    public MedSystemException(String Mensagem, Throwable causa){
        super("ERRO: " + Mensagem + "\n Informacao Tecnica: ", causa);
    }
}
