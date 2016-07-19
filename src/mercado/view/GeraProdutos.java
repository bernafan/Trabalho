/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.view;

import java.io.IOException;
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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       
        EstoqueRepository estoque = new EstoqueRepository();
        ServicoEstoque estoqueService = new ServicoEstoque();
       

        Item_Estoque laranja = new Item_Estoque_Peso(new Produto("Laranja", 5.00, 2.00), 100);
        Item_Estoque banana = new Item_Estoque_Peso(new Produto("Banana", 2.50, 1.00), 200);
        Item_Estoque Todynho = new Item_Estoque_Unidade(new Produto("Todynho", 10.00, 1.00), 300);
        Item_Estoque Miojo = new Item_Estoque_Unidade(new Produto("Miojo", 3.00, 1.50), 400);
        
        
        estoqueService.incluirItemProduto(laranja);
        estoqueService.incluirItemProduto(banana);
        estoqueService.incluirItemProduto(Todynho);
        estoqueService.incluirItemProduto(Miojo);
        estoqueService.salvaNovoRepositorio();
        estoqueService.imprimeProdutos();
    }
}