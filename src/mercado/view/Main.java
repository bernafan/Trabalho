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
        /*
        Vendedor v5 = new Vendedor("PASSOS", "123");
        funcionarioService.insereNovoFuncionario(v5);
        
        funcionarioService.imprimeFuncionarios();

        Item_Estoque_Unidade todynho = new Item_Estoque_Unidade(new Produto("Todynho", 2.00, 1.00), 5);
        estoqueService.insereNovoItemProduto(todynho);
        estoqueService.adicionaUnidade(todynho, 2);
        */
       // estoqueService.imprimeProdutos();

        
        Mercado mercado = new Mercado();
        mercado.viewTelaInicial();
    }
}
