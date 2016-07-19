package mercado.model.entidade;


public class Item_Pedido {
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
        
        public String toString() {
            return "\n\nProduto: " + produto.getNome() + "\nUnitario: "+ produto.getValor() + "\nSubtotal: " + subTotal;
        }
    
    
}
