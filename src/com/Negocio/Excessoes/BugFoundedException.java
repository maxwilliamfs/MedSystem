package com.Negocio.Excessoes;

public class BugFoundedException extends MedSystemException{
    public BugFoundedException(String Mensagem, Throwable causa){
        super(Mensagem,causa);
    }
}
