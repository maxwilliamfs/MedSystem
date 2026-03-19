package com.maxwilliam.MedSystem.controller;
import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.ConsultaAbstrata;
import com.maxwilliam.MedSystem.service.ServiceConsulta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseConsultaController <T extends ConsultaAbstrata>{
    @Autowired
    ServiceConsulta serviceConsulta;

    @PostMapping
    public T adicionarConsulta(@Valid @RequestBody T c)
            throws MedSystemException {
        serviceConsulta.adicionar(c);
        return c;
    }

    @PutMapping("/{id}")
    public T modificarConsulta(@Valid @RequestBody T c, @PathVariable int id)
    throws MedSystemException{
        serviceConsulta.modificar(id,c);
        return c;
    }
}
