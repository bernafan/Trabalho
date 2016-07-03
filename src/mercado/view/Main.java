package mercado.view;

import mercado.controller.ServicoSessao;
import mercado.model.entidade.Funcionario;
import mercado.model.entidade.Gerente;
import mercado.model.entidade.Vendedor;
import mercado.model.repositories.FuncionariosRepository;

public class Main {

    public static void main(String[] args) {

        FuncionariosRepository funcionarios = new FuncionariosRepository();
        //   ServicoSessao sessao = new ServicoSessao();

        Gerente g1 = new Gerente("Carvalho", "123456");

        Vendedor v1 = new Vendedor("Fernandinho", "456123");
        Vendedor v2 = new Vendedor("Marilsa", "789654");
        Vendedor v3 = new Vendedor("Amanda", "789456");
        Vendedor v4 = new Vendedor("Josimar", "753951");
        Vendedor v5 = new Vendedor("Analice", "123234");

        funcionarios.insere(v1);
        funcionarios.insere(v2);
        funcionarios.insere(v3);
        funcionarios.insere(v4);
        funcionarios.insere(v5);
        funcionarios.insere(g1);

        funcionarios.imprimeFuncionarios();

        System.out.println(funcionarios.autenticaUsuario(g1));
        //teste primeiro login
        funcionarios.login(v1);
        funcionarios.mostrarUsuarioAtual();
        //teste trocando usuario
        System.out.println("\nTrocando usuario");
        funcionarios.trocarUsuario(v5);

        funcionarios.mostrarUsuarioAtual();
//            Funcionario f1 = new Gerente();
//            System.out.println(f1);
//            Funcionario f2 = new Vendedor();
//            System.out.println(f2);

    }

    /*
	
	public static Funcionario geraGerente(Funcionario f) {
		Scanner teclado1 = new Scanner(System.in);
		f = new Gerente();
		System.out.println("Nome: ");
		f.setNome(teclado1.next());
		return f;
	}
	
	public static Funcionario geraVendedor(Funcionario f) {
		Scanner teclado2 = new Scanner(System.in);	
		f = new Vendedor();
		System.out.println("Nome: ");
		f.setNome(teclado2.next());
		return f;
	} */
}
