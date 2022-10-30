package model.entities;

import java.util.Date;

public class ClientePessoaFisica extends Cliente {

	private String nomeClienteFisica ;

	private String cpfCliente;

	private String sobrenomeCliente;

	private int dataNascDiaC, dataNascMesC, dataNacsAnoC;

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\
	public ClientePessoaFisica(String foneCliente, String emailCliente, Enderecos enderecoCliente, int codCliente,
			Date cadastraC, String nomeClienteFisica, String cpfCliente, String sobrenomeCliente, int dataNascDiaC,
			int dataNascMesC, int dataNacsAnoC) {
		super(foneCliente, emailCliente, enderecoCliente, codCliente);
		this.nomeClienteFisica = nomeClienteFisica;
		this.setCpfCliente(cpfCliente);
		this.sobrenomeCliente = sobrenomeCliente;
		this.dataNascDiaC = dataNascDiaC;
		this.dataNascMesC = dataNascMesC;
		this.dataNacsAnoC = dataNacsAnoC;
	}
	
///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * @return the nomeClienteFisica
	 */
	public String getNomeClienteFisica() {
		return nomeClienteFisica;
	}

	/**
	 * @param nomeClienteFisica the nomeClienteFisica to set
	 */
	public void setNomeClienteFisica(String nomeClienteFisica) {
		this.nomeClienteFisica = nomeClienteFisica;
	}

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
		if(cpfCliente.length() == 11){
		      //valido = false;
			if (cpfCliente.substring(0,11).matches("[0-9]*")) {
				this.cpfCliente = cpfCliente;
			}
		}
	}

	/**
	 * @return the sobrenomeCliente
	 */
	public String getSobrenomeCliente() {
		return sobrenomeCliente;
	}

	/**
	 * @param sobrenomeCliente the sobrenomeCliente to set
	 */
	public void setSobrenomeCliente(String sobrenomeCliente) {
		this.sobrenomeCliente = sobrenomeCliente;
	}

	public int getDataNascDiaC() {
		return dataNascDiaC;
	}

	public void setDataNascDiaC(int dataNascDiaC) {
		this.dataNascDiaC = dataNascDiaC;
	}

	public int getDataNascMesC() {
		return dataNascMesC;
	}

	public void setDataNascMesC(int dataNascMesC) {
		this.dataNascMesC = dataNascMesC;
	}

	public int getDataNacsAnoC() {
		return dataNacsAnoC;
	}

	public void setDataNacsAnoC(int dataNacsAnoC) {
		this.dataNacsAnoC = dataNacsAnoC;
	}

}
