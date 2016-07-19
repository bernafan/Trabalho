/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.view;

import mercado.controller.pedido.ServicoPedido;

import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Peso;
import mercado.model.entidade.Item_Estoque_Unidade;
import mercado.model.entidade.Pedido;
import mercado.model.entidade.Produto;
import mercado.model.repositories.PedidoRepository;


/**
 *
 * @author Bernardo
 */
public class GeraPedidos {
    public static void main(String[] args) {
       
        PedidoRepository pedidos = new PedidoRepository();
        ServicoPedido pedidoService = new ServicoPedido();
       

        Pedido novoPedido = new Pedido ("Teste");
        
        pedidoService.incluirPedido(novoPedido);
        
        pedidoService.salvaNovoRepositorio();
        pedidoService.imprimePedidos();
    }
}