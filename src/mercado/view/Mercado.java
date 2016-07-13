package mercado.view;

import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import mercado.controller.estoque.ServicoEstoque;
import mercado.controller.funcionario.ServicoFuncionario;
import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Peso;
import mercado.model.entidade.Item_Estoque_Unidade;
import mercado.model.entidade.Produto;

public class Mercado {
	private int option;
        private Scanner teclado = new Scanner(System.in);
	ServicoFuncionario servicosDeFuncionarios = new ServicoFuncionario();
        
        public void viewTelaInicial() throws IOException, ClassNotFoundException{
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
        
	private void viewConsulta() throws IOException, ClassNotFoundException {
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
        
	public void viewLogin() throws IOException, ClassNotFoundException{
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

            //Pega o user e senha digitados e Loga usuário
            //servicosDeFuncionarios.login(servicosDeFuncionarios.retornaFunionarioPeloLogin(user, senha));
            switch (user){
                    case "G":
                            this.viewGerente();
                            break;
                    case "F":
                            this.viewVendaInicial();
                            break;
                    default:
                            System.out.println("Usuario inválido, tente novamente...");
                            this.viewLogin();
            }
	}
        
	public void viewGerente() throws IOException, ClassNotFoundException {
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
        
	private void viewTelaRelatorioVendas() throws IOException, ClassNotFoundException {
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
        
        private void menuOpcoesRelatorioVendas() throws IOException, ClassNotFoundException{
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
	private void viewTelaInsereEstoque() throws IOException, ClassNotFoundException {
            ServicoEstoque estoqueService = new ServicoEstoque();
            String nome = null;
            double valorDeVenda;
            float custo;
            
            System.out.println("Insira o nome do produto:");
            nome = this.teclado.next();
            System.out.println("Insira o custo do produto:");
            custo = this.teclado.nextFloat();
            System.out.println("Insira o valor de venda do produto:");
            valorDeVenda = this.teclado.nextDouble();
            System.out.println("O produto é por peso ou unidade?\nDigite 'P' para peso e 'U' para unidade:\n");
            String tipoProduto = this.teclado.next();
            
            switch(tipoProduto){
                case "P":
                    double pesoQnt;
                    System.out.println("Insira o peso total do produto:");
                    pesoQnt = this.teclado.nextDouble();
                    Item_Estoque_Peso itemPeso = 
                            new Item_Estoque_Peso(new Produto(nome, valorDeVenda, custo) , pesoQnt);
                    estoqueService.insereNovoItemProduto(itemPeso);
                    break;
                case "U":
                    int unidadeQnt = 0;
                    System.out.println("Insira a quantidade do produto:");
                    pesoQnt = this.teclado.nextDouble();
                    Item_Estoque_Unidade itemUnidade = 
                            new Item_Estoque_Unidade(new Produto(nome, valorDeVenda, custo), unidadeQnt);
                    estoqueService.insereNovoItemProduto(itemUnidade);
                    unidadeQnt = this.teclado.nextInt();
                    
                    break;
            }	
	}
	private void viewVendaInicial() throws IOException, ClassNotFoundException {
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
