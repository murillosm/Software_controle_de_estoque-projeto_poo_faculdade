package model.entities;

public class Usuario {

	private int idUsuario;
	private String nomeUser;
	private String senha;
	private String loginUser;

//////////////////construtor\\\\\\\\\\\\\\\\\\\\\\\

	public Usuario() {
	}

	public Usuario(String loginUser, String senha) {
		super();
		this.senha = senha;
		this.loginUser = loginUser;
	}

	public Usuario(int idUsuario, String loginUser, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.senha = senha;
		this.loginUser = loginUser;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
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
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ID: " + idUsuario + " * Nome: " + nomeUser;
	}

}
