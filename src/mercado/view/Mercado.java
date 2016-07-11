package mercado.view;

import java.util.Scanner;
import java.util.Date;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mercado {
	private int option;
        private Scanner teclado = new Scanner(System.in);
	public void viewTelaInicial(){
		System.out.print("\n------------------------------------------------------------");
		System.out.print("\n--------------------------MERCADO---------------------------");
		System.out.print("\n------------------------------------------------------------");
		System.out.print("\n\nDigite a opção desejada:\n1 - Consultar preços\n2 - Login\n");
		
                this.option = this.teclado.nextInt();

		switch (this.option) {
		case 1:  
			this.viewConsulta();
			break;
		case 2:
			this.viewLogin();
			break;
		default:
			System.out.println("Opção inválida!");
			this.viewTelaInicial();
		}
	}
	private void viewConsulta() {
		String consulta = "Exibe a consulta!";//linha que substitui a chamada da função
	
		System.out.print("Insira o código do produto ou 0 para voltar: ");
		this.option = this.teclado.nextInt();

		switch (this.option) {
		case 0:
			this.viewTelaInicial();
			break;
		default:
			System.out.println(consulta);
			this.viewConsulta();
		}
	}
	public void viewLogin(){
		String user;
		String senha;

                String verificaLogin;
		
		System.out.print("\n------------------------------------------------------------");
		System.out.print("\n---------------------------LOGIN----------------------------");
		System.out.print("\n------------------------------------------------------------\n");
		System.out.print("\nUsuário: ");
		user = this.teclado.next().trim();
		
		System.out.print("Senha: ");
		senha = this.teclado.next().trim();
		
                //verificaLogin = user;
		switch (user){
			case "G":
				this.viewGerente();
				break;
			case "F":
				this.viewVendaInicial();
		}
	}
	public void viewGerente() {
		System.out.print("\n------------------------------------------------------------");
		System.out.print("\n--------------------------GERENTE---------------------------");
		System.out.print("\n------------------------------------------------------------\n");
		
		System.out.print("\nDigite a opção desejada:\n1 - Inserir produtos no estoque;\n2 - Relatório de Estoque\n3 - Relatório de vendas;\n0 - Sair\n");
		this.option = this.teclado.nextInt();

		switch (this.option) {
		case 0:
			this.viewTelaInicial();
			break;
		case 1:
			this.viewTelaInsereEstoque();
			break;
		case 2:
			this.viewTelaRelatorioEstoque();
			break;
		case 3:
			this.viewTelaRelatorioVendas();
			break;
		default:
			System.out.println("Código inválido");
			this.viewGerente();
		}
		
	}
	private void viewTelaRelatorioVendas() {
                String dataStr;
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
               
                System.out.print("\n------------------------------------------------------------");
		System.out.print("\n--------------------RELATÓRIO-DE-VENDAS---------------------");
		System.out.print("\n------------------------------------------------------------\n");
                System.out.println("Insira a data no formato: dd/mm/aaaa");
                
                dataStr = this.teclado.next();
                
                LocalDate data = LocalDate.parse(dataStr, formato);
                //Date data = formato.parse(dataStr); Não esta funcionando usando o tipo Date
                
                //Imprime o relatório do dia
                System.out.println("Imprime o relatório do dia: " + data);      
                
                this.menuOpcoesRelatorioVendas();
	}
        
        private void menuOpcoesRelatorioVendas(){
                    System.out.print("\nDigite a opção desejada:\n1 - Imprimir novo relatório;\n2 - Tela Gerente\n0 - Sair\n");
                       this.option = this.teclado.nextInt();

		switch (this.option) {
		case 0:
			this.viewTelaInicial();
			break;
		case 1:
			this.viewTelaRelatorioVendas();
			break;
		case 2:
			this.viewGerente();
			break;
		default:
			System.out.println("Código inválido");
			this.menuOpcoesRelatorioVendas();
            }
        }
 
	private void viewTelaRelatorioEstoque() {
		// TODO Auto-generated method stub
                
		
	}
	private void viewTelaInsereEstoque() {
		// TODO Auto-generated method stub
		
	}
	private void viewVendaInicial() {
            System.out.print("\n------------------------------------------------------------");
            System.out.print("\n---------------------------VENDA----------------------------");
            System.out.print("\n------------------------------------------------------------\n");
            
            System.out.print("\nDigite a opção desejada:\n1 - Nova Venda;\n0 - Sair\n");
            this.option = this.teclado.nextInt();

            switch (this.option) {
		case 0:
                    this.viewTelaInicial();
                    break;
		case 1:
                    this.viewNovaVenda();
                    break;
		default:
                    System.out.println("Código inválido");
                    this.viewVendaInicial();
		}
	}
        private void viewNovaVenda(){
            String nomeProduto;
            double preco, qnt;
            System.out.println("Insira o nome/codigo do produto: ");//precisamos definir se vai entrar o nome ou o código
            nomeProduto = this.teclado.next();
            //verifica se o produto existe
            //imprime o valor do produto
            preco = 12;
            System.out.println("Preço: R$"+preco);
            System.out.println("Insira a quantidade: ");
            qnt = this.teclado.nextDouble();
            //imprime o subtotal
            System.out.println("Subtotal: "+(qnt*preco));
            System.out.println("\nDigite a opção desejada:\n1 - Confirma;\n2 - Cancela\n");
            this.option = this.teclado.nextInt();
            switch (this.option) {
		case 1:
                    //salva as informações em um novo item de venda
                    break;
		case 2:
                    this.viewNovaVenda();
                    break;
		}
            System.out.println("\nDigite a opção desejada:\n1 - Novo Item;\n2 - Finaliza Venda\n");
            this.option = this.teclado.nextInt();
            
            switch(option){
                case 1:
                    this.viewNovaVenda();
                    break;
                case 2:
                    //Venda Cartão
                    System.out.println("Imprime venda cartão/dinheiro");
                    //Salva o pedido
            }
        }
}



/*import java.util.Scanner;
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
        
        
        *//*
        //Criação do Gerente
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
    
        *//*
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
