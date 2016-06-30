package mercado.view;

import java.util.Scanner;
import mercado.controller.compra.ServicoCompraAppService;
import mercado.model.entidade.Login;
import mercado.model.entidade.Caixa;


public class Mercado {
    // variavel para fazer compra
    private ServicoCompraAppService servicoCompra;
    
    private Login login;
    // Construtor
	public Mercado() {
        System.out.println("Mercado");
        montaTela();
    }
    
    
    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        
      
    }    

    private void montaTela() {
       // montagem da janela
       login = new Login();
       login.imprimiTelaLogin();
       abreCaixa(login); 
        
        
        
        /*//Criação do Gerente
        Gerente g1 = new Gerente("G1", 1234);
        
        //Criação dos Funcionarios
        Funcionario f1 = new Funcionario ("F1", 1234);
        Funcionario f2 = new Funcionario ("F2", 1234);
        Funcionario f3 = new Funcionario ("F3", 1234);
        Funcionario f4 = new Funcionario ("F4", 1234);
        Funcionario f5 = new Funcionario ("F5", 1234);
        
        
        
        //Criação do Estoque
        Produto prod1 = new Produto("Arroz", 10.00);
        Item_Estoque itemEstoque1 = new Item_Estoque(prod1, 20);
        Estoque estoque = new Estoque();
        estoque.adicionaItemEstoque(itemEstoque1);
        
        Produto prod2 = new Produto("Feijão", 10.00);
        Item_Estoque itemEstoque2 = new Item_Estoque(prod2, 20);
        estoque.adicionaItemEstoque(itemEstoque2);
    
        */
    }

    private void abreCaixa(Login login) {
        
        Scanner teclado = new Scanner(System.in);
        criaCaixas();
        System.out.println("Diga qual caixa está utilizando: ");
        int codigoCaixa = teclado.nextInt();
        servicoCompra = new ServicoCompraAppService();
        servicoCompra.abreCompra(codigoCaixa, sessao);
    }

    void criaCaixas() {
        //Criação dos Caixas
        Caixa c1 = new Caixa(1);
        Caixa c2 = new Caixa(2);
        Caixa c3 = new Caixa(3);
    }

}
