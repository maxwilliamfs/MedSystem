package com.ui.javafx.recepcao;

import com.fachada.Fachada;
import com.negocio.Excessoes.InformacaoInvalidaException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Paciente;
import com.ui.javafx.Uteis;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BuscarController {

    @FXML
    private TextField txtBuscar;

    @FXML
    protected void onBuscarbtn() {
        String cpf = txtBuscar.getText();

        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            InformacaoInvalidaException ex = new InformacaoInvalidaException("Informe um CPF valido!");
            Uteis.alertaErro(ex);
            return;
        }

        try {
            Paciente p = Fachada.getInstance().buscarPaciente(cpf);
            Uteis.alertaPerfilPaciente(p);
            txtBuscar.setText("");
        } catch (MedSystemException Ex) {
            Uteis.alertaErro(Ex);
        }
    }
}