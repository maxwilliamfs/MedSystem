package com.ui.javafx.Recepcao;

import com.negocio.Excessoes.ErroJavaFXException;
import com.negocio.Excessoes.MedSystemException;
import com.ui.javafx.Uteis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuRecepcaoController {
    @FXML
    private StackPane pnPainelCentral;

    @FXML
    protected void onCasdastrarbtn() {
        try {
            loadTelaCentro("/com/ui/menuAdministrativo/Cadastro-view.fxml");
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
    @FXML
    protected void onListarbtn(){
        try {
            loadTelaCentro("/com/ui/menuAdministrativo/Listar-view.fxml");
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
    @FXML
    protected void onBuscarbtn(){
        try {
            loadTelaCentro("/com/ui/menuAdministrativo/Buscar-view.fxml");
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
    @FXML
    protected void onModificarbtn(){
        try {
            loadTelaCentro("/com/ui/menuAdministrativo/Modificar-view.fxml");
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
    @FXML
    protected void onRemoverBtn(){
        try {
            loadTelaCentro("/com/ui/menuAdministrativo/Remover-view.fxml");
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
    @FXML
    protected void onVoltarBtn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ui/hello-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("MedSystem - Login");
            stage.show();
        } catch (IOException Ex) {
            ErroJavaFXException Exx = new ErroJavaFXException("Falha ao voltar para a tela de login", Ex);
            Uteis.alertaErro(Exx);
        }
    }
    private void loadTelaCentro(String caminho) throws MedSystemException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent novaTela = loader.load();
            pnPainelCentral.getChildren().clear();
            pnPainelCentral.getChildren().add(novaTela);
        } catch (IOException Ex) {
            throw new ErroJavaFXException("Falha ao carregar tela", Ex);
        }
    }
}
