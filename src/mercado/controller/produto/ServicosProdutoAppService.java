package mercado.controller.produto;

import mercado.entidade.Produto;
import mercado.model.EstoqueRepository;


public class ServicosProdutoAppService {
	
	 private EstoqueRepository estoque;
	
	 public void incluirProduto(String idUsuario, Produto produto) {
		if (validarUsuario(idUsuario)) {
			estoque.insere(produto);
		}else
			System.out.println("Usu�rio n�o pode incluir produto!");
	 }
	 
	 public void removerProduto(String idUsuario, Produto produto) {
			if (validarUsuario(idUsuario)) {
				estoque.remove(produto);
			}else
				System.out.println("Usu�rio n�o pode incluir produto!");
		}
	
	public int verficarQuantidadeDoProduto(Produto produto) {
		return estoque.quantidadeDoProduto(produto);
	}
	
	public boolean validarUsuario(String idUsuario) {
		if( (!idUsuario.substring(0).toUpperCase().equals('G')) ) {
			return false;
		}
		return true;
	}
}
