package model.entities;

public class Usuario {

	private int idUsuario;
	private String nomeUser;
	private String senha;
	private String loginUser;
	private String cpfUser;
	private String emailUser;
	private int dataNascDia, dataNascMes, dataNacsAno;

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	public Usuario() {
	}

	public Usuario(String cpfUser) {
		this.setCpfUser(cpfUser);
	}

	public Usuario(int idUsuario, String nomeUser, String senha, String loginUser, String cpfUser, String emailUser, int dataNascDia, int dataNascMes, int dataNacsAno) {
		this.idUsuario = idUsuario;
		this.nomeUser = nomeUser;
		this.senha = senha;
		this.loginUser = loginUser;
		this.setCpfUser(cpfUser);
		this.emailUser = emailUser;
		this.dataNascDia = dataNascDia;
		this.dataNascMes = dataNascMes;
		this.dataNacsAno = dataNacsAno;
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

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
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

////////////////métodos\\\\\\\\\\\\\\\\\\\
	public void imprimir() {
		this.setCpfUser(cpfUser);
		//System.out.println(this.cpfUser);
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
