package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.dto.RealizarTriagemDTO;
import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.ConsultaAbstrata;
import com.maxwilliam.MedSystem.model.Enfermeiro;
import com.maxwilliam.MedSystem.model.Medico;
import com.maxwilliam.MedSystem.service.ServiceConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController extends BaseFuncionarioController<Enfermeiro>{
    @Autowired
    ServiceConsulta serviceConsulta;

    @GetMapping("/listartriagem")
    public ArrayList<ConsultaAbstrata> listarTriagem() throws MedSystemException {
        return serviceConsulta.listarTriagem();
    }

    @PutMapping("/realizartriagem")
    public void realizarTriagem(@Valid @RequestBody RealizarTriagemDTO dados) throws MedSystemException{
        serviceConsulta.realizarTriagem(dados.getId(),dados.getSintomas(),dados.getGravidade());
    }

}
