package mercado.view;

import mercado.entidade.Funcionario;
import mercado.entidade.Gerente;
import mercado.entidade.Vendedor;


public class Main {

	public static void main(String[] args) {
		Funcionario f1 = new Gerente();
		System.out.println(f1);
		Funcionario f2 = new Vendedor();
		System.out.println(f2);

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
