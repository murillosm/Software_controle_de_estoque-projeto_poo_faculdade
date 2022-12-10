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
	EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();
	
	public EstoqueController(EstoqueFrame view) {
		this.view = view;
		this.helper = new EstoqueHelper(view);
	}
	
	public void novoEstoque() {
		try {
			Estoque estoque;
			estoque = helper.obterModelo();
			estoqueDao.insert(estoque);
			preecherEstoque();
			helper.limparTela();
			JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Alguns campos estão vazios", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void editarEstoque() {
		try {
			Estoque estoque;
			estoque = helper.obterModelo();
			estoqueDao.update(estoque);
			preecherEstoque();
			helper.limparTela();
			JOptionPane.showMessageDialog(null, "Informações do produto alterado com sucesso!");
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o produto!", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void excluirEstoque() {
		Estoque estoque;
		estoque = helper.obterModelo();
		switch(JOptionPane.showConfirmDialog(null, "Deseja excluir este produto de ID:" + estoque.getIdItem() + " do Estoque?","Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
			case 0:
				try {
					estoqueDao.deleteById(estoque.getIdItem());
					preecherEstoque();
					helper.limparTela();
					JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
				} catch (RuntimeException e) {
					JOptionPane.showMessageDialog(null, "Erro ao deletar o produto!");
				}
			break;
			
			case 1:
				JOptionPane.showMessageDialog(null, "Nenhum Exclução foi feita.","AVISO.", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
	
	public void limparJText() {
		helper.limparTela();
	}
	
	public void preecherEstoque() {
		ArrayList<Estoque> listEstoques =  (ArrayList<Estoque>) estoqueDao.findAll(); 
		helper.preencherTabela(listEstoques);
	}
	
	public void boxFornecedor() {
		FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		ArrayList<Fornecedor> fornecedores = (ArrayList<Fornecedor>) fornecedorDao.findAll();
		helper.preencherFornecedor(fornecedores);
	}
	
	public void buscarItemNome() {
		try {
			Estoque model = estoqueDao.findByNome(view.getTxtPesquisa().getText());
			ArrayList<Estoque> listEstoques =  (ArrayList<Estoque>) estoqueDao.findAllNome(view.getTxtPesquisa().getText());
			helper.dadosJText(model);
			helper.preencherTabela(listEstoques);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void buscarItemID() {
		try {
			String idString = view.getTxtPesquisa().getText();
			int id = Integer.parseInt(idString);
			Estoque model = estoqueDao.findById(id);
			ArrayList<Estoque> listEstoques =  (ArrayList<Estoque>) estoqueDao.findAllId(id);
			helper.dadosJText(model);
			helper.preencherTabela(listEstoques);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void buscarItemMarca() {
		try {
			Estoque model = estoqueDao.findByMarca(view.getTxtPesquisa().getText());
			ArrayList<Estoque> listEstoques =  (ArrayList<Estoque>) estoqueDao.findAllMarca(view.getTxtPesquisa().getText());
			helper.dadosJText(model);
			helper.preencherTabela(listEstoques);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void buscarItemForn() {
		try {
			//Estoque model = estoqueDao.findByMarca(view.getTxtPesquisa().getText());
			ArrayList<Estoque> listEstoques =  (ArrayList<Estoque>) estoqueDao.findAllFornecedor(view.getTxtPesquisa().getText());
			helper.dadosJText(new Estoque());
			helper.preencherTabela(listEstoques);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	public void clickLinhaTabela() {
		try {
			String nomeItem =""+ view.getTbEstoque().getValueAt(view.getTbEstoque().getSelectedRow(), 0);
			int id = Integer.parseInt(nomeItem);
			Estoque estoque = estoqueDao.findById(id);
			helper.dadosJText(estoque);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao escolher linha tente novamente!");
		}
	}
	
	public void habilitar() {
		helper.habilitar();
	}
	public void desabilitar() {
		helper.desabilitar();
	}
}
