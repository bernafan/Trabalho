/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.model.entidade;

import java.io.Serializable;

/**
 *
 * @author Bernardo
 */
public class Item_Estoque_Unidade extends Item_Estoque implements Serializable{
    private int qtd;

    public Item_Estoque_Unidade(Produto p, int qtd) {
        super(p);
        this.qtd = qtd;
    }
    
    public int getQtd() {
        return this.qtd;
    }
    
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
     
    @Override
    public String toString() {
        return super.toString() + "\nQuantidade: " + qtd; //To change body of generated methods, choose Tools | Templates.
    }
}
