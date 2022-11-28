package Controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.helpers.LoginHelper;
import db.DB;
import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;
import view.Login;
import view.MenuPrincipal;

public class LoginController {
	
	private final Login view;
	private LoginHelper helper;
	private Connection conn;

	public LoginController(Login view) {
		this.view = view;
		this.helper = new LoginHelper(view);
	}
	public void entrarNoSistema() throws SQLException{
		//Pegar um usuario da View
		
		//Pesquisar Usuario no Banco
		Usuario usuario = helper.obterModelo();
		
		//Conferir se Usuario esta cadastrado no Banco 
		conn = new DB().getConnection();
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		boolean existe = usuarioDao.autenticarUsuarioSenha(usuario);
		
		//Senão mostras que "usuario e senha" e invalido
		if (existe == true) {
			MenuPrincipal menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
			if (menuPrincipal.isVisible()) {
				view.dispose();
			}
		}else {
			JOptionPane.showMessageDialog(view, "Usuario ou senha invalida");
		}
	}
	
	public void fizTarefa() {
		System.out.println("Busquei informação");
		
		this.view.exibeMensagem("Executei");
	}
}
