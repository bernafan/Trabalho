package mercado.model.entidade;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private double valorDeVenda;
    private double custo;
    private static int geradorDeId;
    private String id;
    
    public Produto(String nome, double valorDeVenda, double custo) {
        this.nome = nome;
        this.valorDeVenda = valorDeVenda;
        this.custo = custo;
    	Produto.geradorDeId++;
        this.setId("P" + geradorDeId);
    }
    
    public String getId() {
        return id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getValor(){
        return this.valorDeVenda;
    }
    
    public double getCusto() {
    	return this.custo;
    }

    public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(double valor) {
		this.valorDeVenda = valor;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
        
        return "Nome: " + nome + "\nValor: " + this.valorDeVenda+ "\n";
 
	}
}
