package com.negocio.excessoes;

public class InformacaoInvalidaException extends MedSystemException{
    public InformacaoInvalidaException(String mensagem){
        super(mensagem);
    }
}
