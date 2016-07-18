package mercado.model.repositories;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import mercado.controller.estoque.ControlePersistenciaEstoque;
import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Unidade;



public class EstoqueRepository implements Serializable {
	
	public ArrayList<Item_Estoque> estoqueRepository = new ArrayList();
	ControlePersistenciaEstoque controle= new ControlePersistenciaEstoque(this.estoqueRepository);
        
        
        
        public void salvaNovoRepositorio() {
           controle = new ControlePersistenciaEstoque(this.estoqueRepository);
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
        ArrayList<Item_Estoque> novoEstoqueRepository = new ArrayList();
        novoEstoqueRepository = retornaRepository();
        
        for (int i = 0; i < novoEstoqueRepository.size(); i++) {
            if(novoEstoqueRepository.get(i).getId() == itemUnidade.getId()) {
                itemUnidade.setQtd(itemUnidade.getQtd() + qnt);
                novoEstoqueRepository.add(i,itemUnidade);
                this.estoqueRepository.clear();
                this.estoqueRepository.addAll(novoEstoqueRepository);
                System.out.println("Quatidade do produto: " + itemUnidade.produto.getNome()+" é: "+itemUnidade.getQtd());
                controle.salvaNovoArquivo();
                break;
            }
        }
    }
    public void removeUnidadeNoEstoque(Item_Estoque_Unidade itemUnidade, int qnt) throws IOException, ClassNotFoundException {        
         ArrayList<Item_Estoque> novoEstoqueRepository = new ArrayList();
         novoEstoqueRepository = retornaRepository(); 
         novoEstoqueRepository.clear();
         novoEstoqueRepository.addAll(retornaRepository());
         System.out.println(novoEstoqueRepository);
         
         itemUnidade.setQtd(itemUnidade.getQtd() - qnt);
         System.out.println("Qnt do item" + itemUnidade.getQtd());
         for (int i = 0; i < novoEstoqueRepository.size(); i++) {
           if (novoEstoqueRepository.get(i).equals(itemUnidade)) {
               novoEstoqueRepository.remove(i);
               novoEstoqueRepository.add(itemUnidade);
           }
           estoqueRepository.addAll(novoEstoqueRepository);
           salvaNovoRepositorio();
         }
         System.out.println("Novo repo"+ estoqueRepository);
    }
    
}