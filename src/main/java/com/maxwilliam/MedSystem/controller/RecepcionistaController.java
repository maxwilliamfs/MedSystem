package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.model.Medico;
import com.maxwilliam.MedSystem.model.Recepcionista;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recepcionistas")
public class RecepcionistaController extends BaseFuncionarioController<Recepcionista>{

}
