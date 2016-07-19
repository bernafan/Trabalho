/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controller.pedido;

import java.io.IOException;
import mercado.model.entidade.Pedido;
import mercado.model.repositories.PedidoRepository;

/**
 *
 * @author Bernardo
 */
public class ServicoPedido {
    
    private PedidoRepository pedidos = new PedidoRepository();
    
   
    public void incluirPedido(Pedido item) {
        pedidos.insere(item);
    }
	 
    public void removerPedido(Pedido item) {
        pedidos.remove(item);	
    }
    
    public void imprimePedidos() {
        System.out.println(pedidos.retornaRepository());
    }

    
    public void salvaNovoRepositorio() {
        pedidos.salvaNovoRepositorio();
    }
}
