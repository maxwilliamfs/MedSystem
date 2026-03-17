package com.negocio.excessoes;

public class BugFoundException extends MedSystemException{
    public BugFoundException(String Mensagem, Throwable causa){
        super(Mensagem,causa);
    }
}
