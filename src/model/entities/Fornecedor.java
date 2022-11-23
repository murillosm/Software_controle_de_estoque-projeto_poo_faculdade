package model.entities;

public class Fornecedor {

	private int idFornecedor;

	private String nomeFantasia;
	private String razaoSocialFornecedor;
	private String cnpjFornecedor;
	private String emailFornecedor;
	private Endereco enderecoFornecedor;
	private String foneFornecedo;
	private String foneFornecedo2;

	//private Date dataCadastraF;

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
	public Fornecedor() {
	}

	public Fornecedor(int idFornecedor, String nomeFantasia, String razaoSocialFornecedor, String cnpjFornecedor,
					  String emailFornecedor, Endereco enderecoFornecedor,
					  String foneFornecedo, String foneFornecedo2/*, Date dataCadastraF*/) {
		this.idFornecedor = idFornecedor;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocialFornecedor = razaoSocialFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.emailFornecedor = emailFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
		this.foneFornecedo = foneFornecedo;
		this.foneFornecedo2 = foneFornecedo2;
		//this.dataCadastraF = dataCadastraF;
	}
///////////////////set e get\\\\\\\\\\\\\\\\\\\\\\

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

	public String getFoneFornecedo2() {
		return foneFornecedo2;
	}

	public void setFoneFornecedo2(String foneFornecedo2) {
		this.foneFornecedo2 = foneFornecedo2;
	}

	public Endereco getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(Endereco enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

	/*public Date getDataCadastraF() {
		return dataCadastraF;
	}

	public void setDataCadastraF(Date dataCadastraF) {
		this.dataCadastraF = dataCadastraF;
	}*/

}
