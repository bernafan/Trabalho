/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controller.pedido;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mercado.model.entidade.Pedido;

/**
 *
 * @author Bernardo
 */
public class ControlePersistenciaPedido {
    private static final String NOME_ARQUIVO = "pedidos.dat";

    private ArrayList<Pedido> pedidos;
    private ArrayList<Pedido> arrayDeRetorno = new ArrayList();

    public ControlePersistenciaPedido(ArrayList<Pedido> repositorio) {
        this.pedidos = repositorio;

    }

     public ArrayList<Pedido> abreArquivo() {
        try (FileInputStream fileIn = new FileInputStream(NOME_ARQUIVO);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Pedido item;
            this.arrayDeRetorno.clear();
            for (Object objeto : (Object[]) in.readObject()) {
                item = (Pedido) objeto;
                this.arrayDeRetorno.add(item);
            }  
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(
                    ControlePersistenciaPedido.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return this.arrayDeRetorno;
    }
     
     public void overwriteArquivo(Pedido novoItem) throws IOException,
            ClassNotFoundException {
        
        this.pedidos.clear();
        this.pedidos.addAll(abreArquivo());
        this.pedidos.add(novoItem);
        salvaNovoArquivo();
    }
     
    public void salvaNovoArquivo() {
        try(FileOutputStream fileOut = new FileOutputStream(NOME_ARQUIVO);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.reset();
            out.writeObject(this.pedidos.toArray());
        } catch (IOException ex) {
            Logger.getLogger(ControlePersistenciaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
