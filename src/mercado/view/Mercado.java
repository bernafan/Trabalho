package mercado.view;

import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import mercado.controller.estoque.ServicoEstoque;
import mercado.controller.funcionario.ServicoFuncionario;
import mercado.controller.pedido.ServicoPedido;
import mercado.model.entidade.Funcionario;
import mercado.model.entidade.Gerente;
import mercado.model.entidade.Item_Estoque;
import mercado.model.entidade.Item_Estoque_Peso;
import mercado.model.entidade.Item_Estoque_Unidade;
import mercado.model.entidade.Item_Pedido;
import mercado.model.entidade.Pedido;
import mercado.model.entidade.Produto;

public class Mercado {

    private int option;
    private Scanner teclado = new Scanner(System.in);
    ServicoFuncionario servicosDeFuncionarios = new ServicoFuncionario();
    ServicoPedido servicoPedido = new ServicoPedido();
    ServicoEstoque servicoEstoque = new ServicoEstoque();
    
    public void viewTelaInicial() throws IOException, ClassNotFoundException {
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
        String nomeProduto = "Exibe a consulta!";//linha que substitui a chamada da função
        System.out.print("Insira o nome do produto ou 0 para voltar: ");
        
        nomeProduto = this.teclado.next().trim();
        System.out.println(servicoPedido.retornaProdutoPeloNome(nomeProduto));
        this.option = this.teclado.nextInt();

        switch (this.option) {
            case 0:
                this.viewTelaInicial();
                break;
            default:
                System.out.println(nomeProduto);
                this.viewConsulta();
        }
    }

