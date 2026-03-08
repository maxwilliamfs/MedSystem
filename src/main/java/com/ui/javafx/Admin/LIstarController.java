package com.ui.javafx.Admin;

import com.fachada.Fachada;
import com.negocio.basicas.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LIstarController {
    //Declaracoes
    @FXML
    private TableColumn<Funcionario, String> clmNome, clmCPF, clmLogradouro,clmMunicipio,
    clmEstado,clmCRM,clmCOREN,clmData,clmEspecialidade;

    public void initialize(URL url, ResourceBundle rb){
        clmNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clmCPF.setCellValueFactory(new PropertyValueFactory<>("cPF"));
        clmLogradouro.setCellValueFactory(new PropertyValueFactory<>("logradouro"));
        clmMunicipio.setCellValueFactory(new PropertyValueFactory<>("municipio"));
        clmEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        carregarTabela();
    }
    private void carregarTabela(){
        try{
            ArrayList<Funcionario> listaOriginal = Fachada.getInstance().listarFuncionario();
            ObservableList<Funcionario> listaParaTela = FXCollections.observableArrayList(listaOriginal);
            tblFuncionarios.setItems(listaParaTela);
        }
    }
}
