package com.ui.javafx;

import com.negocio.Excessoes.MedSystemException;
import javafx.scene.control.Alert;

public class Uteis {
    public static void alertaErro(MedSystemException Ex) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERRO!");
        alerta.setHeaderText(Ex.getMessage());
        alerta.setContentText(Ex.getInformacaoTecnica());
        alerta.showAndWait();
    }
}
