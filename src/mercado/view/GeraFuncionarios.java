/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.view;

import mercado.controller.funcionario.ServicoFuncionario;
import mercado.model.entidade.Gerente;
import mercado.model.entidade.Vendedor;
import mercado.model.repositories.FuncionariosRepository;

/**
 *
 * @author Bernardo
 */
public class GeraFuncionarios {
    public static void main(String[] args) {
       
        FuncionariosRepository funcionarios = new FuncionariosRepository();
        ServicoFuncionario funcionarioService = new ServicoFuncionario();
        
        Gerente g1 = new Gerente("Carvalho", "123456");

        Vendedor v1 = new Vendedor("Fernandinho", "456123");
        Vendedor v2 = new Vendedor("Marilsa", "789654");
        Vendedor v3 = new Vendedor("Amanda", "789456");
        
        funcionarioService.insereFuncionario(v1);
        funcionarioService.insereFuncionario(v2);
        funcionarioService.insereFuncionario(v3);
        funcionarioService.insereFuncionario(g1);
        funcionarioService.salvaRepositorio();
        funcionarioService.imprimeFuncionarios();
    }
}