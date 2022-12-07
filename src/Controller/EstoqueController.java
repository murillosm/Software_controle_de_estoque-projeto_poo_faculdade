package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.helpers.EstoqueHelper;
import model.dao.DaoFactory;
import model.dao.EstoqueDao;
import model.dao.FornecedorDao;
import model.dao.impl.FornecedorDaoJDBC;
import model.entities.Estoque;
import model.entities.Fornecedor;
import view.EstoqueFrame;

public class EstoqueController {
	private final EstoqueFrame view;
	private final EstoqueHelper helper;
	
	public EstoqueController(EstoqueFrame view) {
		this.view = view;
		this.helper = new EstoqueHelper(view);
	}
	
	EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();
	public void novoEstoque() {
		try {
			Estoque estoque;
			estoque = helper.obterModelo();
			estoqueDao.insert(estoque);
			atualizarEstoque();
			helper.limparTela();
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Alguns campos estão vazios", null, JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void atualizarEstoque() {
		ArrayList<Estoque> listEstoques =  (ArrayList<Estoque>) estoqueDao.findAll();
		//Exibir lista de clientes 
		helper.preencherTabela(listEstoques);
		//view.fireTableDataChanged();
	}

	public void boxFornecedor() {
		FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		ArrayList<Fornecedor> fornecedores = (ArrayList<Fornecedor>) fornecedorDao.findAll();
		helper.preencherFornecedor(fornecedores);
	}
}
