package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.model.ConsultaPublica;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultapublica")
public class ConsultaPublicaController extends BaseConsultaController<ConsultaPublica>{
}
