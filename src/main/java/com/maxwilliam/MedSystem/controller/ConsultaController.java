package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.ConsultaAbstrata;
import com.maxwilliam.MedSystem.service.ServiceConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    ServiceConsulta serviceConsulta;
    
    @GetMapping
    public ArrayList<ConsultaAbstrata> listarConsultas() throws MedSystemException {
        return serviceConsulta.listar();
    }
    @GetMapping("/{id}")
    public ConsultaAbstrata buscarConsulta(@PathVariable int id) throws MedSystemException{
        return serviceConsulta.buscar(id);
    }
    @DeleteMapping("/{id}")
    public void removerConsulta(@PathVariable int id) throws MedSystemException{
        serviceConsulta.cancelar(id);
    }
    
}
