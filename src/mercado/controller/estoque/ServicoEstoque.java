/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controller.estoque;

import java.io.IOException;
import java.util.ArrayList;
import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Unidade;
import mercado.model.repositories.EstoqueRepository;

/**
 *
 * @author Bernardo
 */
public class ServicoEstoque {
    
    private EstoqueRepository estoque = new EstoqueRepository();
    
   
    public void incluirItemProduto(Item_Estoque item) {
        estoque.insere(item);
    }
	 
    public void removerItemProduto(Item_Estoque item) {
        estoque.remove(item);	
    }
    
    public void insereNovoItemProduto(Item_Estoque novoItem) throws IOException, ClassNotFoundException {
        estoque.overwriteRepositorio(novoItem);
    }
    
    public void imprimeProdutos() {
        System.out.println(estoque.retornaRepository());
    }

    public ArrayList retornaRepository() {
        return estoque.retornaRepository();
    }
    public void salvaNovoRepositorio() {
        estoque.salvaNovoRepositorio();
    }
	
    
    public void adicionaUnidade(Item_Estoque_Unidade item, int qnt) throws IOException, ClassNotFoundException{
        estoque.addUnidadeNoEstoque(item, qnt);
    }
    public void removeUnidade(Item_Estoque_Unidade item, int qnt) throws IOException, ClassNotFoundException{
        estoque.removeUnidadeNoEstoque(item, qnt);
    }
    
    //função para subtrair uma quantidade de um produto (venda)
    
}
