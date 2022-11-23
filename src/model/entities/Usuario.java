package model.entities;

public class Usuario {

	private int idUsuario;
	private String nomeUser;
	private String senha;
	private String loginUser;
	private String cpf;

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	public Usuario() {
	}

	public Usuario(int idUsuario, String nomeUser, String senha, String loginUser, String cpf) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUser = nomeUser;
		this.senha = senha;
		this.loginUser = loginUser;
		this.cpf = cpf;
	}

	public Usuario(String nomeUser, String senha, String loginUser, String cpf) {
		super();
		this.nomeUser = nomeUser;
		this.senha = senha;
		this.loginUser = loginUser;
		this.cpf = cpf;
	}

///////////////////get e set\\\\\\\\\\\\\\\\\\\\\\\
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		//if (cpfUser.length() == 11) {
			// valido = false;
		//	if (cpfUser.substring(0, 11).matches("[0-9]*")) {
				this.cpf = cpf;
		//	}
		//}

	}
	
	


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomeUser=" + nomeUser + ", senha=" + senha + ", loginUser="
				+ loginUser + ", cpf=" + cpf + "]";
	}


////////////////métodos\\\\\\\\\\\\\\\\\\\
	public void imprimir() {
		this.setCpf(cpf);
		// System.out.println(this.cpfUser);
	}

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
}
