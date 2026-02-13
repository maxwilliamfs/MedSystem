package com.Negocio.Basicas;

public abstract class Funcionario extends Pessoa {
    private String login,senha;

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
