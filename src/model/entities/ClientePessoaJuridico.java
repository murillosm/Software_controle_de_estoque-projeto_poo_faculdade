package model.entities;

public class ClientePessoaJuridico extends Cliente {

	private String razaoSocialCliente;
	private String cnpjCliente;

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	public ClientePessoaJuridico(Integer idCliente, String nomeCliente, String foneCliente1, String foneCliente2,
			String emailCliente, Endereco enderecoCliente, String razaoSocialCliente, String cnpjCliente) {
		super(idCliente, nomeCliente, foneCliente1, foneCliente2, emailCliente, enderecoCliente);
		this.razaoSocialCliente = razaoSocialCliente;
		this.cnpjCliente = cnpjCliente;
	}

	public ClientePessoaJuridico(String nomeCliente, String cnpjCliente, String razaoSocialCliente, String foneCliente1, String foneCliente2, String emailCliente,
			Endereco enderecoCliente) {
		super(nomeCliente, foneCliente1, foneCliente2, emailCliente, enderecoCliente);
		this.razaoSocialCliente = razaoSocialCliente;
		this.cnpjCliente = cnpjCliente;
	}

	public ClientePessoaJuridico() {
		super();
	}

///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\
	public String getRazaoSocialCliente() {
		return razaoSocialCliente;
	}

	public void setRazaoSocialCliente(String razaoSocialCliente) {
		this.razaoSocialCliente = razaoSocialCliente;
	}

	public String getCnpjCliente() {
		return cnpjCliente;
	}

	public void setCnpjCliente(String cnpjCliente) {
		//if (cnpjCliente.length() == 14) {
			// valido = false;
			//if (cnpjCliente.substring(0, 14).matches("[0-9]*")) {
				this.cnpjCliente = cnpjCliente;
			//}
		//}
	}

	@Override
	public String toString() {
		return "ClientePessoaJuridico [ "
				+ "getIdCliente()=" + getIdCliente() 
				+ ", getNomeCliente()=" + getNomeCliente()
				+ ", razaoSocialCliente=" + razaoSocialCliente 
				+ ", cnpjCliente=" + cnpjCliente
				+ ", getFoneCliente1()=" + getFoneCliente1() 
				+ ", getEmailCliente()=" + getEmailCliente()
				+ ", getEnderecoCliente()=" + getEnderecoCliente() 
				+ ", getFoneCliente2()=" + getFoneCliente2()
				+ ", hashCode()=" + hashCode() 
				+ "]";
	}


	
}
