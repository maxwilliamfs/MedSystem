package com.ui.javafx.recepcao;

import com.fachada.Fachada;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Enfermeiro;
import com.negocio.basicas.Funcionario;
import com.negocio.basicas.Medico;
import com.negocio.basicas.Paciente;
import com.ui.javafx.Uteis;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListarController implements Initializable {
    //Declaracoes
    @FXML
    private TableView tblPacientes;
    @FXML
    private TableColumn<Paciente, String> clmNome, clmCPF, clmLogradouro,clmMunicipio,
    clmEstado,clmNomeConvenio, clmPorcentagemDesconto, clmTipoSanguineo,clmData;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        clmNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        clmCPF.setCellValueFactory(new PropertyValueFactory<>("cPF"));
        clmTipoSanguineo.setCellValueFactory(new PropertyValueFactory<>("TipoSanguineo"));
        clmNomeConvenio.setCellValueFactory(new PropertyValueFactory<>("nomeConvenio"));

        clmPorcentagemDesconto.setCellValueFactory(celula -> {
            return new SimpleStringProperty(celula.getValue().getPorcentagemDescontoConvenio() + "");
        });

        clmCPF.setCellValueFactory(celula -> {
            return new SimpleStringProperty(celula.getValue().getcPF());
        });

        clmLogradouro.setCellValueFactory(celula -> {
            String logradouro = celula.getValue().getEndereco().getLogradouro();
            return new SimpleStringProperty(logradouro);
        });

        clmMunicipio.setCellValueFactory(celula -> {
            String municipio = celula.getValue().getEndereco().getMunicipio();
            return new SimpleStringProperty(municipio);
        });

        clmEstado.setCellValueFactory(celula -> {
            String estado = celula.getValue().getEndereco().getEstado();
            return new SimpleStringProperty(estado);
        });

        clmData.setCellValueFactory(celula -> {
            String dataTexto = celula.getValue().getDataNascimento().toString();
            return new SimpleStringProperty(dataTexto);
        });

        carregarTabela();
    }
    private void carregarTabela(){
        try{
            ArrayList<Paciente> listaOriginal = Fachada.getInstance().listarPaciente();
            ObservableList<Paciente> listaParaTela = FXCollections.observableArrayList(listaOriginal);
            tblPacientes.setItems(listaParaTela);
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
}
