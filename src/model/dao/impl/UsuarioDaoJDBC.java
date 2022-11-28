package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {
	private Connection conn;
	PreparedStatement pst = null;

	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Usuario usuario) throws SQLException{
		String sql = "insert into usuario (nome_usuario,login,senha) values (?, ?, ?);";
		pst = conn.prepareStatement(sql);
		pst.setString(1, usuario.getNomeUser());
		pst.setString(2, usuario.getLoginUser());
		pst.setString(3, usuario.getSenha());
		pst.execute();
		JOptionPane.showInternalMessageDialog(null, "Sucesso Cadastro");
	}

	@Override
	public void update(Usuario obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Pesquisa um usuario pelo nome
	 */
	@Override
	public Usuario selectUsuario(String userName) throws SQLException {
		String sql = "select * from usuario where usuario like ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, userName);
		pst.execute();
		ResultSet rs = pst.getResultSet();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		if (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("id_usuario"));
			usuario.setNomeUser(rs.getString("usuario"));
			usuario.setLoginUser(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			Usuario usuarioDoBanco = new Usuario(usuario.getIdUsuario(), usuario.getNomeUser(), usuario.getLoginUser(), usuario.getSenha());
			usuarios.add(usuarioDoBanco);
		}
		return usuarios.get(0);
	}
	
	/*
	 * Procura usuario no banco e retorna se existe(true, false)
	 */
	@Override
	public Boolean autenticarUsuarioSenha(Usuario usuario) throws SQLException {
		String sql = "select * from usuario where login = ? and senha = ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, usuario.getLoginUser());
		pst.setString(2, usuario.getSenha());
		pst.execute();
		ResultSet resultado = pst.getResultSet();

		return resultado.next();
	}

	@Override
	public List<Usuario> findAll() throws SQLException{
		String sql = "select * from usuario";
		pst = conn.prepareStatement(sql);
		pst.execute();
		ResultSet rs = pst.getResultSet();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("id_usuario"));
			usuario.setNomeUser(rs.getString("usuario"));
			usuario.setLoginUser(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			Usuario usuarioDoBanco = new Usuario(usuario.getIdUsuario(), usuario.getNomeUser(), usuario.getLoginUser(), usuario.getSenha());
			usuarios.add(usuarioDoBanco);
		}
		return usuarios;
	}

}
