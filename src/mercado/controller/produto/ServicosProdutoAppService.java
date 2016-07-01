package mercado.controller.produto;

import mercado.controller.util.ValidacaoDeUsuario;
import mercado.model.entidade.Item_Estoque;
import mercado.model.repositories.EstoqueRepository;


public class ServicosProdutoAppService {
	
    private EstoqueRepository estoque;
         
    private ValidacaoDeUsuario validacaoDeUsuario;	
   
    public void incluirItemProduto(Item_Estoque item) {
        estoque.insere(item);
    }
	 
    public void removerItemProduto(Item_Estoque item) {
        estoque.remove(item);	
    }
	
}