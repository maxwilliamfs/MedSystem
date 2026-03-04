package com.negocio.Excessoes;

public class ErroNoDiscoException extends MedSystemException{
    public ErroNoDiscoException(String Mensagem, Throwable causa){
        super(Mensagem,causa);
    }
}
