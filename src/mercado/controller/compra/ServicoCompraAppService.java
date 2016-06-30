package mercado.controller.compra;

import java.util.Scanner;
import mercado.controller.funcionario.ServicoFuncionarioAppService;
import mercado.model.entidade.Login;

import mercado.model.entidade.Funcionario;
import mercado.model.entidade.Pedido;

public class ServicoCompraAppService {
	
        private final ServicoFuncionarioAppService servicoRetornaFuncionarioPeloLogin
                = new ServicoFuncionarioAppService();
        
        
        public void abreCompra(Sessao sessao){
            // Cria pedido registrando qual caixa e qual funcionario responsável
            sessao.getFuncionario();
            sessao.GetCaixa();
            criarPedido(codigoCaixa, 
                    servicoRetornaFuncionarioPeloLogin.retornaFunionarioPeloLogin(login.getUsario(), login.getSenha()));
        }
        
	public void criarPedido(int codigoCaixa, Funcionario funcionario) {
		Pedido p = new Pedido();
                
	}
	
	
}
