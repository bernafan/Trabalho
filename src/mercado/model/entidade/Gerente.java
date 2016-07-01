package mercado.model.entidade;

public class Gerente extends Funcionario {

    private static int geradorDeId = 0;

    public Gerente(String nome, String password) {
        super.nome = nome;
        super.password = password;
        Gerente.geradorDeId++;
        this.id = "G" + geradorDeId;
    }

}
