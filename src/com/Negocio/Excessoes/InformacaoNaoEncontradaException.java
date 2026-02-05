package com.Negocio.Excessoes;

public class InformacaoNaoEncontradaException extends MedSystemException{
    public InformacaoNaoEncontradaException(String Mensagem, Throwable causa){
        super(Mensagem,causa);
    }
}
