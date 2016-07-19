/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controller.pedido;

import java.io.IOException;
import java.util.ArrayList;
import mercado.controller.estoque.ServicoEstoque;
import mercado.model.entidade.Funcionario;
import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Pedido;
import mercado.model.entidade.Produto;
import mercado.model.repositories.PedidoRepository;

/**
 *
 * @author Bernardo
 */
public class ServicoPedido {
    
    private PedidoRepository pedidos = new PedidoRepository();
    ArrayList<Item_Estoque> arrayProdutos = new ArrayList();
    private ServicoEstoque servicoEstoque = new ServicoEstoque();
   
    public void incluirPedido(Pedido item) {
        pedidos.insere(item);
    }
	 
    public void removerPedido(Pedido item) {
        pedidos.remove(item);	
    }
    
    public void imprimePedidos() {
        System.out.println(pedidos.retornaRepository());
    }

    public Item_Estoque retornaProdutoPeloNome(String nomeProduto) {
        arrayProdutos = servicoEstoque.retornaRepository();
        
        for (int i = 0; i < arrayProdutos.size(); i++) {
            if(arrayProdutos.get(i).produto.getNome().compareToIgnoreCase(nomeProduto)==0) {
                return arrayProdutos.get(i);
            }
        }
        System.out.println("Produto não encontrado");
        return null;
    }
    
    public void salvaNovoRepositorio() {
        pedidos.salvaNovoRepositorio();
    }
}
