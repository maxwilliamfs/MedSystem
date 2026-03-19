package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.Funcionario;
import com.maxwilliam.MedSystem.service.ServiceFuncionario;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public abstract class BaseFuncionarioController<T extends Funcionario> {
    @Autowired
    ServiceFuncionario serviceFuncionario;

    @PostMapping
    public T cadastrarFuncionario(@Valid @RequestBody T t) throws MedSystemException {
        serviceFuncionario.adicionar(t);
        return t;
    }
    @PutMapping("/{cpf}")
    public T modificarFuncionario(@Valid @RequestBody T t,
    @CPF(message = "Informe um CPF valido") @PathVariable String cpf)
    throws MedSystemException {
        serviceFuncionario.modificar(cpf,t);
        return t;
    }
}
