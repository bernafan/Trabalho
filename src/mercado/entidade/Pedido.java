package mercado.entidade;


public class Pedido {
	private static int GeradorDeCodigo = 0;
	private int id;
	private Item_Pedido[] itens;
	 
	public Pedido() {
		GeradorDeCodigo++;
		id = GeradorDeCodigo;
	}
	public int getId() {
		return id;
	}
	
	public Item_Pedido[] getItens() {
		return itens;
	}
	public void setItens(Item_Pedido[] itens) {
		this.itens = itens;
	}
	    
	 
}
