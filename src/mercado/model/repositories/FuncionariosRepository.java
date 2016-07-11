package mercado.model.repositories;

import java.util.ArrayList;

import mercado.model.entidade.Funcionario;
//import mercado.model.entidade.Gerente;
//import mercado.model.entidade.Vendedor;

public class FuncionariosRepository {

    // melhor orienta��o a objetos
    private ArrayList<Funcionario> funcionarioRepository = new ArrayList();

    public void insere(Funcionario funcionario) {
        funcionarioRepository.add(funcionario);
    }

    public void remove(Funcionario funcionario) {
       funcionarioRepository.remove(funcionario);
    }
    
    public ArrayList getRepository() {
        return this.funcionarioRepository;
    }
    public void imprimeFuncionarios() {
        System.out.println(fr);
    }

    public void setUsuarioAtual(Funcionario f) {
        f.setStatus(true);
    }
    
    //Função para verificar se o usuario e senha estao no bd
    public boolean autenticaUsuario(Funcionario f) {
        //Percorrendo o arrayList
        for (int i = 0; i < fr.size(); i++) {

            /* Pergunta Se o Id da posicao i de um arrayList fr é igual
                ao Id passado pelo parametro.
                Mesma coisa a senha.
             */
            if (fr.get(i).getId().equals(f.getId()) && fr.get(i).getPassword().equals(f.getPassword())) {
                System.out.println(fr);
                return true;

            }
        }    
        return false;
    }
    
    public void login(Funcionario f) {
        if (autenticaUsuario(f)) {
            f.setStatus(true);
            System.out.println("Usuario Logado! ");
        } else {
            System.out.println("Erro no login");
        }
    }
    //Função para verificar se o usuario e senha estao no bd
    public boolean vereficaUsuarioNoRepositorio(Funcionario funcionario) {
        //Percorrendo o arrayList
        for (int i = 0; i < funcionarioRepository.size(); i++) {
             /* Pergunta Se o Id da posicao i de um arrayList fr é igual
                ao Id passado pelo parametro.
                Mesma coisa a senha.
             */
            if (funcionarioRepository.get(i).getId().equals(funcionario.getId()) 
                    && funcionarioRepository.get(i).getPassword().equals(funcionario.getPassword())) {
                System.out.println(funcionarioRepository);
                return true;
            }
        }
        return false;
    }

    

    public void mostrarUsuarioAtual() {
        for (int i = 0; i < funcionarioRepository.size(); i++) {
            if (funcionarioRepository.get(i).getStatus()) {
                System.out.println("Usuario Atual: "+funcionarioRepository.get(i).getId());
            } else {
                System.out.println("Nenhum usuario logado.");

            }
        }

    }
}
