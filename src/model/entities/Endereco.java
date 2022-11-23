package model.entities;

public class Endereco {

	//public int idEnderecos;
	private String endereco;
	private String numero;
	private String cep;
	private String bairro;
	private Cidades cidade;
	private Estados estado;
//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\
	
	
	
	public Endereco(String endereco, String bairro, String cep, String numero, Cidades cidade, Estados estado) {
		super();
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco() {
		// Start of user code constructor for Endereços)
		super();
		// End of user code
	}


///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	

	
///////////////////to string\\\\\\\\\\\\\\\\\\\\\\\

	@Override
	public String toString() {
		return "endereco=" + endereco + ", numero=" + numero + ", cep=" + cep + ", bairro=" + bairro
				+ ", " + cidade ;
	}



}
