package com.ui.javafx.Admin;

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

public class ModificarController implements Initializable{
    @FXML
    private ComboBox<String> cbCargo;
    @FXML
    private ComboBox<String> cbEspecialidade;
    @FXML
    TextField txtEspecifico, txtNome,txtCPF,txtLogradouro,txtMunicipio,txtEstado,txtData,txtCPFModificar;
    @FXML
    Label lbEspecifica, lbEspecialidade;
    @FXML
    PasswordField pfSenha1,pfSenha2;

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
    @FXML
    protected void onBuscarBtn(){
        String cpf = txtCPFModificar.getText();
        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            InformacaoInvalidaException ex = new InformacaoInvalidaException("Informe um CPF valido!");
            Uteis.alertaErro(ex);
            return;
        }
        try {
            Funcionario f = Fachada.getInstance().buscarFuncionario(cpf);
            txtCPF.setText(f.getcPF());
            txtNome.setText(f.getNome());
            txtData.setText(f.getDataNascimento().toString());
            txtLogradouro.setText(f.getEndereco().getLogradouro());
            txtMunicipio.setText(f.getEndereco().getMunicipio());
            txtEstado.setText(f.getEndereco().getEstado());
            pfSenha1.setText(f.getSenha());
            pfSenha2.setText(f.getSenha());
            if(f instanceof Medico){
                cbCargo.getSelectionModel().select("Medico");
                lbEspecifica.setText("CRM");
                txtEspecifico.setVisible(true);
                txtEspecifico.setManaged(true);
                cbEspecialidade.setVisible(true);
                cbEspecialidade.setManaged(true);
                lbEspecifica.setVisible(true);
                lbEspecifica.setManaged(true);
                lbEspecialidade.setVisible(true);
                lbEspecialidade.setManaged(true);
                txtEspecifico.setText(((Medico) f).getCrm());
                cbEspecialidade.getSelectionModel().select(((Medico) f).getEspecialidade() + "");
            } else if (f instanceof Enfermeiro){
                cbCargo.getSelectionModel().select("Enfermeiro");
                lbEspecifica.setText("COREN");
                txtEspecifico.setText(((Enfermeiro) f).getCorem());
                txtEspecifico.setVisible(true);
                txtEspecifico.setManaged(true);
                lbEspecifica.setVisible(true);
                lbEspecifica.setManaged(true);
            } else if (f instanceof Administrador){
                cbCargo.getSelectionModel().select("Administrador");
            } else if (f instanceof Recepcionista){
                cbCargo.getSelectionModel().select("Recepcionista");
            }
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
    @FXML
    protected void onAvancarBtn(){
        String senha1 = pfSenha1.getText(), senha2 = pfSenha2.getText(), especifico =
        txtEspecifico.getText(), nome = txtNome.getText(), cpf = txtCPF.getText(),
        logradouro = txtLogradouro.getText(), municipio = txtMunicipio.getText(),
        estado = txtEstado.getText(), data = txtData.getText(), cargo = cbCargo.getValue(),
        especialidade = cbEspecialidade.getValue();

        if(!senha1.isBlank() && !senha2.isBlank() && !nome.isBlank() && !cpf.isBlank() &&
        !logradouro.isBlank() && !municipio.isBlank() && !estado.isBlank() && !data.isBlank()
        && cargo != null) {

            if (senha1.equals(senha2)) {

                if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {

                    if(data.matches("\\d{2}/\\d{2}/\\d{4}")){
                        String[] datas = data.split("/");
                        int di = Integer.parseInt(datas[0]), m = Integer.parseInt(datas[1]),
                        a = Integer.parseInt(datas[2]);
                        Data d = new Data(di,m,a);
                        Endereco end = new Endereco(logradouro,municipio,estado);
                        Funcionario f = new Funcionario(nome,cpf,end,d,senha2);
                        Funcionario fun = null;

                        if(cargo.equals("Adiministrador")){
                            fun = new Administrador(f);
                        } else if(cargo.equals("Recepcionista")){
                            fun = new Recepcionista(f);
                        } else if (cargo.equals("Enfermeiro")){
                            if(!especifico.isBlank()){
                               fun = new Enfermeiro(f,especifico);
                            } else {
                                erroInfo("Informe um COREN valido!");
                                return;
                            }
                        } else if(cargo.equals("Medico")){
                            if(!especifico.isBlank() && especialidade != null){
                                Especialidade e = Especialidade.valueOf(especialidade.toUpperCase());
                                fun = new Medico(f,especifico,e);
                            } else {
                                erroInfo("Especialidade ou CRM invalidos!");
                                return;
                            }
                        }
                        try {
                            Fachada.getInstance().modificarFuncionario(txtCPF.getText(),fun);
                            Uteis.alertaSucesso("Funcionario modificado com Sucesso!");
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
                erroInfo("Informe senhas iguais!");
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
