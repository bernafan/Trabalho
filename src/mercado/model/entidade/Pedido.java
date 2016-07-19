package mercado.model.entidade;
import java.util.ArrayList;
import java.util.Date;


public class Pedido {
    private Date data = new Date(System.currentTimeMillis());
    private String usuario;
    private ArrayList <Item_Pedido> itens = new ArrayList<>();
    private double total = 0;
    
    public Pedido (String usuario){
        this.usuario = usuario;
    }
    
    public void insereItemPedido(Item_Pedido item){
        itens.add(item);
        this.total += item.getSubTotal();
    }
    
    public double getTotal(){
        return this.total;
    }
    
    @Override
    public String toString() {
        return "\n\nDia: " + data.toString() + "\nCaixa: " + usuario + itens.toString() + "\nTOTAL: R$ " + total;
    }
}
