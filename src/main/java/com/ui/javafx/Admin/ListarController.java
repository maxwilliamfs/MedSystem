package com.ui.javafx.Admin;

import com.fachada.Fachada;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.Enfermeiro;
import com.negocio.basicas.Funcionario;
import com.negocio.basicas.Medico;
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
    private TableView tblFuncionarios;
    @FXML
    private TableColumn<Funcionario, String> clmNome, clmCPF, clmLogradouro,clmMunicipio,
    clmEstado,clmCRM,clmCOREN,clmData,clmEspecialidade, clmCargo;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        clmNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        clmCPF.setCellValueFactory(new PropertyValueFactory<>("cPF"));

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

        clmCargo.setCellValueFactory(celula -> {
            Funcionario f = celula.getValue();
            return new SimpleStringProperty(f.getClass().getSimpleName());
        });

        clmCRM.setCellValueFactory(celula -> {
            Funcionario f = celula.getValue();
            if (f instanceof Medico) {
                Medico m = (Medico) f;
                return new SimpleStringProperty(String.valueOf(m.getCrm())); // Converte int para String
            }
            return new SimpleStringProperty("-");
        });

        clmEspecialidade.setCellValueFactory(celula -> {
            Funcionario f = celula.getValue();
            if (f instanceof Medico) {
                Medico m = (Medico) f;
                return new SimpleStringProperty(m.getEspecialidade().toString());
            }
            return new SimpleStringProperty("-");
        });

        clmCOREN.setCellValueFactory(celula -> {
            Funcionario f = celula.getValue();
            if (f instanceof Enfermeiro) {
                Enfermeiro enf = (Enfermeiro) f;
                return new SimpleStringProperty(enf.getCorem());
            }
            return new SimpleStringProperty("-");
        });

        clmData.setCellValueFactory(celula -> {
            String dataTexto = celula.getValue().getDataNascimento().toString();
            return new SimpleStringProperty(dataTexto);
        });

        carregarTabela();
    }
    private void carregarTabela(){
        try{
            ArrayList<Funcionario> listaOriginal = Fachada.getInstance().listarFuncionario();
            ObservableList<Funcionario> listaParaTela = FXCollections.observableArrayList(listaOriginal);
            tblFuncionarios.setItems(listaParaTela);
        } catch (MedSystemException Ex){
            Uteis.alertaErro(Ex);
        }
    }
}
