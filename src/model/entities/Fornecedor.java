package model.entities;

public class Fornecedor {

	private int idFornecedor;

	private String nomeFornecedor;
	private String cnpjFornecedor;
	private String razaoSocialFornecedor;
	private String foneFornecedo1;
	private String foneFornecedo2;
	private String emailFornecedor;
	private Endereco enderecoFornecedor;
	
///////////////////construtor\\\\\\\\\\\\\\\\\\\\\\
	public Fornecedor() {
	}

	public Fornecedor(String nomeFornecedor, String cnpjFornecedor, String razaoSocialFornecedor, String foneFornecedo1,
			String foneFornecedo2, String emailFornecedor, Endereco enderecoFornecedor) {
		super();
		this.nomeFornecedor = nomeFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.razaoSocialFornecedor = razaoSocialFornecedor;
		this.foneFornecedo1 = foneFornecedo1;
		this.foneFornecedo2 = foneFornecedo2;
		this.emailFornecedor = emailFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
	}

	public Fornecedor(int idFornecedor, String nomeFornecedor, String cnpjFornecedor, String razaoSocialFornecedor,
			String foneFornecedo1, String foneFornecedo2, String emailFornecedor, Endereco enderecoFornecedor) {
		super();
		this.idFornecedor = idFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.razaoSocialFornecedor = razaoSocialFornecedor;
		this.foneFornecedo1 = foneFornecedo1;
		this.foneFornecedo2 = foneFornecedo2;
		this.emailFornecedor = emailFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
	}

///////////////////set e get\\\\\\\\\\\\\\\\\\\\\\

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
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
		//if(cnpjFornecedor.length() == 14){
		      //valido = false;
			//if (cnpjFornecedor.substring(0,14).matches("[0-9]*")) {
				this.cnpjFornecedor = cnpjFornecedor;
			//}
		//}
		
	}

	public String getFoneFornecedo1() {
		return foneFornecedo1;
	}

	public void setFoneFornecedo1(String foneFornecedo1) {
		this.foneFornecedo1 = foneFornecedo1;
	}

	public String getFoneFornecedo2() {
		return foneFornecedo2;
	}

	public void setFoneFornecedo2(String foneFornecedo2) {
		this.foneFornecedo2 = foneFornecedo2;
	}
	
	public String getEmailFornecedor() {
		return emailFornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	public Endereco getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(Endereco enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", nomeFornecedor=" + nomeFornecedor
				+ ", razaoSocialFornecedor=" + razaoSocialFornecedor + ", cnpjFornecedor=" + cnpjFornecedor
				+ ", emailFornecedor=" + emailFornecedor + ", enderecoFornecedor=" + enderecoFornecedor
				+ ", foneFornecedo1=" + foneFornecedo1 + ", foneFornecedo2=" + foneFornecedo2 + "]";
	}

}
