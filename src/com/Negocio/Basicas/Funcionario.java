package com.Negocio.Basicas;

public class Funcionario extends Pessoa {
    private String login,senha;

    //toString
    public String toString(){
        return super.toString();
    }

    //Constutor
    public Funcionario(Pessoa p){
        super(p);
    }
    public Funcionario(){
        super();
    } 

    //Getters e Setters
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
