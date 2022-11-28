package model.entities;

public class Usuario {

	private int idUsuario;
	private String nomeUser;
	private String senha;
	private String loginUser;

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	public Usuario() {
	}

	public Usuario(int idUsuario, String nomeUser, String loginUser, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUser = nomeUser;
		this.senha = senha;
		this.loginUser = loginUser;
	}

	public Usuario(String nomeUser, String senha, String loginUser) {
		super();
		this.nomeUser = nomeUser;
		this.senha = senha;
		this.loginUser = loginUser;
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

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomeUser=" + nomeUser + ", senha=" + senha + ", loginUser="
				+ loginUser + "]";
	}


////////////////métodos\\\\\\\\\\\\\\\\\\\


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
