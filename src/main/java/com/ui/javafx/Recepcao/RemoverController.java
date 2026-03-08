package com.ui.javafx.Recepcao;

import com.fachada.Fachada;
import com.negocio.Excessoes.InformacaoInvalidaException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Funcionario;
import com.ui.javafx.Uteis;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RemoverController {
    //Declaracoes
    @FXML
    private TextField txtRemover;

    //Metodos
    @FXML
    protected void onRemoverbtn(){
        String cpf = txtRemover.getText();
        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            InformacaoInvalidaException ex = new InformacaoInvalidaException("Informe um CPF valido!");
            Uteis.alertaErro(ex);
            return;
        }
        try {
            boolean popUp = Uteis.alertaConfirmacao("Tem certeza que deseja excluir esse funcionario?");
            if(popUp) {
                Fachada.getInstance().excluirFuncionario(cpf);
                Uteis.alertaSucesso("Funcionario removido com sucesso!");
            }
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
}
