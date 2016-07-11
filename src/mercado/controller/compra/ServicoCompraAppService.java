package mercado.controller.compra;

import java.util.Scanner;
import mercado.controller.ServicoSessao;
import mercado.controller.funcionario.ServicoFuncionario;

import mercado.model.entidade.Funcionario;
import mercado.model.entidade.Pedido;

public class ServicoCompraAppService {
	
        private final ServicoFuncionario servicoRetornaFuncionarioPeloLogin
                = new ServicoFuncionario();
        
        
        public void abreCompra(ServicoSessao sessao){
            // Cria pedido registrando qual caixa e qual funcionario responsável
     
        }
        
	public void criarPedido(int codigoCaixa, Funcionario funcionario) {
		Pedido p = new Pedido();
                
	}
	
	
}
