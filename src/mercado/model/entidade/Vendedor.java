package mercado.model.entidade;

import java.io.Serializable;

public class Vendedor extends Funcionario implements Serializable {

    private static int geradorDeId = 0;

    public Vendedor(String nome, String password) {
        super.nome = nome;
        super.password = password;
        Vendedor.geradorDeId++;
        this.id = "V" + geradorDeId;
    }
}
