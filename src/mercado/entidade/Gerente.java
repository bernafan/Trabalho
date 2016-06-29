package mercado.entidade;

public class Gerente extends Funcionario {
	private static int geradorDeId = 0;
	
	public Gerente(){
        Gerente.geradorDeId++;
        this.id = "G" + geradorDeId;
    }	
    
}
