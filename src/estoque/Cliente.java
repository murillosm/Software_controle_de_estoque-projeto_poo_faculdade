package estoque;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

	private String foneCliente;
	private String emailCliente ;
	private Enderecos enderecoCliente;
	private Integer codCliente;
	//private int dataCadastraC;
	Date CadastraC = new Date();
	
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
				}else {
					System.out.println("Email invalido");
				}
            }
        }
        return isEmailIdValid;
    }
//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\
	public Cliente(String foneCliente, String emailCliente, Enderecos enderecoCliente, Integer codCliente) {
		super();
		this.foneCliente = foneCliente;
		this.emailCliente = emailCliente;
		this.enderecoCliente = enderecoCliente;
		this.codCliente = codCliente;
//		this.CadastraC = cadastraC;
	}

//////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\
	
	public String getFoneCliente() {
		return foneCliente;
	}

	public void setFoneCliente(String foneCliente) {
		this.foneCliente = foneCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Enderecos getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(Enderecos enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	
	/*
	public Date getCadastraC() {
		return CadastraC;
	}

	public void setCadastraC(Date cadastraC) {
		this.CadastraC = cadastraC;
	}*/
}
