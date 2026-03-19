package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.model.Enfermeiro;
import com.maxwilliam.MedSystem.model.Medico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController extends BaseFuncionarioController<Enfermeiro>{

}
