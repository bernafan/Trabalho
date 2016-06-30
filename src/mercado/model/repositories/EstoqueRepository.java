package mercado.model.repositories;

import java.util.ArrayList;
import mercado.model.entidade.Item_Estoque;

import mercado.model.entidade.Produto;

public class EstoqueRepository {
	
	public ArrayList<Item_Estoque> estoqueRepository;
	
	public void insere(Item_Estoque item) {
		estoqueRepository.add(item);
	}
	
	public void remove(Item_Estoque item){		
		if (estoqueRepository.contains(item)) {
			estoqueRepository.remove(item);
		}
	}
	
	/*public double quantidadeDoProduto(Item_Estoque item) {
		if( estoqueRepository.contains(item) ){
			for (int i = 0; i < estoqueRepository.size(); i++) {
			// consertar	
                            if(estoqueRepository.get(i) != item) {
                                    System.out.println( item.getQnt() + " est� fora de estoque");
                                    
				}
			}
		}
                return item.getQnt();
	}*/
}