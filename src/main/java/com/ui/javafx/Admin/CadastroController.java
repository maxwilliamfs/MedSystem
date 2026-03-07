package com.ui.javafx.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable{
    @FXML
    private ComboBox<String> cbCargo;
    @FXML
    private ComboBox<String> cbEspecialidade;
    @FXML
    TextField txtEspecifico;
    @FXML
    Label lbEspecifica, lbEspecialidade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> listaDeCargos = FXCollections.observableArrayList(
                "Administrador",
                "Medico",
                "Enfermeiro",
                "Recepcionista"
        );
        ObservableList<String> listaDeEspecialidades = FXCollections.observableArrayList(
                "Pediatra",
                "Urologista",
                "Clinico",
                "Cardiologista",
                "Dermatologista",
                "Outro"
        );
        cbEspecialidade.setItems(listaDeEspecialidades);
        cbCargo.setItems(listaDeCargos);
        esconderEspecificos();
        cbCargo.getSelectionModel().selectedItemProperty().addListener((observable, valorAntigo, valorNovo) -> {
            esconderEspecificos();
            if(valorNovo != null){
                if(valorNovo.equals("Medico")){
                    lbEspecifica.setText("CRM");
                    txtEspecifico.setVisible(true);
                    txtEspecifico.setManaged(true);
                    cbEspecialidade.setVisible(true);
                    cbEspecialidade.setManaged(true);
                    lbEspecifica.setVisible(true);
                    lbEspecifica.setManaged(true);
                    lbEspecialidade.setVisible(true);
                    lbEspecialidade.setManaged(true);
                } else if(valorNovo.equals("Enfermeiro")){
                    lbEspecifica.setText("COREN");
                    txtEspecifico.setVisible(true);
                    txtEspecifico.setManaged(true);
                    lbEspecifica.setVisible(true);
                    lbEspecifica.setManaged(true);
                }
            }
        });
    }
    private void esconderEspecificos(){
        txtEspecifico.setVisible(false);
        txtEspecifico.setManaged(false);
        cbEspecialidade.setVisible(false);
        cbEspecialidade.setManaged(false);
        lbEspecifica.setVisible(false);
        lbEspecifica.setManaged(false);
        lbEspecialidade.setVisible(false);
        lbEspecialidade.setManaged(false);
    }
    protected void onAvancarBtn(){

    }
}
