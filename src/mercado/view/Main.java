package mercado.view;

import mercado.controller.funcionario.ServicoFuncionario;



public class Main {

    public static void main(String[] args) {
        ServicoFuncionario funcionariosService = new ServicoFuncionario();
        funcionariosService.imprimeFuncionarios();
        
        Mercado mercado = new Mercado();
        mercado.viewTelaInicial();
    
        
    }    
}
