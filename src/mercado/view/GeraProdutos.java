/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.view;

import mercado.controller.estoque.ServicoEstoque;

import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Peso;
import mercado.model.entidade.Item_Estoque_Unidade;
import mercado.model.entidade.Produto;
import mercado.model.repositories.EstoqueRepository;


/**
 *
 * @author Bernardo
 */
public class GeraProdutos {
    public static void main(String[] args) {
       
        EstoqueRepository estoque = new EstoqueRepository();
        ServicoEstoque estoqueService = new ServicoEstoque();
       

        Item_Estoque laranja = new Item_Estoque_Peso(new Produto("Laranja", 5.00, 2.00), 10);
        Item_Estoque banana = new Item_Estoque_Peso(new Produto("Banana", 2.00, 1.00), 20);
        Item_Estoque Todynho = new Item_Estoque_Unidade(new Produto("Todynho", 2.00, 1.00), 20);
        
        
        estoqueService.incluirItemProduto(laranja);
        estoqueService.incluirItemProduto(banana);
        
        estoqueService.salvaNovoRepositorio();
        estoqueService.imprimeProdutos();
    }
}