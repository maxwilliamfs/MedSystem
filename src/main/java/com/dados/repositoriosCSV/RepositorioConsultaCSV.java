package com.dados.repositoriosCSV;


//Bibliotecas
import com.dados.interfaces.IRepositorioConsulta;
import com.negocio.basicas.ConsultaAbstrata;
import com.negocio.basicas.enuns.StatusConsulta;
import com.negocio.basicas.secundarias.PrescricaoMedica;
import com.negocio.basicas.secundarias.Procedimento;
import com.negocio.Excessoes.InformacaoNaoEncontradaException;
import com.negocio.Excessoes.MedSystemException;

import java.io.*;
import java.util.ArrayList;

public class RepositorioConsultaCSV implements IRepositorioConsulta{
    //Atributos
    private String nomeArquivo = "Arquivos/Consultas.CSV";

    //Metodos CRUD
    public void adicionar(ConsultaAbstrata consulta) throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        if(consultas.isEmpty()){
            consulta.setId(1);
        } else {
            consulta.setId(consultas.get(consultas.size() - 1).getId() + 1);
        }
        consultas.add(consulta);
        salvarDados(consultas);
    }
    public void cancelar(int id) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int ID = buscarID(id,consultas);
        consultas.get(ID).setStatus(StatusConsulta.CANCELADA);
        salvarDados(consultas);
    }
    public ArrayList<ConsultaAbstrata> listar() throws MedSystemException {
        return lerDados();
    }
    public void modificar(int id, ConsultaAbstrata consulta) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int ID = buscarID(id,consultas);
        consultas.set(ID, consulta);
        salvarDados(consultas);
    }
    public ConsultaAbstrata buscar(int id) throws MedSystemException{
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int ID = buscarID(id,consultas);
        return consultas.get(ID);
    }

    //Metodos Especiais
    public void realizarConsulta(int id, ArrayList<Procedimento> procedimentos, PrescricaoMedica prescricaoMedica) throws MedSystemException {
        ArrayList<ConsultaAbstrata> consultas = lerDados();
        int iD = buscarID(id, consultas);
        consultas.get(iD).setPrescricaoMedica(prescricaoMedica);
        consultas.get(iD).setProcedimentos(procedimentos);
        salvarDados(consultas);
    }

    //Metodos Privados
    public int buscarID(int id, ArrayList<ConsultaAbstrata> consultas) throws MedSystemException {
        for(int i = 0; i < consultas.size();i++){
            if(consultas.get(i).getId() == id){
                return i;
            }
        }
        throw new InformacaoNaoEncontradaException("Nao existe consulta cadastrado com tal ID!!!");
    }
    private ArrayList<ConsultaAbstrata> lerDados() throws MedSystemException{
        
        ArrayList<ConsultaAbstrata> consultas;
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            try{}
        } else {
            consultas = new ArrayList<>();
        }
        return consultas;
    }
    private void salvarDados(ConsultaAbstrata consultas) throws MedSystemException{
        new File(nomeArquivo).getParentFile().mkdirs();
        try () {

        }
    }
}