    public void viewLogin() throws IOException, ClassNotFoundException {

        Funcionario funcAtual = new Funcionario();
       
        String user;
        String senha;
        int caixa;
        System.out.print("\n------------------------------------------------------------");
        System.out.print("\n---------------------------LOGIN----------------------------");
        System.out.print("\n------------------------------------------------------------\n");
        System.out.print("\nUsuário: ");

        user = this.teclado.next().trim();
        funcAtual.setId(user);

        System.out.print("Senha: ");
        senha = this.teclado.next().trim();
        funcAtual.setPassword(senha);
        
        
        servicosDeFuncionarios.login(funcAtual);
        
        
        //Retorno do tipo do usuario que foi logado
        String tipoUsuario = servicosDeFuncionarios.retornaTipoFunc(funcAtual);

        switch (tipoUsuario) {
            case "G":
                this.viewGerente();
                break;
            case "V":
                System.out.println("\nQual caixa está usando 1, 2, 3, 4, 5 : ");
                caixa = this.teclado.nextInt();
                this.viewVendaInicial(funcAtual, caixa);
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
        //System.out.println("Insira a data no formato: dd/mm/aaaa");
        servicoPedido.imprimePedidos();
        dataStr = this.teclado.next();

        LocalDate data = LocalDate.parse(dataStr, formato);
        //Date data = formato.parse(dataStr); Não esta funcionando usando o tipo Date

        //Imprime o relatório do dia
        System.out.println("Imprime o relatório do dia: " + data);

        this.menuOpcoesRelatorioVendas();
    }

    private void menuOpcoesRelatorioVendas() throws IOException, ClassNotFoundException {
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

    private void viewTelaRelatorioEstoque() throws IOException, ClassNotFoundException {
        ServicoEstoque estoqueService = new ServicoEstoque();
        estoqueService.imprimeProdutos();
        
        System.out.println("\n\nDigite qualquer numero para voltar ao menu gerente: ");
        this.option = this.teclado.nextInt();
        switch(option){
            default: 
                this.viewGerente();
        }
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

        switch (tipoProduto) {
            case "P":
                double pesoQnt;
                System.out.println("Insira o peso total do produto:");
                pesoQnt = this.teclado.nextDouble();
                Item_Estoque_Peso itemPeso
                        = new Item_Estoque_Peso(new Produto(nome, valorDeVenda, custo), pesoQnt);
                estoqueService.insereNovoItemProduto(itemPeso);
                break;
            case "U":
                int unidadeQnt = 0;
                System.out.println("Insira a quantidade do produto:");
                pesoQnt = this.teclado.nextDouble();
                Item_Estoque_Unidade itemUnidade
                        = new Item_Estoque_Unidade(new Produto(nome, valorDeVenda, custo), unidadeQnt);
                estoqueService.insereNovoItemProduto(itemUnidade);
                unidadeQnt = this.teclado.nextInt();

                break;
        }
    }

    private void viewVendaInicial(Funcionario fResponsavel, int caixa) throws IOException, ClassNotFoundException {
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
                this.viewNovaVenda(fResponsavel, caixa);
                break;
            default:
                System.out.println("Código inválido");
                this.viewVendaInicial(fResponsavel, caixa);
        }
    }


    
    private void viewNovaVenda(Funcionario fResponsavel, int caixa) throws IOException, ClassNotFoundException {
        Pedido novoPedido = new Pedido(fResponsavel, caixa);
        this.option = 0;
        do{
            novoPedido.insereItemPedido(this.viewNovoItemPedido(fResponsavel, caixa));
            if(novoPedido != null){
                System.out.println("TOTAL: "+ novoPedido.getTotal());
                System.out.println("Deseja Finalizar a venda?\nDigite 1 para Sim e 2 para não: ");
                this.option = this.teclado.nextInt();
            }
        }while(this.option == 2);
        this.tipoPagamento(novoPedido);
        //Jogar o Pedido no Pedido Repository
        servicoPedido.incluirPedido(novoPedido);
        servicoPedido.salvaNovoRepositorio();
        this.viewVendaInicial(fResponsavel, caixa);
    }
    
    private Item_Pedido viewNovoItemPedido(Funcionario fResponsavel, int caixa) throws IOException, ClassNotFoundException{//AQUI PRECISAMOS ALTERAR  O getTipo()
        String nomeProduto;
        double preco, qntPeso;
        int qntUnidade;
        Item_Estoque novoProduto;
        novoProduto = this.viewConsultaProduto();
        System.out.println("Preço: R$" + novoProduto.produto.getValor());
        switch(novoProduto.getTipo()){
            case "P":
                qntPeso = this.verificaQuantidadePeso((Item_Estoque_Peso) novoProduto);
                System.out.println("Subtotal: " + (qntPeso * novoProduto.produto.getValor()));
                System.out.println("\nDigite a opção desejada:\n1 - Confirma;\n2 - Cancela Item\n3 - Cancela Venda");
                this.option = this.teclado.nextInt();
                switch (this.option) {
                    case 1:
                        Item_Pedido novoItem = new Item_Pedido(novoProduto.produto, qntPeso);
                        servicoEstoque.removePeso((Item_Estoque_Peso) novoProduto, qntPeso);
                        return novoItem;
                    case 2:
                        this.viewNovaVenda(fResponsavel, caixa);
                        break;
                    case 3:
                        return null;
                }
            case "U":
                qntUnidade = this.verificaQuantidadeUnidade((Item_Estoque_Unidade) novoProduto);
                System.out.println("Subtotal: " + (qntUnidade * novoProduto.produto.getValor()));
                System.out.println("\nDigite a opção desejada:\n1 - Confirma;\n2 - Cancela Item\n3 - Cancela Venda");
                this.option = this.teclado.nextInt();
                switch (this.option) {
                    case 1:
                        Item_Pedido novoItem = new Item_Pedido(novoProduto.produto, qntUnidade);
                        servicoEstoque.removeUnidade((Item_Estoque_Unidade) novoProduto, qntUnidade);
                        //subtrai a quantidade do estoque
                        return novoItem;
                    case 2:
                        this.viewNovaVenda(fResponsavel, caixa);
                        break;
                    case 3:
                        return null;
                }
            default:
                return null;
        }
    }
    
    private double verificaQuantidadePeso(Item_Estoque_Peso novoProduto){
        double qntPeso;
        System.out.println("Insira a quantidade em kg:");
        qntPeso = this.teclado.nextDouble();
        if(qntPeso<=novoProduto.getQtd()){
            return qntPeso;
        }else{
            System.out.println("A quantidade excede o estoque, tente novamente.");
            return this.verificaQuantidadePeso(novoProduto);
        }
    }
    
    private int verificaQuantidadeUnidade(Item_Estoque_Unidade novoProduto){
        int qntUnidade;
        System.out.println("Insira a quantidade:");
        qntUnidade = this.teclado.nextInt();
        if(qntUnidade<=novoProduto.getQtd()){
            return qntUnidade;
        }else{
            System.out.println("A quantidade excede o estoque, tente novamente.");
            return this.verificaQuantidadeUnidade(novoProduto);
        }
    }
    
    private void tipoPagamento(Pedido novoPedido){
        System.out.println("Deseja pagar em dinheiro ou cartão?\nDigite 1 para Dinheiro e 2 para Cartão");

        this.option = this.teclado.nextInt();
        switch(this.option){
            case 1:
                pagamentoDinheiro(novoPedido.getTotal());
                break;
            case 2:
                System.out.println("Obrigado!");
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                this.tipoPagamento(novoPedido);
        }
    }
    
    private void pagamentoDinheiro(double total){
        double pagamento;
        System.out.println("Insira o valor para pagamento em R$: ");
        pagamento = this.teclado.nextDouble();
        if(pagamento >= total){
            System.out.println("Troco: " + (pagamento - total) + "\nObrigado!");
        }
    }
    
    private Item_Estoque viewConsultaProduto(){
        String nomeProduto;
        Item_Estoque novoProduto;
        System.out.println("Insira o nome do produto: ");
        nomeProduto = this.teclado.next();
        novoProduto = servicoPedido.retornaProdutoPeloNome(nomeProduto);
        //Essas duas linhas acima são para testes
        if(novoProduto == null){
            System.out.print("Produto não existe, digite novamente");
            return this.viewConsultaProduto();
        }
        return novoProduto;
    }
}