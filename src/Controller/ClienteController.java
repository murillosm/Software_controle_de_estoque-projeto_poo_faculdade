package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

import Controller.helpers.TabelaClienteFisicoHelper;
import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.entities.ClientePessoaFisica;
import view.CadastroClienteFisicoJDialog;
import view.CadastroClienteFrame;
import view.TabelaClientesF;
import view.TabelaClientesJ;
import view.TipoPessoa;

public class ClienteController {
	private final CadastroClienteFrame viewCliente;
	private final TipoPessoa viewTipoPessoa;
	private static JDesktopPane desktopPaneClientes;
	private static JComboBox cbxTipoCliente;
	private static TabelaClientesF clienteF = new TabelaClientesF();
	private static TabelaClientesJ clienteJ = new TabelaClientesJ();

	

	public ClienteController(CadastroClienteFrame viewCliente) {
		this.viewCliente = viewCliente;
		this.viewTipoPessoa = new TipoPessoa();

	}

	public void tipoCliente() {
		TipoPessoa tipo = new TipoPessoa();
		tipo.setLocationRelativeTo(null);
		tipo.setVisible(true);
	}

	public void pesquisar() {

	}
	
	public void visualizarClientesFisico() {
		desktopPaneClientes = viewCliente.getDesktopPaneClientes();
		if (clienteF.isVisible()) {
			clienteF.toFront();
			clienteF.requestFocus();
			// JOptionPane.showMessageDialog(null, "Pessoa Fisica\n já esta em
			// uso","AVISO",JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				if (clienteJ.isVisible())
					clienteJ.dispose();
				
				desktopPaneClientes.add(clienteF);
				desktopPaneClientes.moveToFront(clienteF);
				clienteF.setSize(desktopPaneClientes.getWidth(), desktopPaneClientes.getHeight());
				clienteF.setLocation(0, 0);
				clienteF.setVisible(true);
				TabelaClienteFisicoController tabelaCliente = new TabelaClienteFisicoController(new TabelaClientesF());
				tabelaCliente.atualizarClienteF();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	public void visualizarClientesJuridico() {
		desktopPaneClientes = viewCliente.getDesktopPaneClientes();
		// cbxTipoCliente = viewCliente.getCbxTipoPesquisa();
		if (clienteJ.isVisible()) {
			clienteJ.toFront();
			clienteJ.requestFocus();
			// JOptionPane.showMessageDialog(null, "Pessoa Fisica\n já esta em
			// uso","AVISO",JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				if (clienteF.isVisible())
					clienteF.dispose();
				
				desktopPaneClientes.add(clienteJ);
				desktopPaneClientes.moveToFront(clienteJ);
				clienteJ.setSize(desktopPaneClientes.getWidth(), desktopPaneClientes.getHeight());
				clienteJ.setLocation(0, 0);
				clienteJ.setVisible(true);
			} catch (Exception e3) {
				e3.printStackTrace();
			}

		}

	}
	
	public void escolherTipo() {
		desktopPaneClientes = viewCliente.getDesktopPaneClientes();
		try {
			if (clienteF.isVisible())
				clienteF.dispose();
			if (clienteJ.isVisible())
				clienteJ.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
