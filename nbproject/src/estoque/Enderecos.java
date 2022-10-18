package estoque;

public class Enderecos{
	public String rua = "";
	public String numero = "";
	public String cep = "";
	public String bairro = "";
	public String cidadade = "";
	public String estado = "";

	// Start of user code (user defined attributes for Endereços)

	// End of user code

	public Enderecos() {
		// Start of user code constructor for Endereços)
		super();
		// End of user code
	}


	public void diponibilizarEndere�o() {
		// Start of user code for method diponibilizarEndereço
		// End of user code
	}
//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * @param rua
	 * @param numero
	 * @param cep
	 * @param bairro
	 * @param cidadade
	 * @param estado
	 */
	public Enderecos(String rua, String numero, String cep, String bairro, String cidadade, String estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidadade = cidadade;
		this.estado = estado;
	}



///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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


	public String getCidadade() {
		return cidadade;
	}


	public void setCidadade(String cidadade) {
		this.cidadade = cidadade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}



}
