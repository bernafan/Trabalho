package mercado.view;

import java.io.IOException;
import mercado.controller.estoque.ServicoEstoque;
import mercado.controller.funcionario.ServicoFuncionario;


public class Main {
    /*  
        ALGUMAS DICAS ATENS DE RODAR A MAIN
    
        1- RODAR AS CLASSES: GERAFUNCIONARIO, GERAPRODUTOS E GERAPEDIDOS 
        PARA CRIAR OS ARQUIVOS.DAT DEFAULT
    
        FUNCIONARIOS CRIADOS POR DEFAULT:
    
        GERENTE                 VENDEDOR    
        NOME: CARVALHO          NOME: FERNANDINHO
        USUARIO: G1             USUARIO: V1
        SENHA:123               SENHA: 123
        
        VENDEDOR                 VENDEDOR
        NOME: MARILSA            NOME: AMANDA
        USUARIO: V2              USUARIO: V3
        SENHA: 456               SENHA: 789
    
        PRODUTOS DEFAUT
        Laranja 
        Qnt:
        

        
    */
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // imprime produtos do estoque
        //ServicoEstoque estoqueService = new ServicoEstoque();
        //estoqueService.imprimeProdutos();

        
        Mercado mercado = new Mercado();
        mercado.viewTelaInicial();
    }
}
