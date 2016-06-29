package mercado.entidade;

public class Vendedor extends Funcionario {
	private static int geradorDeId = 0;
	
	public Vendedor(){
        Vendedor.geradorDeId++;
        this.id = "V" + geradorDeId;
    }
}
