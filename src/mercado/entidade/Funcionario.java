package mercado.entidade;

public abstract class Funcionario {
	protected String nome;
	protected String id;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String toString() {
        String mensagem;
        mensagem = ("Nome: " + nome);
        mensagem += "\nID: " + getId();
        return mensagem;
	}
	
	
}
