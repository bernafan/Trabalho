package mercado.view;

import java.io.IOException;
import mercado.controller.estoque.ServicoEstoque;
import mercado.controller.funcionario.ServicoFuncionario;
import mercado.model.entidade.Item_Estoque_Unidade;
import mercado.model.entidade.Produto;
import mercado.model.entidade.Vendedor;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServicoFuncionario funcionarioService = new ServicoFuncionario();
        ServicoEstoque estoqueService = new ServicoEstoque();
       
       estoqueService.imprimeProdutos();

        
        Mercado mercado = new Mercado();
        mercado.viewTelaInicial();
    }
}
