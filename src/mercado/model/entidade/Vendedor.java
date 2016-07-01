package mercado.model.entidade;

public class Vendedor extends Funcionario {

    private static int geradorDeId = 0;

    public Vendedor(String nome, String password) {
        super.nome = nome;
        super.password = password;
        Vendedor.geradorDeId++;
        this.id = "V" + geradorDeId;
    }
}
