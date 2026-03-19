package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.Funcionario;
import com.maxwilliam.MedSystem.service.ServiceFuncionario;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
    //Instancias
    @Autowired
    ServiceFuncionario serviceFuncionario;

    @GetMapping
    public ArrayList<Funcionario> listaFuncionarios() throws MedSystemException {
        return serviceFuncionario.listar();
    }
    @GetMapping("/{cpf}")
    public Funcionario buscarFuncionario(@CPF(message = "Informe um CPF valido")
    @PathVariable String cpf) throws MedSystemException{
        return serviceFuncionario.buscar(cpf);
    }
    @DeleteMapping("/{cpf}")
    public void deletarFuncionario(@PathVariable String cpf) throws MedSystemException{
        serviceFuncionario.excluir(cpf);
    }
}
