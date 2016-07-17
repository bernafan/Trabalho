package mercado.controller.funcionario;

import java.io.IOException;
import java.util.ArrayList;
import mercado.model.entidade.Funcionario;
import mercado.model.entidade.Gerente;
import mercado.model.entidade.Vendedor;
import mercado.model.repositories.FuncionariosRepository;

public class ServicoFuncionario {
	
    private FuncionariosRepository funcionarioRepository = new FuncionariosRepository();
    
    public void insereFuncionario(Funcionario func) throws IOException, ClassNotFoundException {
        this.funcionarioRepository.insere(func);
    }

    public void removeFuncionario(Funcionario func) {
        this.funcionarioRepository.remove(func);
    }
	
    public void salvaNovoRepositorio() {
        funcionarioRepository.salvaNovoRepositorio();
    }
    public void insereNovoFuncionario(Funcionario novoFuncionario) throws IOException, ClassNotFoundException {
        funcionarioRepository.overwriteRepositorio(novoFuncionario);
    }
    
    public void imprimeFuncionarios() {
        System.out.println(funcionarioRepository.retornaRepository());
    }

     public boolean autenticaUsuario(Funcionario f) {
        if(funcionarioRepository.retornaRepository().contains(f)){ 
               return true;
            }
        return false;
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
        for (int i = 0; i < funcionarioRepository.retornaRepository().size(); i++) {
             /* Pergunta Se o Id da posicao i de um arrayList fr é igual
                ao Id passado pelo parametro.
                Mesma coisa a senha.
             */
             Funcionario func;
             func = (Funcionario) funcionarioRepository.retornaRepository().get(i);
            if (func.getId().equals(funcionario.getId())
                && func.getPassword().equals(funcionario.getPassword()) ){
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
        for (int i = 0; i < funcionarioRepository.retornaRepository().size(); i++) {
            Funcionario func ;
            func = (Funcionario) funcionarioRepository.retornaRepository().get(i);
            if (func.getStatus()){
                System.out.println("Usuario Atual: " + func.getId());
                return func.getId();
            }
        }
        System.out.println("Nenhum usuario logado.");

        return null;
    }
    
    public String retornaTipoFunc(Funcionario f){
        String tipoUsuario = f.getId().substring(0, 1);
        
        if(tipoUsuario.equals("G")){
            return "G";
        }else if(tipoUsuario.equals("V")){
            return "V";
        }
        
        return " ";
    }

	
}
