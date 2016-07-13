package mercado.model.repositories;

import java.io.IOException;
import java.util.ArrayList;
import mercado.controller.funcionario.ControlePersistenciaFuncionarios;

import mercado.model.entidade.Funcionario;


public class FuncionariosRepository {

    private ArrayList<Funcionario> funcionarioRepository = new ArrayList();
    ControlePersistenciaFuncionarios controle = new ControlePersistenciaFuncionarios(funcionarioRepository);
    
    public void salvaNovoRepositorio() {
        controle.salvaNovoArquivo();
    }
    
    public void overwriteRepositorio(Funcionario novoFuncionario) throws IOException, ClassNotFoundException {
        controle.overwriteArquivo(novoFuncionario);
    }
       
    public void insere(Funcionario funcionario) {
        this.funcionarioRepository.add(funcionario);
    }

    public void remove(Funcionario funcionario) {
       this.funcionarioRepository.remove(funcionario);
    }
    
    public ArrayList retornaRepository() {
        this.funcionarioRepository = controle.abreArquivo();
        return this.funcionarioRepository;
    }


}
