package estoque;

public class Usuario {

	private String nomeUser;
	private String senha;
	private String loginUser;
	private String cpfUser;
	private String cargoDoUser;
	private String emailUser;
	private String foneUser;
	private int codUsuario;
	private int dataNascDia, dataNascMes, dataNacsAno;
////////////////métodos\\\\\\\\\\\\\\\\\\\
	/*public void imprimir() {
		//this.setCpfUser(cpfUser);
		System.out.println(this.cpfUser);
	}*/
	public void cpf() {
	}
	public void login() {
		// Start of user code for method login
		// End of user code
	}

	public void cadastroCliente() {
		// Start of user code for method cadastroCliente
		// End of user code
	}

	public void registrarFornecedor() {
		// Start of user code for method registrarFornecedor
		// End of user code
	}

	public void fazerPedido() {
		// Start of user code for method fazerPedido
		// End of user code
	}

	public void efetuarVenda() {
		// Start of user code for method efetuarVenda
		// End of user code
	}

	public void registrarVenda() {
		// Start of user code for method registrarVenda
		// End of user code
	}
	
	public void registrarPedido() {
		// Start of user code for method registrarPedido
		// End of user code
	}
	public void historicoDeAtividaddes() {
		
	}
//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\
public Usuario(String cpfUser) {
	super();
	this.nomeUser = nomeUser;
	this.senha = senha;
	this.loginUser = loginUser;
	this.setCpfUser(cpfUser);
	this.cargoDoUser = cargoDoUser;
	this.emailUser = emailUser;
	this.foneUser = foneUser;
	this.codUsuario = codUsuario;
	this.dataNascDia = dataNascDia;
	this.dataNascMes = dataNascMes;
	this.dataNacsAno = dataNacsAno;
}
///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\
	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getCpfUser() {
		return cpfUser;
	}

	public void setCpfUser(String cpfUser) {
		if(cpfUser.length() == 11){
		      //valido = false;
			if (cpfUser.substring(0,11).matches("[0-9]*")) {
				this.cpfUser = cpfUser;
			}
		}

	}

	public String getCargoDoUser() {
		return cargoDoUser;
	}

	public void setCargoDoUser(String cargoDoUser) {
		this.cargoDoUser = cargoDoUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getFoneUser() {
		return foneUser;
	}

	public void setFoneUser(String foneUser) {
		this.foneUser = foneUser;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public int getDataNascDia() {
		return dataNascDia;
	}

	public void setDataNascDia(int dataNascDia) {
		this.dataNascDia = dataNascDia;
	}

	public int getDataNascMes() {
		return dataNascMes;
	}

	public void setDataNascMes(int dataNascMes) {
		this.dataNascMes = dataNascMes;
	}

	public int getDataNacsAno() {
		return dataNacsAno;
	}

	public void setDataNacsAno(int dataNacsAno) {
		this.dataNacsAno = dataNacsAno;
	}

}
