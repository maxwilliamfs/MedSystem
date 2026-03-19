package com.maxwilliam.MedSystem.controller;

import com.maxwilliam.MedSystem.model.Administrador;
import com.maxwilliam.MedSystem.model.Medico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administradores")
public class AdministradorController extends BaseFuncionarioController<Administrador>{

}
