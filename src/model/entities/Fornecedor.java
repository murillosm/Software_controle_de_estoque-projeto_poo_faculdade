package model.entities;

import java.util.Date;

public class Fornecedor {
	
	private String razaoSocialFornecedor;
	private String cnpjFornecedor;
	private String foneFornecedo;
	private String foneFornecedo2;
	private String emailFornecedor;
	private String site;
	private int codFornecedor;
	private Enderecos enderecoFornecedor;
	Date dataCadastraF = new Date();
////////////////////metodos\\\\\\\\\\\\\\\\\\\\\\	
	public void consutarFornecedor() {
		// Start of user code for method consutarFornecedor
		// End of user code
	}
	
	public void atualizarFornecedor() {
		// Start of user code for method atualizarFornecedor
		// End of user code
	}
///////////////////construtor\\\\\\\\\\\\\\\\\\\\\\
	public Fornecedor(String razaoSocialFornecedor, String cnpjFornecedor, String foneFornecedo, String emailFornecedor,
			String site, int codFornecedor, String foneFornecedo2, Enderecos enderecoFornecedor) {
		super();
		this.razaoSocialFornecedor = razaoSocialFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.foneFornecedo = foneFornecedo;
		this.emailFornecedor = emailFornecedor;
		this.site = site;
		this.codFornecedor = codFornecedor;
		this.foneFornecedo2 = foneFornecedo2;
		this.enderecoFornecedor = enderecoFornecedor;
		//this.dataCadastraF = dataCadastraF;
	}
///////////////////set e get\\\\\\\\\\\\\\\\\\\\\\	
	
	public String getRazaoSocialFornecedor() {
		return razaoSocialFornecedor;
	}

	public void setRazaoSocialFornecedor(String razaoSocialFornecedor) {
		this.razaoSocialFornecedor = razaoSocialFornecedor;
	}

	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}

	public void setCnpjFornecedor(String cnpjFornecedor) {
		if(cnpjFornecedor.length() == 14){
		      //valido = false;
			if (cnpjFornecedor.substring(0,14).matches("[0-9]*")) {
				this.cnpjFornecedor = cnpjFornecedor;
			}
		}
		
	}

	public String getFoneFornecedo() {
		return foneFornecedo;
	}

	public void setFoneFornecedo(String foneFornecedo) {
		this.foneFornecedo = foneFornecedo;
	}

	public String getEmailFornecedor() {
		return emailFornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public int getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(int codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public String getFoneFornecedo2() {
		return foneFornecedo2;
	}

	public void setFoneFornecedo2(String foneFornecedo2) {
		this.foneFornecedo2 = foneFornecedo2;
	}

	public Enderecos getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(Enderecos enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

/*	public Date getDataCadastraF() {
		return dataCadastraF;
	}

	public void setDataCadastraF(Date dataCadastraF) {
		this.dataCadastraF = dataCadastraF;
	}*/

}
