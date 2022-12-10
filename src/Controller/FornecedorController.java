package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.helpers.FornecedorHelper;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.dao.FornecedorDao;
import model.entities.ClientePessoaJuridico;
import model.entities.Estoque;
import model.entities.Fornecedor;
import view.CadastroFornecedorFrame;
import view.FornecedorViewJDialog;
import view.TipoPessoa;

public class FornecedorController {
	private final CadastroFornecedorFrame view;
	private final FornecedorHelper helper;
	CadastroFornecedorController cadastroFornController;
	FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
	

	

	public FornecedorController(CadastroFornecedorFrame view) {
		this.view = view;
		this.helper = new FornecedorHelper(view);
		//this.cadastroFornController = new CadastroFornecedorController(new FornecedorViewJDialog());
	}

	public void preencherFornecedor() {
		ArrayList<Fornecedor> listFornecedor = (ArrayList<Fornecedor>) fornecedorDao.findAll();
		helper.preencherTabela(listFornecedor);
	}
	
	public void buscarNome() {
		try {
			ArrayList<Fornecedor> list =   (ArrayList<Fornecedor>) fornecedorDao.findAllNome(view.getTxtPesquisa().getText());
			helper.preencherTabela(list);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O Fornecedor buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void buscarID() {
		try {
			String idString = view.getTxtPesquisa().getText();
			int id = Integer.parseInt(idString);
			ArrayList<Fornecedor> list =   (ArrayList<Fornecedor>) fornecedorDao.findAllID(id);
			helper.preencherTabela(list);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O Fornecedor buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void buscarCnpj() {
		try {
			ArrayList<Fornecedor> list =   (ArrayList<Fornecedor>) fornecedorDao.findAllCnpj(view.getTxtPesquisa().getText());
			helper.preencherTabela(list);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O Fornecedor buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void novoFornecedor() {
		FornecedorViewJDialog fornecedor = new FornecedorViewJDialog();
		fornecedor.setLocationRelativeTo(null);
		fornecedor.setVisible(true);
	}
	
	public void clickLinhaTabela() {
		try {
			String idString =""+ view.getTbFornecedor().getValueAt(view.getTbFornecedor().getSelectedRow(), 0);
			int id = Integer.parseInt(idString);
			Fornecedor fornecedor = fornecedorDao.findById(id);
			view.getTxtID().setText(String.valueOf(fornecedor.getIdFornecedor()));
			//helper.dadosJText(fornecedor);
			//visualizar();
			//return id;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao escolher linha tente novamente!");
		}
		//return null;
	}
	
//	public void visualizar() {
//		//int id = clickLinhaTabela();
//		FornecedorViewJDialog fornecedor = new FornecedorViewJDialog();
//		fornecedor.setLocationRelativeTo(null);
//		fornecedor.setVisible(true);
//		//cadastroFornController.desabilitar();
//		//cadastroFornController.visualizarFornecedor(id);
//		//return clickLinhaTabela();
//	}
	
	public void excluirFornecedor() {
		String idString = view.getTxtID().getText();
		int id = Integer.parseInt(idString);
		switch(JOptionPane.showConfirmDialog(null, "Deseja excluir este Forncedor de ID:" + id + " do Estoque?","Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
			case 0:
				try {
					//int id = clickLinhaTabela();
					fornecedorDao.deleteById(id);
					preencherFornecedor();
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
}
