package com.ui.javafx.Recepcao;

import com.fachada.Fachada;
import com.negocio.Excessoes.InformacaoInvalidaException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Funcionario;
import com.ui.javafx.Uteis;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BuscarController {
    //Declaracoes
    @FXML
    private TextField txtBuscar;

    //Metodos
    @FXML
    protected void onBuscarbtn(){
        String cpf = txtBuscar.getText();
        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            InformacaoInvalidaException ex = new InformacaoInvalidaException("Informe um CPF valido!");
            Uteis.alertaErro(ex);
            return;
        }
        try {
            Funcionario f = Fachada.getInstance().buscarFuncionario(cpf);
            Uteis.alertaPerfilFuncionario(f);
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
}
