package mercado.controller;

import mercado.model.repositories.FuncionariosRepository;

public class ServicoSessao {
    
    FuncionariosRepository funcionarioRepository = new FuncionariosRepository();
    
    public boolean autenticaUsuario(){
        return true;
    }
    
}
