package mercado.controller.funcionario;

import mercado.model.entidade.Funcionario;
import mercado.model.repositories.FuncionariosRepository;

public class ServicoFuncionario {
	
    private FuncionariosRepository funcionarioRepository = new FuncionariosRepository();
    ControlePersistencia controle;
    // melhor OO

    public void insereFuncionario(Funcionario func) {
        funcionarioRepository.insere(func);
    }

    public void removeFuncionario(Funcionario func) {
        funcionarioRepository.remove(func);
    }
	
    public void imprimeFuncionarios() {
        controle.abreArquivo();
    }

    public void setUsuarioAtual(Funcionario funcionario) {
        funcionario.setStatus(true);
    }

    public void login(Funcionario funcionario) {
        if (funcionarioRepository.vereficaUsuarioNoRepositorio(funcionario)) {
            funcionario.setStatus(true);
            System.out.println("\nUsuário logado: " + funcionario);
        } else {
            System.out.println("Erro no login");
        }
    }
    public Funcionario retornaFunionarioPeloLogin(String usuario, String senha) {
        Funcionario f = new Funcionario();
        return f;
    }
    
    public void salvaRepositorio() {
       controle  = new ControlePersistencia(funcionarioRepository.getRepository());
    }
    /*public Funcionario retornaFuncionario(String idFuncionario) {
            funcionariosRepository.
    } */

	
}
