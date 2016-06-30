/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controller.util;

/**
 *
 * @author Bernardo
 */
public class ValidacaoDeUsuario {
    
    public boolean validarUsuario(String idUsuario) {
		return (idUsuario.substring(0).toUpperCase().equals('G'));
	}
}
