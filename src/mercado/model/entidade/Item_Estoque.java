/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.model.entidade;

/**
 *
 * @author Leo
 */
public class Item_Estoque {
    private int id;
    public Produto produto;
    public double qnt;
    
    public Item_Estoque(Produto produto, double qnt){
        this.produto = produto;
        this.qnt = qnt;
        id += 1;
    }
    
    public double getQnt() {
        return this.qnt;
    }
    
    public int getId (){
        return id;
    }
    
    //função para aumentar a quantidade de um produto (gerente)
    public String adicionaQnt(int qnt){
        this.qnt += qnt;
        return ("Adicionado com Sucesso");
    }
    
    //função para subtrair uma quantidade de um produto (venda)
    public String diminueQnt(int qnt){
        if(this.qnt >= qnt){
            this.qnt -= qnt; 
            return ("Operação realizada com Sucesso!");
        }else{
            return ("ERRO! Não temos essa qnt.");
        }
    }

}