package com.negocio.Excessoes;

public class MedSystemException extends Exception{
    public MedSystemException(String Mensagem, Throwable causa){
        super("ERRO: " + Mensagem , causa);
    }
    public MedSystemException(String Mensagem){
        super("ERRO: " + Mensagem + "\n");
    }
    public String getInformacaoTecnica(){
        if(this.getCause() == null){
            return "";
        } else {
            return "Informacao Tecnica: " + this.getCause().toString();
        }
    }
}
