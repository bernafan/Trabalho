/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.model.entidade;

import java.io.Serializable;

/**
 *
 * @author Leo
 */
public class Item_Estoque implements Serializable {
    private int id;
    public Produto produto;
    
    public Item_Estoque(Produto produto) {
        this.produto = produto;
    }
    public int getId (){
        return id;
    }
    
    public String getTipo(){
        
        return "0";
    }
    
    public String toString() {
        return "\n\nNome: " + produto.getNome() + "\n" + "Valor de venda: "+ produto.getValor() + "\n";
    }
}