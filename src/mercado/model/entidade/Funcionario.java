package mercado.model.entidade;

public abstract class Funcionario {

	protected String nome;
	protected String id;
    protected String password;
    protected boolean status;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getId() {
		return this.id;
	}
    public String getPassword(){
        return this.password;
    }
	
    public void setStatus(boolean status){
        this.status = status;
    }
    
    public boolean getStatus(){
        return status;
    }
	public String toString() {
        return "Nome: "+nome+" Id: "+id+" Senha: "+password+"\n";
	}
	
}
