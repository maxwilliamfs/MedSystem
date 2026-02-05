package com.Dados;

//Bibliotecas
import com.Dados.Interfaces.IRepositorioFuncionario;
import com.Negocio.Basicas.Funcionario;
import com.Negocio.Excessoes.BugFoundedException;
import com.Negocio.Excessoes.ErroNoDiscoException;
import com.Negocio.Excessoes.MedSystemException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ArquivoFuncionario implements IRepositorioFuncionario{
    private String nomeArquivo = "Funcionarios.bin";

    public void adicionar(Funcionario funcionario) throws MedSystemException{
        ArrayList<Funcionario> funcionarios = ler();
    }

    private ArrayList<Funcionario> ler() throws MedSystemException{
        
        ArrayList<Funcionario> funcionarios;
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            try(FileInputStream stream = new FileInputStream(arq);
            ObjectInputStream obj = new ObjectInputStream(stream)){
                funcionarios = (ArrayList<Funcionario>)obj.readObject();
            } catch (IOException Ex){ 
                throw new ErroNoDiscoException("Falha ao ler o disco", Ex);
            } catch (ClassNotFoundException Ex){
                throw new BugFoundedException("Bug encontrado, contate o desenvolvedor", Ex);
            }
        } else {
            funcionarios = new ArrayList<>();
        }
        return funcionarios;
    }
    private void salvar(ArrayList<Funcionario> funcionarios) throws MedSystemException{
        File arq = new File(nomeArquivo);
        try(FileOutputStream stream = new FileOutputStream(arq);
        ObjectOutputStream obj = new ObjectOutputStream(stream)){
            obj.writeObject(funcionarios);
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao ler o disco", Ex);
        }
    }
}
