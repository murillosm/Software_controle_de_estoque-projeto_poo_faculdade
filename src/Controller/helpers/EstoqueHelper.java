package Controller.helpers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.dao.DaoFactory;
import model.dao.FornecedorDao;
import model.entities.Cidades;
import model.entities.Endereco;
import model.entities.Estados;
import model.entities.Estoque;
import model.entities.Fornecedor;
import view.EstoqueFrame;

public class EstoqueHelper implements Helper{
	private final EstoqueFrame view;
	
	

	public EstoqueHelper(EstoqueFrame view) {
		this.view = view;
	}
	
	public void preencherTabela(ArrayList<Estoque> listEstoque) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbEstoque().getModel();
		tableModel.setNumRows(0);

		// percorrer lista
		//FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		for (Estoque estoque : listEstoque) {
			tableModel.addRow(new Object[] {
					estoque.getIdItem(),
					estoque.getQuantidade(),
					estoque.getNomeItem(),
					estoque.getMarcaItem(),
					estoque.getDescricaoItem(),
					estoque.getPrecoItem(),
					estoque.getForn().getIdFornecedor()});
		}
	}

	@Override
	public void limparTela() {
		//view.getTxtId().setText("");
		view.getTxtNomeItem().setText("");
		view.getTxtMarca().setText("");
		view.getTxtDescricao().setText("");
		view.getTxtValor().setText("");
		view.getTxtQtd().setText("");
	}
	
	@Override
	public Estoque obterModelo(){
		String idString = view.getTxtId().getText();
		int id = Integer.parseInt(idString);
		String nomeItem = view.getTxtNomeItem().getText();
		String marca = view.getTxtMarca().getText();
		String descricao = view.getTxtDescricao().getText();
		String valorString = view.getTxtValor().getText();
		double valor = Double.parseDouble(valorString);
		String qtdString = view.getTxtQtd().getText();
		int qtd = Integer.parseInt(qtdString);
		Fornecedor fornecedor = obterFornecedor();
		
		//ClientePessoaFisica pf = new ClientePessoaFisica(cpf, true);
		Estoque estoque = new Estoque(id, valor, qtd, nomeItem, marca, descricao, fornecedor);
		return estoque;
	}


	
	public void preencherFornecedor(List<Fornecedor> fornecedores) {
		DefaultComboBoxModel cbxFornecedorModel  = (DefaultComboBoxModel) view.getCbxFornecedor().getModel();
		for (Fornecedor fornecedor: fornecedores) {
			view.getCbxFornecedor().addItem(fornecedor);
		}
	}
	
	public Fornecedor obterFornecedor() {
		return (Fornecedor) view.getCbxFornecedor().getSelectedItem();
	}

}
