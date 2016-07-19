package mercado.model.repositories;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import mercado.controller.estoque.ControlePersistenciaEstoque;
import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Peso;
import mercado.model.entidade.Item_Estoque_Unidade;



public class EstoqueRepository implements Serializable {
	
	public ArrayList<Item_Estoque> estoqueRepository = new ArrayList();
	ControlePersistenciaEstoque controle= new ControlePersistenciaEstoque(this.estoqueRepository);
       
        
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
        
        
    public void insereNovoItemRepositorio(Item_Estoque novoItem) throws IOException, ClassNotFoundException {
        controle.insereNovoItemArquivo(novoItem);
    }

    public void addUnidadeNoEstoque(Item_Estoque_Unidade itemUnidade, int qnt) throws IOException, ClassNotFoundException {
      this.estoqueRepository = retornaRepository();

        for (int i = 0; i < this.estoqueRepository.size(); i++) {
            if(this.estoqueRepository.get(i).produto.getNome().equals(itemUnidade.produto.getNome()))  {
                itemUnidade.setQtd(itemUnidade.getQtd() + qnt);
                this.estoqueRepository.set(i,itemUnidade);
                System.out.println("Quatidade do produto: " + itemUnidade.produto.getNome()+" é: "+itemUnidade.getQtd());
           }
         }
        salvaNovoRepositorio();
   
    }
    public void removeUnidadeNoEstoque(Item_Estoque_Unidade itemUnidade, int qnt) throws IOException, ClassNotFoundException {        
        this.estoqueRepository = retornaRepository();

        for (int i = 0; i < this.estoqueRepository.size(); i++) {
            if(this.estoqueRepository.get(i).produto.getNome().equals(itemUnidade.produto.getNome()))  {
                itemUnidade.setQtd(itemUnidade.getQtd() - qnt);
                this.estoqueRepository.set(i,itemUnidade);
                System.out.println("Quatidade do produto: " + itemUnidade.produto.getNome()+" é: "+itemUnidade.getQtd());
           }
         }
        salvaNovoRepositorio();
   
    }
    
    public void addPesoNoEstoque(Item_Estoque_Peso item, double qnt) throws IOException, ClassNotFoundException {
      this.estoqueRepository = retornaRepository();

        for (int i = 0; i < this.estoqueRepository.size(); i++) {
            if(this.estoqueRepository.get(i).produto.getNome().equals(item.produto.getNome()))  {
                item.setQtd(item.getQtd() + qnt);
                this.estoqueRepository.set(i,item);
                System.out.println("Quatidade do produto: " + item.produto.getNome()+" é: "+item.getQtd());
           }
         }
        salvaNovoRepositorio();
   
    }
    
    public void removePesoNoEstoque(Item_Estoque_Peso itemPeso, double qntPeso) throws IOException, ClassNotFoundException {        
        this.estoqueRepository = retornaRepository();

        for (int i = 0; i < this.estoqueRepository.size(); i++) {
            if(this.estoqueRepository.get(i).produto.getNome().equals(itemPeso.produto.getNome()))  {
                itemPeso.setQtd(itemPeso.getQtd() - qntPeso);
                this.estoqueRepository.set(i,itemPeso);
                System.out.println("Quatidade do produto: " + itemPeso.produto.getNome()+" é: "+itemPeso.getQtd());
           }
         }
        salvaNovoRepositorio();
   
    }
    
    
    // Só deve ser usada pelas funcoes de add e remove
     public void salvaNovoRepositorio() throws IOException, ClassNotFoundException {
            controle = new ControlePersistenciaEstoque(this.estoqueRepository);
            System.out.println("Funcao salva " + this.estoqueRepository);
            controle.salvaArrayNoArquivo();
        }
    
}