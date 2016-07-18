package mercado.model.entidade;

import java.io.Serializable;


public class Item_Pedido implements Serializable{
	private Produto produto;
        private double qntProduto;
        private double subTotal;
        
        public Item_Pedido(Produto produto, double qntProduto){
            this.produto = produto;
            this.qntProduto = qntProduto;
            this.subTotal = produto.getValor()*qntProduto;
        }
    
	public Produto getProduto() {
		return this.produto;
	}

	public double getQtdProduto() {
		return this.qntProduto;
	}
	
        public double getSubTotal(){
            return this.subTotal;
        }
        
        @Override
        public String toString() {
            return "\n\nProduto: " + produto.getNome() + "\nUnitario: "+ produto.getValor() + "\nSubtotal: " + subTotal;
        }
    
    
}
