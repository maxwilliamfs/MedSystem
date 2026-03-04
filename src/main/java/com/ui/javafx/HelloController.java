package com.ui.javafx;

//Bibliotecas
import com.negocio.Excessoes.MedSystemException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.fachada.Fachada;
import com.negocio.basicas.Funcionario;

public class HelloController {
    //Declaracoes
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;

    @FXML
    protected void onBtnEntrar(){
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        try {
            Funcionario funcionario = Fachada.getInstance().logar(usuario, senha);
        } catch (MedSystemException Ex){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERRO NO LOGIN");
            alerta.setHeaderText(Ex.getMessage());
            alerta.setContentText(Ex.getInformacaoTecnica());
            alerta.showAndWait();
        }
    }
}
