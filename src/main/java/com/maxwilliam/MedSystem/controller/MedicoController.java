package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.dto.RealizarConsultaDTO;
import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.ConsultaAbstrata;
import com.maxwilliam.MedSystem.model.Medico;
import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.service.ServiceConsulta;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/medicos")
public class MedicoController extends BaseFuncionarioController<Medico> {

    @Autowired
    ServiceConsulta serviceConsulta;

    @GetMapping("/{cpf}/{dia}/{mes}/{ano}/agenda")
    public ArrayList<ConsultaAbstrata> verAgenda(@PathVariable
    @CPF(message = "Informe um CPF valido") String cpf, @PathVariable int dia,
    @PathVariable int mes, @PathVariable int ano) throws MedSystemException {
        Data d = new Data(dia, mes, ano);
        return serviceConsulta.agendaMedica(cpf, d);
    }

    @PutMapping("/realizarConsulta")
    public void realizarConsulta(@RequestBody RealizarConsultaDTO dados) throws
            MedSystemException {
        serviceConsulta.realizarConsulta(dados.getId(), dados.getProcedimentos()
                , dados.getPrescricaoMedica());
    }
}

