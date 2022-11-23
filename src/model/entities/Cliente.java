package model.entities;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Cliente {

	private Integer idCliente;
	private String nomeCliente;
	private String foneCliente1;
	private String foneCliente2;
	private String emailCliente;
	private Endereco enderecoCliente;
	// private int dataCadastraC;
	// Date CadastraC = new Date();

//------------------------------------------------------------------------	
	public void pesquisarCliente() {

	}

	public void atualizarCliente() {

	}

	public boolean validarEmailClinte(String emailCliente) {
		boolean isEmailIdValid = false;
		if (emailCliente != null && emailCliente.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(emailCliente);
			if (matcher.matches()) {
				isEmailIdValid = true;
				if (isEmailIdValid == true) {
					System.out.println(this.getEmailCliente());
				} else {
					System.out.println("Email invalido");
				}
			}
		}
		return isEmailIdValid;
	}
//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	public Cliente(Integer idCliente, String nomeCliente, String foneCliente1, String foneCliente2, String emailCliente,
			Endereco enderecoCliente/* , Date cadastraC */) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.foneCliente1 = foneCliente1;
		this.foneCliente1 = foneCliente2;
		this.emailCliente = emailCliente;
		this.enderecoCliente = enderecoCliente;
		// CadastraC = cadastraC;
	}

	public Cliente() {
	}

	public Cliente(String nomeCliente, String foneCliente1, String foneCliente2, String emailCliente,
			Endereco enderecoCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.foneCliente1 = foneCliente1;
		this.foneCliente2 = foneCliente2;
		this.emailCliente = emailCliente;
		this.enderecoCliente = enderecoCliente;
	}

//////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getFoneCliente1() {
		return foneCliente1;
	}

	public void setFoneCliente1(String foneCliente1) {
		this.foneCliente1 = foneCliente1;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Endereco getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(Endereco enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getFoneCliente2() {
		return foneCliente2;
	}

	public void setFoneCliente2(String foneCliente2) {
		this.foneCliente2 = foneCliente2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailCliente == null) ? 0 : emailCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (emailCliente == null) {
			if (other.emailCliente != null)
				return false;
		} else if (!emailCliente.equals(other.emailCliente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", foneCliente1=" + foneCliente1
				+ ", foneCliente2=" + foneCliente2 + ", emailCliente=" + emailCliente + ", "
				+ enderecoCliente + "]";
	}


}
