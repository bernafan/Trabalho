package mercado.model.repositories;

import java.util.ArrayList;

import mercado.model.entidade.Funcionario;
//import mercado.model.entidade.Gerente;
//import mercado.model.entidade.Vendedor;

public class FuncionariosRepository {

    // melhor orienta��o a objetos
    private ArrayList<Funcionario> fr = new ArrayList();

    public void insere(Funcionario funcionario) {
        fr.add(funcionario);
    }

    public void remove(Funcionario funcionario) {
        fr.remove(funcionario);
    }

    //public Funcionario retornaFuncionario() {
    //funcionarioRepository.
    //}
    /*
	// pior orienta��o a objetos(repositorios separados)
	private ArrayList<Gerente> gerenteRepository;
	private ArrayList<Vendedor> vendedorRepository;
	
	public void insereNoVendedorRepository(Funcionario funcionario) {
		Vendedor vendedor = (Vendedor) funcionario;
		vendedorRepository.add(vendedor);
	}

	public void insereNoGerenteRepository(Funcionario funcionario) {
		Gerente gerente = (Gerente) funcionario;
		gerenteRepository.add(gerente);
	}
	
     */
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

    public void mostrarUsuarioAtual() {
        for (int i = 0; i < fr.size(); i++) {
            if (fr.get(i).getStatus()) {
                System.out.println("Usuario Atual: "+fr.get(i).getId());
            } else {
                System.out.println("Nenhum usuario logado.");

            }
        }

    }
}
