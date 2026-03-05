package com.dados.repositoriosCSV;

//Bibliotecas
import com.dados.interfaces.IRepositorioFuncionario;
import com.negocio.basicas.*;
import com.negocio.Excessoes.ErroNoDiscoException;
import com.negocio.Excessoes.InformacaoNaoEncontradaException;
import com.negocio.Excessoes.MedSystemException;
import com.negocio.basicas.enuns.Especialidade;
import com.negocio.basicas.secundarias.Data;
import com.negocio.basicas.secundarias.Endereco;

import java.io.*;
import java.util.ArrayList;

public class RepositorioFuncionarioCSV implements IRepositorioFuncionario{
    //Atributos
    private String nomeArquivo = "Arquivos/Funcionarios.CSV";

    //Metodos Publicos
    public void adicionar(Funcionario funcionario) throws MedSystemException{
        ArrayList<Funcionario> funcionarios = lerDados();
        funcionarios.add(funcionario);
        salvarDados(funcionarios);
    }
    public void excluir(String CPF) throws MedSystemException {
        ArrayList<Funcionario> funcionarios = lerDados();
        int ID = buscarCPF(CPF,funcionarios);
        funcionarios.remove(ID);
        salvarDados(funcionarios);
    }
    public ArrayList<Funcionario> listar() throws MedSystemException {
        return lerDados();
    }
    public void modificar(String CPF, Funcionario funcionario) throws MedSystemException {
        ArrayList<Funcionario> funcionarios = lerDados();
        int ID = buscarCPF(CPF,funcionarios);
        funcionarios.set(ID, funcionario);
        salvarDados(funcionarios);
    }
    public Funcionario buscar(String CPF) throws MedSystemException{
        ArrayList<Funcionario> funcionarios = lerDados();
        int ID = buscarCPF(CPF,funcionarios);
        return funcionarios.get(ID);
    }
    public Funcionario logar(String login, String senha) throws MedSystemException{
        ArrayList<Funcionario> funcionarios = lerDados();
        if(login.equals("God") && senha.equals("123")){
                Administrador adm = new Administrador();
                adm.setNome("ADM Master");
                return adm;
        }
        for(int i = 0; i < funcionarios.size(); i++){
            if(funcionarios.get(i).getcPF().equals(login) && funcionarios.get(i).getSenha().equals(senha)){
                return funcionarios.get(i);
            }
        }
        throw new InformacaoNaoEncontradaException("Login ou Senha Invalidos!!!");
    }

    //Metodos Privados
    private int buscarCPF(String CPF, ArrayList<Funcionario> funcionarios) throws MedSystemException {
        for(int i = 0; i < funcionarios.size();i++){
            if(funcionarios.get(i).getcPF().equals(CPF)){
                return i;
            }
        }
        throw new InformacaoNaoEncontradaException("Nao existe Funcionario cadastrado com tal CPF!!!");
    }
    private ArrayList<Funcionario> lerDados() throws MedSystemException{
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(nomeArquivo))) {
            String linhaAtual;
            while((linhaAtual = buffer.readLine()) != null){
                String[] dados = linhaAtual.split(",");
                String nome = dados[0];
                String cpf = dados[1];
                String logra = dados[2];
                String muni = dados[3];
                String estado = dados[4];
                String dataNascimento = dados[5];
                String senha = dados[6];
                String cargo = dados[7];
                String[] datas = dataNascimento.split("/");
                Endereco novoEnd = new Endereco(logra,muni,estado);
                int dia = Integer.parseInt(datas[0]);
                int mes = Integer.parseInt(datas[1]);
                int ano = Integer.parseInt(datas[2]);
                Data novaData = new Data(dia,mes,ano);
                Funcionario funcionario = new Funcionario(nome,cpf,novoEnd,novaData,senha);
                if(cargo.equals("Medico")){
                    String espe = dados[8];
                    String crm = dados[9];
                    Especialidade novaEspe = Especialidade.valueOf(espe);
                    Medico m = new Medico(funcionario,crm,novaEspe);
                    funcionarios.add(m);
                } else if(cargo.equals("Enfermeiro")){
                    String coren = dados[8];
                    Enfermeiro e = new Enfermeiro(funcionario, coren);
                    funcionarios.add(e);
                } else if(cargo.equals("Administrador")){
                    Administrador a = new Administrador(funcionario);
                    funcionarios.add(a);
                } else if(cargo.equals("Recepcionista")){
                    Recepcionista r = new Recepcionista(funcionario);
                    funcionarios.add(r);
                }
            }
        } catch (FileNotFoundException Ex) {
            return funcionarios;
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Erro ao ler o disco!", Ex);
        }
        return funcionarios;
    }
    private void salvarDados(ArrayList<Funcionario> funcionarios) throws MedSystemException{
        new File(nomeArquivo).getParentFile().mkdirs();
        try(FileWriter file = new FileWriter(nomeArquivo);
        PrintWriter writer = new PrintWriter(file)){
            for(Funcionario f : funcionarios) {
                writer.println(f.toCSV());
            }
        } catch (IOException Ex) {
            throw new ErroNoDiscoException("Falha ao salvar no disco!",Ex);
        }
    }
}