package model.entities;

import java.util.Date;

public class ClientePessoaFisica extends Cliente {

	private String cpfCliente;
	private Date dataNasc;

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	
	public ClientePessoaFisica(Integer idCliente, String nomeClienteFisica, String foneCliente,
							   String emailCliente, Endereco enderecoCliente, String cpfCliente, Date dataNasc) {
		super(idCliente, nomeClienteFisica, foneCliente, emailCliente, cpfCliente, enderecoCliente);
		this.cpfCliente = cpfCliente;
		this.dataNasc = dataNasc;
	}
	
	
	public ClientePessoaFisica() {
		super();
	}


	public ClientePessoaFisica(String nomeCliente, String foneCliente1, String foneCliente2, String emailCliente,
			Endereco enderecoCliente, String cpfCliente, Date dataNasc) {
		super(nomeCliente, foneCliente1, foneCliente2, emailCliente, enderecoCliente);
		this.cpfCliente = cpfCliente;
		this.dataNasc = dataNasc;
	}

///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\

	/**
	 * @return the cpfCliente
	 */
	public String getCpfCliente() {
		return cpfCliente;
	}

	/**
	 * @param cpfCliente the cpfCliente to set
	 */
	public void setCpfCliente(String cpfCliente) {
//		if(cpfCliente.length() == 11){
//		      //valido = false;
//			if (cpfCliente.substring(0,11).matches("[0-9]*")) {
		this.cpfCliente = cpfCliente;
//			}
//		}
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}


	@Override
	public String toString() {
		return "ClientePessoaFisica ["
				+ "getIdCliente()=" + getIdCliente() 
				+ ", getNomeCliente()=" + getNomeCliente()
				+ ", cpfCliente=" + cpfCliente 
				+ ", dataNasc=" + dataNasc 
				+ ", getFoneCliente1()=" + getFoneCliente1()
				+ ", getFoneCliente2()=" + getFoneCliente2() 
				+ ", getEmailCliente()=" + getEmailCliente() 
				+ ", getEnderecoCliente()=" + getEnderecoCliente()
				+ "]";
	}

	
}
