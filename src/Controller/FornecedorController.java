package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Controller.helpers.FornecedorHelper;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.dao.FornecedorDao;
import model.entities.ClientePessoaJuridico;
import model.entities.Fornecedor;
import view.CadastroFornecedorFrame;
import view.FornecedorViewJDialog;
import view.TipoPessoa;

public class FornecedorController {
	private final CadastroFornecedorFrame view;
	private final FornecedorHelper helper;

	

	public FornecedorController(CadastroFornecedorFrame view) {
		this.view = view;
		this.helper = new FornecedorHelper(view);
	}

	public void tipoCliente() {
		TipoPessoa tipo = new TipoPessoa();
		tipo.setLocationRelativeTo(null);
		tipo.setVisible(true);
	}

	public void atualizarFornecedor() {
		FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		ArrayList<Fornecedor> listFornecedor = (ArrayList<Fornecedor>) fornecedorDao.findAll();
		//Exibir lista de clientes 
		helper.preencherTabela(listFornecedor);
		//view.fireTableDataChanged();
	}
	
	public void pesquisarNomeForn() {
		FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		String nome = view.getTxtPesquisa().getText();
		ArrayList<Fornecedor> listFornecedor = (ArrayList<Fornecedor>) fornecedorDao.findByNome(nome);
		//DefaultTableModel tableModel = new DefaultTableModel(fornecedorDao.findByNome(view.getTxtPesquisa().getText()));
		//Exibir lista de clientes 
		helper.preencherTabela(listFornecedor);
		//view.fireTableDataChanged();
	}
	
	public void novoFornecedor() {
		FornecedorViewJDialog fornecedor = new FornecedorViewJDialog();
		fornecedor.setLocationRelativeTo(null);
		fornecedor.setVisible(true);
	}
}
