package com.Negocio.Excessoes;

public class BugFoundException extends MedSystemException{
    public BugFoundException(String Mensagem, Throwable causa){
        super(Mensagem,causa);
    }
}
