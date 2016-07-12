package mercado.model.entidade;

import java.io.Serializable;

public class Gerente extends Funcionario implements Serializable {

    private static int geradorDeId = 0;

    public Gerente(String nome, String password) {
        super.nome = nome;
        super.password = password;
        Gerente.geradorDeId++;
        this.id = "G" + geradorDeId;
    }

}
