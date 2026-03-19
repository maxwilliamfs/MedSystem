package com.maxwilliam.MedSystem.controller;
import com.maxwilliam.MedSystem.exception.MedSystemException;
import com.maxwilliam.MedSystem.model.secundarias.Data;
import com.maxwilliam.MedSystem.model.secundarias.Endereco;
import com.maxwilliam.MedSystem.service.ServicePaciente;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.maxwilliam.MedSystem.model.Paciente;

@RequestMapping("/pacientes")
@RestController
public class PacienteController {

    //Instancias
    @Autowired
    ServicePaciente servicePaciente;

    //Metodos
    @GetMapping
    public ArrayList<Paciente> listarPacientes() throws MedSystemException {
        return servicePaciente.listar();
    }
    @GetMapping("/{cpf}")
    public Paciente buscarPaciente(@CPF(message = "Informe um CPF valido")
    @PathVariable String cpf) throws MedSystemException{
        return servicePaciente.buscar(cpf);
    }
    @PostMapping()
    public Paciente cadastrarPaciente(@Valid @RequestBody Paciente novo) throws MedSystemException{
        servicePaciente.adicionar(novo);
        return novo;
    }
    @PutMapping("/{cpf}")
    public Paciente modificarPaciente(@Valid @RequestBody Paciente novo,
    @PathVariable @CPF(message = "Informe um CPF valido") String cpf)
    throws MedSystemException {
        servicePaciente.modificar(cpf,novo);
        return novo;
    }
    @DeleteMapping("/{cpf}")
    public void deletarPaciente(@PathVariable @CPF(message = "Informe um CPF valido")
    String cpf) throws MedSystemException {
        servicePaciente.excluir(cpf);
    }





}
