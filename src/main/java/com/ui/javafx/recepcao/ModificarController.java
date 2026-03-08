package com.ui.javafx.recepcao;

import com.fachada.Fachada;
import com.negocio.Excessoes.InformacaoInvalidaException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Paciente;
import com.negocio.basicas.Pessoa;
import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.secundarias.Endereco;
import com.ui.javafx.Uteis;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificarController implements Initializable {

    @FXML
    private TextField txtBusca, txtNome, txtCPF, txtLogradouro, txtMunicipio, txtEstado, txtData, txtNomeConvenio, txtPorcentagemDesconto, txtTipoSanguineo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    protected void onBuscarBtn() {
        String cpf = txtBusca.getText();
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            erroInfo("Informe um CPF valido!");
            return;
        }
        try {
            Paciente p = Fachada.getInstance().buscarPaciente(cpf);
            txtCPF.setText(p.getcPF());
            txtNome.setText(p.getNome());
            txtData.setText(p.getDataNascimento().toString());
            txtLogradouro.setText(p.getEndereco().getLogradouro());
            txtMunicipio.setText(p.getEndereco().getMunicipio());
            txtEstado.setText(p.getEndereco().getEstado());
            txtNomeConvenio.setText(p.getnomeConvenio());
            txtPorcentagemDesconto.setText(String.valueOf(p.getPorcentagemDescontoConvenio()));
            txtTipoSanguineo.setText(p.getTipoSanguineo());
        } catch (MedSystemException Ex) {
            Uteis.alertaErro(Ex);
        }
    }

    @FXML
    protected void onAvancarBtn() {
        String busca = txtBusca.getText();
        String nome = txtNome.getText();
        String cpf = txtCPF.getText();
        String logradouro = txtLogradouro.getText();
        String municipio = txtMunicipio.getText();
        String estado = txtEstado.getText();
        String data = txtData.getText();
        String convenio = txtNomeConvenio.getText();
        String descontoStr = txtPorcentagemDesconto.getText();
        String sangue = txtTipoSanguineo.getText();

        if (!nome.isBlank() && !cpf.isBlank() && !logradouro.isBlank() && !municipio.isBlank() && !estado.isBlank() && !data.isBlank() && !convenio.isBlank() && !descontoStr.isBlank() && !sangue.isBlank()) {

            if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {

                if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    try {
                        double desconto = Double.parseDouble(descontoStr);
                        String[] datas = data.split("/");
                        int di = Integer.parseInt(datas[0]);
                        int m = Integer.parseInt(datas[1]);
                        int a = Integer.parseInt(datas[2]);
                        Data d = new Data(di, m, a);
                        Endereco end = new Endereco(logradouro, municipio, estado);
                        Pessoa pe = new Pessoa(nome,cpf,end,d);
                        Paciente p = new Paciente(pe,convenio,sangue,desconto);

                        Fachada.getInstance().modificarPaciente(busca, p);
                        Uteis.alertaSucesso("Paciente modificado com Sucesso!");
                    } catch (NumberFormatException e) {
                        erroInfo("Informe um valor numerico valido para o desconto!");
                    } catch (MedSystemException Ex) {
                        Uteis.alertaErro(Ex);
                    }
                } else {
                    erroInfo("Informe uma Data no formato DD/MM/AAAA");
                }
            } else {
                erroInfo("Informe um CPF no formato XXX.XXX.XXX-XX!");
            }
        } else {
            erroInfo("Preencha todos os campos!");
        }
    }

    private void erroInfo(String mensagem) {
        InformacaoInvalidaException Ex = new InformacaoInvalidaException(mensagem);
        Uteis.alertaErro(Ex);
    }
}