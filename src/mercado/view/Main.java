package mercado.view;

import mercado.controller.ServicoSessao;
import mercado.controller.funcionario.ControlePersistencia;
import mercado.model.entidade.Funcionario;
import mercado.model.entidade.Gerente;
import mercado.model.entidade.Vendedor;
import mercado.model.repositories.FuncionariosRepository;

import mercado.controller.funcionario.ServicoFuncionario;

public class Main {

    public static void main(String[] args) {

        Mercado mercado = new Mercado();
        mercado.viewTelaInicial();
        
        
        /* FuncionariosRepository funcionarios = new FuncionariosRepository();
        ServicoFuncionario funcionarioService = new ServicoFuncionario();
     //   ServicoSessao sessao = new ServicoSessao();
        
        Gerente g1 = new Gerente("Carvalho", "123456");

        Vendedor v1 = new Vendedor("Fernandinho", "456123");
        Vendedor v2 = new Vendedor("Marilsa", "789654");
        Vendedor v3 = new Vendedor("Amanda", "789456");
        Vendedor v4 = new Vendedor("Josimar", "753951");
        Vendedor v5 = new Vendedor("Analice", "123234");
        
        
        
        funcionarioService.insereFuncionario(v1);
        funcionarioService.insereFuncionario(v2);
        funcionarioService.insereFuncionario(v3);
        funcionarioService.insereFuncionario(v4);
        funcionarioService.insereFuncionario(v5);
        funcionarioService.insereFuncionario(g1);
        funcionarioService.salvaRepositorio();
        //funcionarioService.imprimeFuncionarios();
        
        funcionarios.imprimeFuncionarios();
        
        //funcionarioService.imprimeFuncionarios();
        
        
        
        //System.out.println(funcionarios.autenticaUsuario(g1));
        //funcionarioService.login(g1);
        //funcionarioService.mostrarUsuarioAtual();
        */
    }    
}
