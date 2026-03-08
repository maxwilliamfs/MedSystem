package com.ui.javafx.recepcao;

import com.fachada.Fachada;
import com.negocio.Excessoes.InformacaoInvalidaException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.*;
import com.negocio.basicas.enuns.Especialidade;
import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.secundarias.Endereco;
import com.ui.javafx.Uteis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController {
    @FXML
    private ComboBox<String> cbCargo;
    @FXML
    private ComboBox<String> cbEspecialidade;
    @FXML
    TextField txtNome,txtCPF,txtLogradouro,txtMunicipio,txtEstado,txtData, txtNomeConvenio,
    txtPorcentagemDesconto,txtTipoSanguineo;

    @FXML
    protected void onAvancarBtn(){
        String nomeConvenio = txtNomeConvenio.getText(), porcentagemDesc = txtPorcentagemDesconto.getText(),
        tipoSanguineo = txtTipoSanguineo.getText(), nome = txtNome.getText(), cpf = txtCPF.getText(),
        logradouro = txtLogradouro.getText(), municipio = txtMunicipio.getText(),
        estado = txtEstado.getText(), data = txtData.getText();

        if(!tipoSanguineo.isBlank() && !nome.isBlank() && !cpf.isBlank() &&
        !logradouro.isBlank() && !municipio.isBlank() && !estado.isBlank() && !data.isBlank()) {

                if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {

                    if(data.matches("\\d{2}/\\d{2}/\\d{4}")){
                        String[] datas = data.split("/");
                        int di = Integer.parseInt(datas[0]), m = Integer.parseInt(datas[1]),
                        a = Integer.parseInt(datas[2]);
                        Data d = new Data(di,m,a);
                        Endereco end = new Endereco(logradouro,municipio,estado);
                        Pessoa pe = new Pessoa(nome,cpf,end,d);
                        double porce = Double.parseDouble(porcentagemDesc);
                        Paciente p = new Paciente(pe,nomeConvenio,tipoSanguineo,porce);
                        try {
                            Fachada.getInstance().adicionarPaciente(p);
                            Uteis.alertaSucesso("Paciente cadastrado com Sucesso!");
                        } catch (MedSystemException Ex) {
                            Uteis.alertaErro(Ex);
                        }
                    } else {
                        erroInfo("Informe uma Data no formato DD/MM/AAAA");
                        return;
                    }
                } else {
                    erroInfo("Informe um CPF no formato XXX.XXX.XXX-XX!");
                    return;
                }
        } else {
            erroInfo("Preencha todos os campos!");
            return;
        }
    }
    private void erroInfo(String mensagem){
        InformacaoInvalidaException Ex = new InformacaoInvalidaException(mensagem);
        Uteis.alertaErro(Ex);
    }
}
