package mercado.model;

import java.util.ArrayList;

import mercado.entidade.Produto;

public class EstoqueRepository {
	
	public ArrayList<Produto> estoqueRepository;
	
	public void insere(Produto p) {
		estoqueRepository.add(p);
	}
	
	public void remove(Produto p) {		
		if (estoqueRepository.contains(p)) {
			estoqueRepository.remove(p);
		}
	}
	
	public int quantidadeDoProduto(Produto p) {
		int quantidade = 0;
		if( estoqueRepository.contains(p) ){
			for (int i = 0; i < estoqueRepository.size(); i++) {
				if(estoqueRepository.get(i) == p) {
					quantidade ++;
				}
			}
		}else {
			System.out.println( p.getNome() + " está fora de estoque");
		}
		return quantidade;
	}
}
