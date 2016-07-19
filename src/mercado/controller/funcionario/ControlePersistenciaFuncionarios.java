/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controller.funcionario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import mercado.model.entidade.Funcionario;

public class ControlePersistenciaFuncionarios {

    private static final String NOME_ARQUIVO = "funcionarios.dat";

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Funcionario> arrayDeRetorno = new ArrayList();
    
    public ControlePersistenciaFuncionarios(ArrayList<Funcionario> repositorio) {
        this.funcionarios = repositorio;

    }
    public ArrayList<Funcionario> abreArquivo() {
        try (FileInputStream fileIn = new FileInputStream(NOME_ARQUIVO);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Funcionario f;
            this.arrayDeRetorno.clear();
            for (Object objeto : (Object[]) in.readObject()) {
                f = (Funcionario) objeto;
                this.arrayDeRetorno.add(f);
            }  
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(
                    ControlePersistenciaFuncionarios.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return this.arrayDeRetorno;
    }
    
    public void overwriteArquivo(Funcionario novofuncionario) throws IOException,
            ClassNotFoundException {
        
        this.funcionarios.clear();
        this.funcionarios.addAll(abreArquivo());
        this.funcionarios.add(novofuncionario);
        salvaNovoArquivo();
    }
    
    public void salvaNovoArquivo() {
        try(FileOutputStream fileOut = new FileOutputStream(NOME_ARQUIVO);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.reset();
            out.writeObject(this.funcionarios.toArray());
        } catch (IOException ex) {
            Logger.getLogger(ControlePersistenciaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
