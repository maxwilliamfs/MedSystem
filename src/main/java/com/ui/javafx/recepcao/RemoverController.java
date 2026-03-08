package com.ui.javafx.recepcao;

import com.fachada.Fachada;
import com.negocio.Excessoes.InformacaoInvalidaException;
import com.negocio.Excessoes.MedSystemException;
import com.ui.javafx.Uteis;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RemoverController {

    @FXML
    private TextField txtRemover;

    @FXML
    protected void onRemoverbtn(){
        String cpf = txtRemover.getText();

        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            InformacaoInvalidaException ex = new InformacaoInvalidaException("Informe um CPF valido!");
            Uteis.alertaErro(ex);
            return;
        }

        try {
            boolean popUp = Uteis.alertaConfirmacao("Tem certeza que deseja excluir esse paciente?");
            if(popUp) {
                Fachada.getInstance().excluirPaciente(cpf);
                Uteis.alertaSucesso("Paciente removido com sucesso!");
                txtRemover.setText("");
            }
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
}