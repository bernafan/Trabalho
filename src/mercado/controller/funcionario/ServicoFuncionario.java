package mercado.controller.funcionario;

import java.util.ArrayList;
import mercado.model.entidade.Funcionario;
import mercado.model.repositories.FuncionariosRepository;

public class ServicoFuncionario {
	
    private FuncionariosRepository funcionarioRepository = new FuncionariosRepository();
    private ArrayList<Funcionario> funcionarios = funcionarioRepository.retornaRepository();
    ControlePersistencia controle = new ControlePersistencia(funcionarioRepository.retornaRepository());
    
    public boolean autenticaUsuario(Funcionario f) {
        if(funcionarioRepository.retornaRepository().contains(f)){ 
               return true;
            }
        return false;
    }

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
        if (vereficaUsuarioNoRepositorio(funcionario)) {
            funcionario.setStatus(true);
            System.out.println("\nUsuário logado: " + funcionario);
        } else {
            System.out.println("Erro no login");
        }
    }
    public boolean vereficaUsuarioNoRepositorio(Funcionario funcionario) {
        //Percorrendo o arrayList
        for (int i = 0; i < funcionarios.size(); i++) {
             /* Pergunta Se o Id da posicao i de um arrayList fr é igual
                ao Id passado pelo parametro.
                Mesma coisa a senha.
             */
            if (funcionarios.get(i).getId().equals(funcionario.getId())
                && funcionarios.get(i).getId().equals(funcionario.getPassword()) ){
                return true;
            }
        }
        return false;
    }
    public Funcionario retornaFunionarioPeloLogin(String usuario, String senha) {
        Funcionario f = new Funcionario();
        return f;
    }
    
    public String mostrarUsuarioAtual() {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getStatus()){
                System.out.println("Usuario Atual: " + funcionarios.get(i).getId());
                return funcionarios.get(i).getId();
            }
        }
        System.out.println("Nenhum usuario logado.");

        return null;
    }
    
    public void salvaRepositorio() {
       controle.salvaArquivo();
    }
    /*public Funcionario retornaFuncionario(String idFuncionario) {
            funcionariosRepository.
    } */

	
}
