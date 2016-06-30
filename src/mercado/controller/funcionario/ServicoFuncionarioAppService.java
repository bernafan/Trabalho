package mercado.controller.funcionario;

import mercado.model.entidade.Funcionario;
import mercado.model.repositories.FuncionariosRepository;

public class ServicoFuncionarioAppService {
	
	private FuncionariosRepository funcionariosRepository;
	
	// melhor OO
	
	public void insereFuncionario(Funcionario func) {
		funcionariosRepository.insere(func);
	}
	
	public void removeFuncionario(Funcionario func) {
		funcionariosRepository.remove(func);
	}
	
        
        public Funcionario retornaFunionarioPeloLogin(String usuario, String senha) {
        Funcionario f = new Funcionario();
        return f;
    }
	/*public Funcionario retornaFuncionario(String idFuncionario) {
		funcionariosRepository.
	} */
	
	
	
}
