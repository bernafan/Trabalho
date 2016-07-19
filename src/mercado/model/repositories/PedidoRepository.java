package mercado.model.repositories;

import java.io.IOException;
import java.util.ArrayList;
import mercado.controller.pedido.ControlePersistenciaPedido;

import mercado.model.entidade.Pedido;

public class PedidoRepository {
	
	public ArrayList<Pedido> pedidoRepository = new ArrayList();
	ControlePersistenciaPedido controle  =
                new ControlePersistenciaPedido(pedidoRepository);
        
        public void salvaNovoRepositorio() {
        controle.salvaNovoArquivo();
        }
	public void insere(Pedido item) {
            pedidoRepository.add(item);
	}
	
	public void remove(Pedido item){	
            pedidoRepository.remove(item);
	}
       
    public ArrayList retornaRepository() {
            this.pedidoRepository = controle.abreArquivo();
            return this.pedidoRepository;
    }
        
        
    public void overwriteRepositorio(Pedido novoItem) throws IOException, ClassNotFoundException {
        controle.overwriteArquivo(novoItem);
    }
    
}