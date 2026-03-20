package com.maxwilliam.MedSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.model.secundarias.Endereco;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class Funcionario extends Pessoa implements UserDetails {
    @NotBlank(message = "Informe uma senha")
    private String senha;

    //toString
    @Override
    public String toString(){
        return super.toString();
    }

    //Constutor
    public Funcionario(String nome, String cPF, Endereco endereco, Data dataNascimento, String senha) {
        this.setNome(nome); 
        this.setCPF(cPF);
        this.setEndereco(endereco);
        this.setDataNascimento(dataNascimento);
        this.setSenha(senha);
    }
    public Funcionario(Funcionario f){
        super(f);
        this.setSenha(f.getSenha());
    }
    @JsonCreator
    public Funcionario(){
        super();
    }

    //Metodos
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword(){
        return this.getSenha();
    }
    @Override
    public String getUsername(){
        return this.getCPF();
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }

    //Getters e Setters
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
