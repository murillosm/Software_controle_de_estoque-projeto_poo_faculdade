package Controller;

import view.CadastroFornecedorFrame;
import view.FornecedorViewJDialog;
import view.TipoPessoa;

public class FornecedorController {
	private final CadastroFornecedorFrame viewFornecedor;

	

	public FornecedorController(CadastroFornecedorFrame viewFornecedor) {
		this.viewFornecedor = viewFornecedor;
	}

	public void tipoCliente() {
		TipoPessoa tipo = new TipoPessoa();
		tipo.setLocationRelativeTo(null);
		tipo.setVisible(true);
	}

	public void pesclisar() {

	}
	
	public void novoFornecedor() {
		FornecedorViewJDialog fornecedor = new FornecedorViewJDialog();
		
		fornecedor.setLocationRelativeTo(null);
		fornecedor.setVisible(true);
	}
	
//	public void visualizarFornecedores() {
//		desktopPaneClientes = viewCliente.getDesktopPaneClientes();
//		if (clienteF.isVisible()) {
//			clienteF.toFront();
//			clienteF.requestFocus();
//			// JOptionPane.showMessageDialog(null, "Pessoa Fisica\n já esta em
//			// uso","AVISO",JOptionPane.WARNING_MESSAGE);
//		} else {
//			try {
//				if (clienteJ.isVisible())
//					clienteJ.dispose();
//				
//				desktopPaneClientes.add(clienteF);
//				desktopPaneClientes.moveToFront(clienteF);
//				clienteF.setSize(desktopPaneClientes.getWidth(), desktopPaneClientes.getHeight());
//				clienteF.setLocation(0, 0);
//				clienteF.setVisible(true);
//				TabelaClienteFisicoController tabelaCliente = new TabelaClienteFisicoController(new TabelaClientesF());
//				tabelaCliente.atualizarClienteF();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//
//		}
//	}
}
