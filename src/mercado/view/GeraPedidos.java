/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.view;

import mercado.controller.funcionario.ServicoFuncionario;
import mercado.controller.pedido.ServicoPedido;
import mercado.model.entidade.Funcionario;

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
        ServicoFuncionario servicoFunc = new ServicoFuncionario();
        Funcionario funcionario = new Funcionario();
        funcionario = servicoFunc.retornaFunionarioPeloLogin("G1", "123");
        Pedido novoPedido = new Pedido (funcionario, 2);
        
        pedidoService.incluirPedido(novoPedido);
        
        pedidoService.salvaNovoRepositorio();
        pedidoService.imprimePedidos();
    }
}