package Controller;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import view.CadastroClienteFrame;
import view.CadastroFornecedorFrame;
import view.MenuPrincipal;

public class MenuPrincipalController {
	private final MenuPrincipal viewMenuPrincipal;
	private static JDesktopPane desktopPane;

	public MenuPrincipalController(MenuPrincipal viewMenuPrincipal) {
		this.viewMenuPrincipal = viewMenuPrincipal;
	}
	
	public void CadastroCliente() {
		CadastroClienteFrame clientePane = new CadastroClienteFrame();
		desktopPane = MenuPrincipal.getDesktopPane();
		
		if (clientePane.isVisible()) {
			clientePane.toFront();
			clientePane.requestFocus();
			JOptionPane.showMessageDialog(null, "Cadastro de clientes\n já esta em uso", "AVISO",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				desktopPane.add(clientePane);
				desktopPane.moveToFront(clientePane);
				clientePane.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				clientePane.setLocation(0, 0);
				clientePane.setVisible(true);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void CadastroFornecedores() {
		CadastroFornecedorFrame fornecedorFrame = new CadastroFornecedorFrame();
		desktopPane = MenuPrincipal.getDesktopPane();
		
		if (fornecedorFrame.isVisible()) {
			fornecedorFrame.toFront();
			fornecedorFrame.requestFocus();
			JOptionPane.showMessageDialog(null, "Cadastro de clientes\n já esta em uso", "AVISO",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				desktopPane.add(fornecedorFrame);
				desktopPane.moveToFront(fornecedorFrame);
				fornecedorFrame.setSize(desktopPane.getWidth(), desktopPane.getHeight());
				fornecedorFrame.setLocation(0, 0);
				fornecedorFrame.setVisible(true);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
