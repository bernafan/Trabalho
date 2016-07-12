package mercado.model.repositories;

import java.util.ArrayList;

import mercado.model.entidade.Funcionario;


public class FuncionariosRepository {

    private ArrayList<Funcionario> funcionarioRepository = new ArrayList();

    public void insere(Funcionario funcionario) {
        funcionarioRepository.add(funcionario);
    }

    public void remove(Funcionario funcionario) {
       funcionarioRepository.remove(funcionario);
    }
    
    public ArrayList retornaRepository() {
        return this.funcionarioRepository;
    }


}
