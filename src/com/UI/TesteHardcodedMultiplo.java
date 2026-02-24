package com.UI;

import java.util.ArrayList;

import com.Negocio.Basicas.*;
import com.Negocio.Basicas.Secundarias.*;
import com.Negocio.Basicas.Enuns.Especialidade;
import com.Negocio.Basicas.Enuns.GravidadeConsulta;
import com.Negocio.Basicas.Enuns.StatusConsulta;

public class TesteHardcodedMultiplo {
    public static void main(String[] args) {

        System.out.println("--- INICIANDO CARGA DE DADOS (3 DE CADA) ---\n");

        // =========================================================
        // 1. DADOS BASE (Endereços e Datas)
        // =========================================================
        Endereco end1 = new Endereco(); end1.setLogradouro("Rua A"); end1.setNumero("10"); end1.setMunicipio("Lajedo"); end1.setEstado("PE"); end1.setCep("55385-000");
        Endereco end2 = new Endereco(); end2.setLogradouro("Rua B"); end2.setNumero("20"); end2.setMunicipio("Recife"); end2.setEstado("PE"); end2.setCep("50000-000");
        Endereco end3 = new Endereco(); end3.setLogradouro("Rua C"); end3.setNumero("30"); end3.setMunicipio("Caruaru"); end3.setEstado("PE"); end3.setCep("55000-000");

        Data d1 = new Data(); d1.setDia(1); d1.setMes(1); d1.setAno(1980);
        Data d2 = new Data(); d2.setDia(15); d2.setMes(6); d2.setAno(1990);
        Data d3 = new Data(); d3.setDia(20); d3.setMes(12); d3.setAno(1995);


        // =========================================================
        // 2. ADMINISTRADORES (3x)
        // =========================================================
        Funcionario fAdm1 = new Funcionario("Carlos Chefão", "111.111.111-01", end1, d1, "adm01");
        Administrador adm1 = new Administrador(fAdm1);

        Funcionario fAdm2 = new Funcionario("Roberto Diretor", "111.111.111-02", end2, d2, "adm02");
        Administrador adm2 = new Administrador(fAdm2);

        Funcionario fAdm3 = new Funcionario("Fernanda Gerente", "111.111.111-03", end3, d3, "adm03");
        Administrador adm3 = new Administrador(fAdm3);


        // =========================================================
        // 3. ENFERMEIROS (3x)
        // =========================================================
        Funcionario fEnf1 = new Funcionario("Ana Cuidadora", "222.222.222-01", end1, d2, "enf01");
        Enfermeiro enf1 = new Enfermeiro(fEnf1, "COREM-1001");

        Funcionario fEnf2 = new Funcionario("Marcos Socorrista", "222.222.222-02", end2, d3, "enf02");
        Enfermeiro enf2 = new Enfermeiro(fEnf2, "COREM-1002");

        Funcionario fEnf3 = new Funcionario("Juliana Triagem", "222.222.222-03", end3, d1, "enf03");
        Enfermeiro enf3 = new Enfermeiro(fEnf3, "COREM-1003");


        // =========================================================
        // 4. MÉDICOS (3x)
        // =========================================================
        Funcionario fMed1 = new Funcionario("Dr. Gregory House", "333.333.333-01", end1, d1, "med01");
        Medico med1 = new Medico(fMed1, "CRM-5001", Especialidade.CLINICO);

        Funcionario fMed2 = new Funcionario("Dra. Meredith Grey", "333.333.333-02", end2, d2, "med02");
        Medico med2 = new Medico(fMed2, "CRM-5002", Especialidade.CARDIOLOGISTA);

        Funcionario fMed3 = new Funcionario("Dr. Stephen Strange", "333.333.333-03", end3, d3, "med03");
        Medico med3 = new Medico(fMed3, "CRM-5003", Especialidade.DERMATOLOGISTA);


        // =========================================================
        // 5. RECEPCIONISTAS (3x)
        // =========================================================
        Funcionario fRec1 = new Funcionario("Mariana Simpatia", "444.444.444-01", end1, d3, "rec01");
        Recepcionista rec1 = new Recepcionista(fRec1);

        Funcionario fRec2 = new Funcionario("João Atendimento", "444.444.444-02", end2, d1, "rec02");
        Recepcionista rec2 = new Recepcionista(fRec2);

        Funcionario fRec3 = new Funcionario("Carla Telefonista", "444.444.444-03", end3, d2, "rec03");
        Recepcionista rec3 = new Recepcionista(fRec3);

        // =========================================================
        // 7. PREPARAÇÃO PARA AS CONSULTAS (Pacientes, Horários, etc)
        // =========================================================

        // Criando Pacientes reaproveitando endereços e datas já existentes
        Pessoa p1 = new Pessoa("João Conveniado", "111.222.333-44", end1, d1);
        Paciente pacParticular = new Paciente(p1, "Unimed", "O+", 20.0, new ArrayList<>()); // 20% desconto

        Pessoa p2 = new Pessoa("Maria do SUS", "555.666.777-88", end2, d2);
        Paciente pacPublico = new Paciente(p2, "SUS", "A-", 0.0, new ArrayList<>());

        // Horários Padrão
        Horario hInicio = new Horario(14, 0);
        Horario hFim = new Horario(14, 30);

        // Resgatando Procedimentos da Tabela
        Procedimento hemograma = TabelaProcedimento.getListaProcedimentos().get(0);
        Procedimento raioX = TabelaProcedimento.getListaProcedimentos().get(1);
        Procedimento gesso = TabelaProcedimento.getListaProcedimentos().get(2);
        Procedimento ultrassom = TabelaProcedimento.getListaProcedimentos().get(3);
        Procedimento endoscopia = TabelaProcedimento.getListaProcedimentos().get(4);

        // Criando Medicamentos
        Medicamento dipirona = new Medicamento("Dipirona", "8 em 8 horas", "500mg");
        Medicamento ibuprofeno = new Medicamento("Ibuprofeno", "6 em 6 horas", "400mg");
        Medicamento amoxicilina = new Medicamento("Amoxicilina", "12 em 12 horas", "1 cap");
        Medicamento pomada = new Medicamento("Pomada Cicatrizante", "12 em 12 horas", "Aplicar no local");
        Medicamento dorflex = new Medicamento("Dorflex", "Se sentir dor", "1 comp");

        // =========================================================
        // CONSULTA 1: Particular (Com Dr. House - Clínico)
        // =========================================================
        ConsultaParticular c1 = new ConsultaParticular(med1, pacParticular, d1, hInicio, hFim, "Forte dor de cabeça e febre");
        c1.setId(1); 
        c1.setGravidade(GravidadeConsulta.GRAVE);
        c1.setStatus(StatusConsulta.FINALIZADA);
        c1.getProcedimentos().addAll(java.util.Arrays.asList(hemograma, raioX)); // 2 Procedimentos
        
        ArrayList<Medicamento> meds1 = new ArrayList<>(java.util.Arrays.asList(dipirona, ibuprofeno)); // 2 Medicamentos
        c1.setPrescricaoMedica(new PrescricaoMedica("Repouso absoluto por 3 dias. Retornar se a febre persistir.", meds1));

        // =========================================================
        // CONSULTA 2: Pública (Com Dra. Meredith - Cardiologista)
        // =========================================================
        ConsultaPublica c2 = new ConsultaPublica(med2, pacPublico, d2, hInicio, hFim, "Palpitações e falta de ar");
        c2.setId(2);
        c2.setGravidade(GravidadeConsulta.GRAVE);
        c2.setStatus(StatusConsulta.FINALIZADA);
        c2.getProcedimentos().addAll(java.util.Arrays.asList(hemograma, ultrassom, raioX)); // 3 Procedimentos
        
        ArrayList<Medicamento> meds2 = new ArrayList<>(java.util.Arrays.asList(dorflex, dipirona)); // 2 Medicamentos
        c2.setPrescricaoMedica(new PrescricaoMedica("Encaminhamento urgente para exames cardíacos detalhados.", meds2));

        // =========================================================
        // CONSULTA 3: Particular (Com Dr. Stephen - Dermatologista)
        // =========================================================
        ConsultaParticular c3 = new ConsultaParticular(med3, pacParticular, d3, hInicio, hFim, "Mancha vermelha na pele");
        c3.setId(3);
        c3.setGravidade(GravidadeConsulta.LEVE);
        c3.setStatus(StatusConsulta.FINALIZADA);
        c3.getProcedimentos().addAll(java.util.Arrays.asList(hemograma, ultrassom)); // 2 Procedimentos
        
        ArrayList<Medicamento> meds3 = new ArrayList<>(java.util.Arrays.asList(amoxicilina, pomada)); // 2 Medicamentos
        c3.setPrescricaoMedica(new PrescricaoMedica("Aplicar pomada na mancha 2x ao dia. Evitar sol.", meds3));

        // =========================================================
        // CONSULTA 4: Pública (Com Dr. House - Clínico)
        // =========================================================
        ConsultaPublica c4 = new ConsultaPublica(med1, pacPublico, d1, hInicio, hFim, "Queda de bicicleta, dor no braço");
        c4.setId(4);
        c4.setGravidade(GravidadeConsulta.MODERADO);
        c4.setStatus(StatusConsulta.FINALIZADA);
        c4.getProcedimentos().addAll(java.util.Arrays.asList(raioX, gesso)); // 2 Procedimentos
        
        ArrayList<Medicamento> meds4 = new ArrayList<>(java.util.Arrays.asList(ibuprofeno, dorflex)); // 2 Medicamentos
        c4.setPrescricaoMedica(new PrescricaoMedica("Braço imobilizado com gesso. Retorno em 30 dias para remoção.", meds4));

        // =========================================================
        // CONSULTA 5: Particular (Com Dra. Meredith - Cardiologista)
        // =========================================================
        ConsultaParticular c5 = new ConsultaParticular(med2, pacParticular, d2, hInicio, hFim, "Check-up de rotina do coração");
        c5.setId(5);
        c5.setGravidade(GravidadeConsulta.NAO_AVALIADA);
        c5.setStatus(StatusConsulta.FINALIZADA);
        c5.getProcedimentos().addAll(java.util.Arrays.asList(hemograma, ultrassom, endoscopia)); // 3 Procedimentos
        
        ArrayList<Medicamento> meds5 = new ArrayList<>(java.util.Arrays.asList(dipirona, dorflex)); // 2 Medicamentos
        c5.setPrescricaoMedica(new PrescricaoMedica("Paciente com exames em dia. Manter dieta balanceada.", meds5));
    }
}
