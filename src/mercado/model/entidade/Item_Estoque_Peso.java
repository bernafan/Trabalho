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
public class Item_Estoque_Peso extends Item_Estoque implements Serializable{
    private double qtd;

    public Item_Estoque_Peso(Produto p, double qtd) {
        super(p);
        this.qtd = qtd;
    }
    
    public double getQtd() {
        return this.qtd;
    }
    
    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return super.toString() + "Quantidade: " + qtd;
    }
    
    
}
