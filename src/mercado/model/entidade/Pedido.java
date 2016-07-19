package mercado.model.entidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Pedido implements Serializable{
    private Date data = new Date(System.currentTimeMillis());
    private ArrayList <Item_Pedido> itens = new ArrayList<>();
    private double total = 0;
    private int caixa;
    private Funcionario fResponsavel;
    
    public Pedido (Funcionario fResponsavel, int caixa){
        this.fResponsavel = fResponsavel;
        this.caixa = caixa;
    }
    
    public void insereItemPedido(Item_Pedido item){
        itens.add(item);
        this.total += item.getSubTotal();
    }
    
    public double getTotal(){
        return this.total;
    }
    
    public int getCaixa(){
        return this.caixa;
    }    
    
    
    @Override
    public String toString() {
        return "\n\nDia: " + data.toString() + "\nCaixa: "+ getCaixa() + 
                "\nFuncionario: "+ fResponsavel.getNome() + itens.toString() +
                "\nTOTAL: R$ " + total;
    }
}
