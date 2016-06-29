package mercado.controller;

import mercado.entidade.Funcionario;
import mercado.model.FuncionariosRepository;

public class ServicoFuncionarioAppService {
	
	private FuncionariosRepository funcionariosRepository;
	
	// melhor OO
	
	public void insereFuncionario(Funcionario func) {
		funcionariosRepository.insere(func);
	}
	
	public void removeFuncionario(Funcionario func) {
		funcionariosRepository.remove(func);
	}
	
	/*public Funcionario retornaFuncionario(String idFuncionario) {
		funcionariosRepository.
	} */
	
	
	
}
