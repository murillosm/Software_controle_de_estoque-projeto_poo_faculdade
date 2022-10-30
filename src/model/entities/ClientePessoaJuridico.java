package model.entities;

import java.util.Date;

public class  ClientePessoaJuridico extends Cliente {

	private String razaoSocialCliente;
	private String nomeClienteJuridico;
	private String cnpjCliente;



//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\
	public ClientePessoaJuridico(String foneCliente, String emailCliente, Enderecos enderecoCliente, int codCliente,
			Date cadastraC, String razaoSocialCliente, String nomeClienteJuridico, String cnpjCliente) {
		super(foneCliente, emailCliente, enderecoCliente, codCliente);
		this.razaoSocialCliente = razaoSocialCliente;
		this.nomeClienteJuridico = nomeClienteJuridico;
		this.cnpjCliente = cnpjCliente;
	}
///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\
	/**
	 * @return the razaoSocialCliente
	 */
	public String getRazaoSocialCliente() {
		return razaoSocialCliente;
	}

	/**
	 * @param razaoSocialCliente the razaoSocialCliente to set
	 */
	public void setRazaoSocialCliente(String razaoSocialCliente) {
		this.razaoSocialCliente = razaoSocialCliente;
	}

	/**
	 * @return the nomeClienteJuridico
	 */
	public String getNomeClienteJuridico() {
		return nomeClienteJuridico;
	}

	/**
	 * @param nomeClienteJuridico the nomeClienteJuridico to set
	 */
	public void setNomeClienteJuridico(String nomeClienteJuridico) {
		this.nomeClienteJuridico = nomeClienteJuridico;
	}

	/**
	 * @return the cnpjCliente
	 */
	public String getCnpjCliente() {
		return cnpjCliente;
	}

	/**
	 * @param cnpjCliente the cnpjCliente to set
	 */
	public void setCnpjCliente(String cnpjCliente) {
		if(cnpjCliente.length() == 14){
		      //valido = false;
			if (cnpjCliente.substring(0,14).matches("[0-9]*")) {
				this.cnpjCliente = cnpjCliente;
			}
		}
	}



}
