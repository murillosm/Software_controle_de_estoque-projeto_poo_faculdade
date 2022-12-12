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
	
	@Override
	public void limparTela() {
		view.getTxtData().setText("");
		view.getTxtIDCliente().setText("");
		view.getTxtIDProduto().setText("");
		view.getTxtIDVenda().setText("");
		view.getTxtValorTotal().setText("");
		view.getTxtValorItem().setText("");
		view.getTxtQuatidade().setText("");
		view.getTxtPesquisaNome().setText("");
		view.getTxtPesquisaProduto().setText("");
	}
	
	public Estoque obterIDItems() {
		String idProdutoString = view.getTxtIDProduto().getText();
		int id = Integer.parseInt(idProdutoString);
		//Estoque estoque = 
		return new Estoque(id);
	}
	
	public Venda obterItems() {
		String idVendaString = view.getTxtIDVenda().getText();
		int idVenda = Integer.parseInt(idVendaString);

		//String idProdutoString = view.getTxtIDProduto().getText();
		Estoque idProduto = obterIDItems();

		String qString = view.getTxtQuatidade().getText();
		int qtd = Integer.parseInt(qString);
		
		Venda venda = new Venda(idVenda, idProduto, qtd);
		return venda;
	}
	
	
	@Override
	public Venda obterModelo() {
		
		String idVendaString = view.getTxtIDVenda().getText();
		int idVenda = Integer.parseInt(idVendaString);
		
		Usuario usuario = obterUsuario();
		
		String idString = view.getTxtIDCliente().getText();
		int idCliente = Integer.parseInt(idString);
		
		String valorString = view.getTxtValorTotal().getText();
		double valor = Double.parseDouble(valorString);
		
		String data = view.getTxtData().getText();
		
		Venda venda = new Venda(idVenda, usuario, idCliente, valor, data);
		return venda;
	}
	
	public Usuario obterUsuario() {
		return (Usuario) view.getCbxUsuario().getSelectedItem();
	}
	
	public void preencherUsuario(List<Usuario> usuarios) {
		DefaultComboBoxModel cbxUsuarioModel  = (DefaultComboBoxModel) view.getCbxUsuario().getModel();
		for (Usuario usuario: usuarios) {
			view.getCbxUsuario().addItem(usuario);
		}
	}
	
	public void preencherTabelaFisica(ArrayList<ClientePessoaFisica> listClientes) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbPesquisa().getModel();
		tableModel.setNumRows(0);

		for (ClientePessoaFisica cliente : listClientes) {
			tableModel.addRow(new Object[] {
					cliente.getIdCliente(),
					cliente.getNomeCliente(),
					cliente.getCpfCliente()});
		}
	}
	
	public void preencherTabelaJuridica(ArrayList<ClientePessoaJuridico> listClientes) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbPesquisa().getModel();
		tableModel.setNumRows(0);

		for (ClientePessoaJuridico cliente : listClientes) {
			tableModel.addRow(new Object[] {
					cliente.getIdCliente(),
					cliente.getNomeCliente(),
					cliente.getCnpjCliente()});
		}
	}
	
	public void preencherTabelaItens(ArrayList<Estoque> listEstoque) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbPesquisa().getModel();
		tableModel.setNumRows(0);

		for (Estoque estoque : listEstoque) {
			tableModel.addRow(new Object[] {
					estoque.getIdItem(),
					estoque.getNomeItem(),
					estoque.getMarcaItem(),
					estoque.getPrecoItem(),
					estoque.getQuantidade()});
		}
	}
	
	public void preencherItensList(ArrayList<Venda> listVendas) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbVenda().getModel();
		tableModel.setNumRows(0);

		for (Venda venda : listVendas) {
			tableModel.addRow(new Object[] {
					venda.getIdVenda(),
					venda.getProduto().getIdItem(),
					venda.getQtd(),
					venda.getProduto().getNomeItem()});
		}
	}

	
	public void tabelaCliente() {
		view.getTbPesquisa().setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome Clientes", "Documentos" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		view.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(0).setMinWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(0).setMaxWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(400);
		view.getTbPesquisa().getColumnModel().getColumn(1).setMinWidth(400);
		view.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);
		view.getTbPesquisa().getColumnModel().getColumn(2).setMinWidth(200);
	}
	
	public void tabelaProdutos() {
		view.getTbPesquisa().setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Item", "Preço", "Marca", "Quantidade" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		view.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(0).setMinWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(0).setMaxWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
		view.getTbPesquisa().getColumnModel().getColumn(1).setMinWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);
		view.getTbPesquisa().getColumnModel().getColumn(2).setMinWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(3).setPreferredWidth(200);
		view.getTbPesquisa().getColumnModel().getColumn(3).setMinWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(4).setPreferredWidth(100);
		view.getTbPesquisa().getColumnModel().getColumn(4).setMinWidth(100);
	}
	
}
