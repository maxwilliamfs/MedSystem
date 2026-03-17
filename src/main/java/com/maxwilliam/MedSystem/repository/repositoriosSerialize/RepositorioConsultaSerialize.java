package com.maxwilliam.MedSystem.repository.repositoriosSerialize;


//Bibliotecas
import com.dados.interfaces.IRepositorioConsulta;
import com.negocio.basicas.ConsultaAbstrata;
import com.negocio.basicas.enuns.StatusConsulta;
import com.negocio.basicas.secundarias.PrescricaoMedica;
import com.negocio.basicas.secundarias.Procedimento;
import com.negocio.excessoes.BugFoundException;
import com.negocio.excessoes.ErroNoDiscoException;
import com.negocio.excessoes.InformacaoNaoEncontradaException;
import com.negocio.excessoes.MedSystemException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RepositorioConsultaSerialize implements IRepositorioConsulta{
    //Atributos
    private String nomeArquivo = "Arquivos/Consultas.bin";

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
            try(FileInputStream stream = new FileInputStream(arq);
            ObjectInputStream obj = new ObjectInputStream(stream)){
                consultas = (ArrayList<ConsultaAbstrata>)obj.readObject();
            } catch (IOException Ex){ 
                throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
            } catch (ClassNotFoundException Ex){
                throw new BugFoundException("Bug encontrado, contate o desenvolvedor", Ex);
            }
        } else {
            consultas = new ArrayList<>();
        }
        return consultas;
    }
    private void salvarDados(ArrayList<ConsultaAbstrata> consultas) throws MedSystemException{
        File arq = new File(nomeArquivo);
        try(FileOutputStream stream = new FileOutputStream(arq);
        ObjectOutputStream obj = new ObjectOutputStream(stream)){
            obj.writeObject(consultas);
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao ler dados do disco", Ex);
        }
    }
}