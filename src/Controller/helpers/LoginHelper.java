package Controller.helpers;

import model.entities.Usuario;
import view.Login;

public class LoginHelper {

	private final Login view;

	public LoginHelper(Login view) {
		this.view = view;
	}
	
	public Usuario obterModelo() {
		String nomeUser = view.getTxtUsuario().getText();
		String senha = view.getTxtSenha().getText();
		Usuario modelUser = new Usuario(0, nomeUser, senha);
		
		return modelUser;
	}
	
	public void setModelUser(Usuario modelUser) {
		String nomeUser = modelUser.getLoginUser();
		String senha = modelUser.getSenha();
		
		view.getTxtUsuario().setText(nomeUser);
		view.getTxtSenha().setText(senha);
	}
	
	public void limparTela() {
		view.getTxtUsuario().setText("");
		view.getTxtSenha().setText("");
	}
}
