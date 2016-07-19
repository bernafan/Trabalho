package mercado.model.repositories;

import java.io.IOException;
import java.util.ArrayList;
import mercado.controller.estoque.ControlePersistenciaEstoque;
import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Unidade;



public class EstoqueRepository {
	
	public ArrayList<Item_Estoque> estoqueRepository = new ArrayList();
	ControlePersistenciaEstoque controle  =
                new ControlePersistenciaEstoque(estoqueRepository);
        
        public void salvaNovoRepositorio() {
        controle.salvaNovoArquivo();
        }
	public void insere(Item_Estoque item) {
            estoqueRepository.add(item);
	}
	
	public void remove(Item_Estoque item){	
            estoqueRepository.remove(item);
	}
       
	public ArrayList retornaRepository() {
            this.estoqueRepository = controle.abreArquivo();
            return this.estoqueRepository;
    }
        
        
    public void overwriteRepositorio(Item_Estoque novoItem) throws IOException, ClassNotFoundException {
        controle.overwriteArquivo(novoItem);
    }

    public void addUnidadeNoEstoque(Item_Estoque_Unidade itemUnidade, int qnt) throws IOException, ClassNotFoundException {
        
        this.estoqueRepository = retornaRepository();
        
        for (int i = 0; i < estoqueRepository.size(); i++) {
            if(estoqueRepository.get(i).getId()== itemUnidade.getId()) {
                itemUnidade.setQtd(itemUnidade.getQtd() + qnt);
                estoqueRepository.add(i,itemUnidade);
                System.out.println("Quatidade do produto: " + itemUnidade.produto.getNome()+" é: "+itemUnidade.getQtd());
                controle.salvaNovoArquivo();
                break;
            }
        }
    }
    
}