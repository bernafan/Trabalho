package mercado.controller.produto;

import mercado.controller.util.ValidacaoDeUsuario;
import mercado.model.entidade.Produto;
import mercado.model.repositories.EstoqueRepository;


public class ServicosProdutoAppService {
	
	 private EstoqueRepository estoque;
         
         private ValidacaoDeUsuario validacaoDeUsuario;
	
	 public void incluirProduto(String idUsuario, Produto produto, double qntProduto) {
		Item_produto item_produto = new Item_Produto(produto);
               if (validacaoDeUsuario.validarUsuario(idUsuario)) {
			estoque.insere(produto);
		}else
			System.out.println("Usu�rio n�o pode incluir produto!");
	 }
	 
	 public void removerProduto(String idUsuario, Produto produto) {
			if (validacaoDeUsuario.validarUsuario(idUsuario)) {
				estoque.remove(produto);
			}else
				System.out.println("Usu�rio n�o pode incluir produto!");
		}
	
	public int verficarQuantidadeDoProduto(Produto produto) {
		return estoque.quantidadeDoProduto(produto);
	}
	
	
}