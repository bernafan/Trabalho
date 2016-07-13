/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controller.estoque;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mercado.model.entidade.Item_Estoque;

/**
 *
 * @author Bernardo
 */
public class ControlePersistenciaEstoque {
    private static final String NOME_ARQUIVO = "produtos.dat";

    private ArrayList<Item_Estoque> produtos;
    private ArrayList<Item_Estoque> arrayDeRetorno = new ArrayList();

    public ControlePersistenciaEstoque(ArrayList<Item_Estoque> repositorio) {
        this.produtos = repositorio;

    }

     public ArrayList<Item_Estoque> abreArquivo() {
        try (FileInputStream fileIn = new FileInputStream(NOME_ARQUIVO);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Item_Estoque item;
            this.arrayDeRetorno.clear();
            for (Object objeto : (Object[]) in.readObject()) {
                item = (Item_Estoque) objeto;
                this.arrayDeRetorno.add(item);
            }  
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(
                    ControlePersistenciaEstoque.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return this.arrayDeRetorno;
    }
     
     public void overwriteArquivo(Item_Estoque novoItem) throws IOException,
            ClassNotFoundException {
        
        this.produtos.clear();
        this.produtos.addAll(abreArquivo());
        this.produtos.add(novoItem);
        salvaNovoArquivo();
    }
     
    public void salvaNovoArquivo() {
        try(FileOutputStream fileOut = new FileOutputStream(NOME_ARQUIVO);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.reset();
            out.writeObject(this.produtos.toArray());
        } catch (IOException ex) {
            Logger.getLogger(ControlePersistenciaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
