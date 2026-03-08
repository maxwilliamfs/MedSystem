package com.ui.javafx.Admin;

import com.negocio.Excessoes.ErroJavaFXException;
import com.negocio.Excessoes.MedSystemException;
import com.ui.javafx.Uteis;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MenuAdminController {
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
    private void loadTelaCentro(String caminho) throws MedSystemException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent novaTela = loader.load();
            pnPainelCentral.getChildren().clear();
            pnPainelCentral.getChildren().add(novaTela);
        } catch (IOException Ex) {
            throw new ErroJavaFXException("Falha no cadastro", Ex);
        }
    }
}
