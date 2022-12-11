package Controller.helpers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.entities.Cliente;
import model.entities.ClientePessoaFisica;
import model.entities.ClientePessoaJuridico;
import model.entities.Estoque;
import model.entities.Fornecedor;
import model.entities.Usuario;
import model.entities.Venda;
import view.VendasFrame;

public class VendasHelper implements Helper{
	private final VendasFrame view;

	public VendasHelper(VendasFrame view) {
		this.view = view;
	}
	
	public void preencherTabelaFisica(ArrayList<ClientePessoaFisica> listClientes) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbPesquisaCliente().getModel();
		tableModel.setNumRows(0);

		for (ClientePessoaFisica cliente : listClientes) {
			tableModel.addRow(new Object[] {
					cliente.getIdCliente(),
					cliente.getNomeCliente(),
					cliente.getCpfCliente()});
		}
	}
	
	public void preencherTabelaJuridica(ArrayList<ClientePessoaJuridico> listClientes) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbPesquisaCliente().getModel();
		tableModel.setNumRows(0);

		for (ClientePessoaJuridico cliente : listClientes) {
			tableModel.addRow(new Object[] {
					cliente.getIdCliente(),
					cliente.getNomeCliente(),
					cliente.getCnpjCliente()});
		}
	}
	
	public void preencherUsuario(List<Usuario> usuarios) {
		DefaultComboBoxModel cbxUsuarioModel  = (DefaultComboBoxModel) view.getCbxUsuario().getModel();
		for (Usuario usuario: usuarios) {
			view.getCbxUsuario().addItem(usuario);
		}
	}

	@Override
	public Object obterModelo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limparTela() {
		// TODO Auto-generated method stub
		
	}
	
	
}
