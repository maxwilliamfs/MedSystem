package com.medsystem.interfacegrafica;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class HelloController {
    //Declaracoes
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;

    //Metodos
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Primeiro faça seu login!");
    }
    @FXML
    procected void onEntrarBotao(){

    }
}
