package mercado.entidade;


public class Item_Pedido {
	private Produto produto;
    private int qtdprodutos;
    private double pesoProduto;
    
	public Produto getProduto() {
		return produto;
	}
	public void setPproduto(Produto p) {
		this.produto = p;
	}
	public int getQtdProduto() {
		return qtdprodutos;
	}
	public void setQtdproduto(int qtd) {
		this.qtdprodutos = qtd;
	}
	public double getPeso() {
		return pesoProduto;
	}
	public void setPeso(double peso) {
		this.pesoProduto = peso;
	}
    
    
}
