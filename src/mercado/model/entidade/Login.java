/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.model.entidade;

import java.util.Scanner;
import mercado.model.entidade.Funcionario;

/**
 *
 * @author Bernardo
 */
public class Login {
    private String usuario;
    private String senha;

    public Login() {
        
    }
    
    public String getUsario() {
        return this.usuario;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void imprimiTelaLogin(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Login: ");
        usuario = teclado.next();
        System.out.println("Senha: ");
        senha = teclado.next();
    }
}
