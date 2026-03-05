package com.ui.javafx;

//Bibliotecas
import com.negocio.Excessoes.ErroJavaFXException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.fachada.Fachada;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    //Declaracoes
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;

    @FXML
    protected void onBtnEntrar(){
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        String caminhoNovaCena = "", tituloNovaCena = "";
        try {
            Funcionario funcionario = Fachada.getInstance().logar(usuario, senha);
            if(funcionario instanceof Medico){
                caminhoNovaCena = "/com/ui/MenuMedico-view.fxml";
                tituloNovaCena = "MedSystem - Menu Medico";
            } else if (funcionario instanceof Administrador){
                caminhoNovaCena = "/com/ui/MenuAdministrador-view.fxml";
                tituloNovaCena = "MedSystem - Menu Administrador";
            } else if (funcionario instanceof Enfermeiro){
                caminhoNovaCena = "/com/ui/MenuEnfermeiro-view.fxml";
                tituloNovaCena = "MedSystem - Menu Enfermeiro";
            } else if (funcionario instanceof Recepcionista){
                caminhoNovaCena = "/com/ui/MenuRecepcionista-view.fxml";
                tituloNovaCena = "MedSystem - Menu Recepcionista";
            }
            mudarCena(caminhoNovaCena,tituloNovaCena);
        } catch (MedSystemException Ex) {
            alertaErro(Ex);
        }
    }
    private void mudarCena(String caminho, String titulo) throws MedSystemException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent root = loader.load();
            Scene novaCena = new Scene(root);
            Stage cenaAtual = (Stage) txtUsuario.getScene().getWindow();
            cenaAtual.setTitle(titulo);
            cenaAtual.setScene(novaCena);
            cenaAtual.show();
        } catch (IOException Ex) {
            throw new ErroJavaFXException("Nao foi possivel acessar o menu!",Ex);
        }
    }
    private void alertaErro(MedSystemException Ex) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERRO!");
        alerta.setHeaderText(Ex.getMessage());
        alerta.setContentText(Ex.getInformacaoTecnica());
        alerta.showAndWait();
    }
}
