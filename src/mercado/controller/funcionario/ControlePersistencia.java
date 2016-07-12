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

public class ControlePersistencia {

    private static final String NOME_ARQUIVO = "funcionarios.dat";

    private final ArrayList<Funcionario> funcionarios;

    public ControlePersistencia(ArrayList<Funcionario> repositorio) {
        this.funcionarios = repositorio;

    }

    public void abreArquivo() {
        try (FileInputStream fileIn = new FileInputStream(NOME_ARQUIVO);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            for (Object objeto : (Object[]) in.readObject()) {
                System.out.println((Funcionario) objeto);
            }
        } catch (IOException | ClassNotFoundException ex) {

            Logger.getLogger(ControlePersistencia.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    public void salvaArquivo() {
     try (FileOutputStream fileOut = new FileOutputStream(NOME_ARQUIVO);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(funcionarios.toArray());
        } catch (IOException ex) {
            Logger.getLogger(ControlePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
