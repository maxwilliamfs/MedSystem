package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.Funcionario;
import com.maxwilliam.MedSystem.service.ServiceFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public abstract class BaseFuncionarioController<T extends Funcionario> {
    @Autowired
    ServiceFuncionario serviceFuncionario;

    @PostMapping
    public T cadastrarFuncionario(@RequestBody T t) throws MedSystemException {
        serviceFuncionario.adicionar(t);
        return t;
    }
    @PutMapping("/{cpf}")
    public T modificarFuncionario(@RequestBody T t, @PathVariable String cpf)
    throws MedSystemException {
        serviceFuncionario.modificar(cpf,t);
        return t;
    }
}
