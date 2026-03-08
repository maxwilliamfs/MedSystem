package com.ui.javafx;

import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Enfermeiro;
import com.negocio.basicas.Funcionario;
import com.negocio.basicas.Medico;
import com.negocio.basicas.Paciente;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Uteis {
    public static void alertaErro(MedSystemException Ex) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERRO!");
        alerta.setHeaderText(Ex.getMessage());
        alerta.setContentText(Ex.getInformacaoTecnica());
        alerta.showAndWait();
    }
    public static void alertaSucesso(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Sucesso!");
        alerta.setHeaderText(mensagem);
        alerta.showAndWait();
    }
    public static boolean alertaConfirmacao(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Tem certeza?");
        alerta.setHeaderText(mensagem);
        Optional<ButtonType> resultado = alerta.showAndWait();
        return resultado.isPresent() && resultado.get() == ButtonType.OK;
    }
    public static void alertaPerfilFuncionario(Funcionario f) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Busca Concluída");
        alerta.setHeaderText("Funcionário Encontrado!");

        String textoPerfil =
                "Nome: " + f.getNome() + "\n" +
                        "CPF: " + f.getcPF() + "\n" +
                        "Cargo: " + f.getClass().getSimpleName() + "\n" +
                        "Data de Nasc.: " + f.getDataNascimento().toString() + "\n" +
                        "Municipio: " + f.getEndereco().getMunicipio() + "\n" +
                        "Logradouro: " + f.getEndereco().getLogradouro() + "\n" +
                        "Estado: " + f.getEndereco().getEstado();


        if (f instanceof Medico) {
            Medico m = (Medico) f;
            textoPerfil += "\nCRM: " + m.getCrm();
            textoPerfil += "\nEspecialidade: " + m.getEspecialidade().toString();

        } else if (f instanceof Enfermeiro) {
            Enfermeiro enf = (Enfermeiro) f;
            textoPerfil += "\nCOREN: " + enf.getCorem();
        }

        alerta.setContentText(textoPerfil);
        alerta.showAndWait();
    }
    public static void alertaPerfilPaciente(Paciente p) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Busca Concluída");
        alerta.setHeaderText("Paciente Encontrado!");

        String textoPerfil =
                "Nome: " + p.getNome() + "\n" +
                        "CPF: " + p.getcPF() + "\n" +
                        "Cargo: " + p.getClass().getSimpleName() + "\n" +
                        "Nome do Convenio: " + p.getnomeConvenio() + "\n" +
                        "Porcentagem de Desconto Convenio: " + p.getPorcentagemDescontoConvenio() + "%\n" +
                        "Tipo Sanguineo: " + p.getTipoSanguineo() + "\n" +
                        "Municipio: " + p.getEndereco().getMunicipio() + "\n" +
                        "Logradouro: " + p.getEndereco().getLogradouro() + "\n" +
                        "Estado: " + p.getEndereco().getEstado();
        alerta.setContentText(textoPerfil);
        alerta.showAndWait();
        }
    }
