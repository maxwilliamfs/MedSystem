package com.maxwilliam.MedSystem.controller;
import com.maxwilliam.MedSystem.model.ConsultaParticular;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultaparticular")
public class ConsultaParticularController extends BaseConsultaController<ConsultaParticular>{
}
