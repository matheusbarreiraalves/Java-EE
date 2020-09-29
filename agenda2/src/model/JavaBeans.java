package model;

public class JavaBeans {
	private String idcliente;
	private String nomecliente;
	private String cpf;
	private String telefone;
	private String sexo;
	
	public JavaBeans(){
		
	}
	
	public JavaBeans(String idcliente, String nomecliente, String cpf, String telefone, String sexo) {
	 this.idcliente = idcliente;
	 this.nomecliente = nomecliente;
	 this.cpf = cpf;
	 this.telefone = telefone;
	 this.sexo = sexo;
	}
	
	public String getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
}	
