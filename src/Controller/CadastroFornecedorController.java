package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Controller.helpers.CadastroClienteJuridicoHelper;
import Controller.helpers.CadastroFornecedorHelper;
import model.dao.CidadeDao;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.dao.EstadoDao;
import model.dao.FornecedorDao;
import model.entities.Cidades;
import model.entities.ClientePessoaJuridico;
import model.entities.Estados;
import model.entities.Estoque;
import model.entities.Fornecedor;
import view.CadastroClienteJuridicoJDialog;
import view.CadastroFornecedorFrame;
import view.FornecedorViewJDialog;
import view.MenuPrincipal;
import view.TabelaClientesJ;

public class CadastroFornecedorController {
	private final FornecedorViewJDialog view;
	private final CadastroFornecedorHelper helper;
	private final CadastroFornecedorFrame frame;
	private final FornecedorController fornController;
	Fornecedor fornecedor;
	FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();

	public CadastroFornecedorController(FornecedorViewJDialog view) {
		this.view = view;
		this.helper = new CadastroFornecedorHelper(view);
		this.frame = new CadastroFornecedorFrame();
		this.fornController = new FornecedorController(frame);
	}

	public void novoFornecedor() {
		Fornecedor fornecedor;
		fornecedor = helper.obterModelo();
//				boolean nome, cnpj, fone, end, bairro;
//				nome = view.getTxtNome().getText().equals("");
//				cnpj = view.getTxtCnpj().getText().equals("");
//				fone = view.getTxtFone1().getText().equals("");
//				end = view.getTxtEndereco().getText().equals("");
//				bairro = view.getTxtBairro().getText().equals("");
//				if (nome || cnpj || fone || end || bairro) {
//					JOptionPane.showMessageDialog(null, "Alguns campos então vazios \nCampos com (*) são obrigatórios","AVISO",JOptionPane.WARNING_MESSAGE);
//				}
//				else {
		fornecedorDao.insert(fornecedor);
		helper.limparTela();
		//FornecedorController fornecedorController = new FornecedorController(frame);
		//fornecedorController.preencherFornecedor();
		//view.dispose();
	}
	
	public void atualizarFornecedor() {
//		try {
			fornecedor = helper.obterModelo();
			String idString = view.getTxtIdPesquisa().getText();
			int id = Integer.parseInt(idString);
			fornecedorDao.update(fornecedor);
			helper.limparTela();
			//FornecedorController fornecedorController = new FornecedorController(frame);
			//fornecedorController.preencherFornecedor();
			//view.dispose();
			JOptionPane.showMessageDialog(null, "Informações do Fornecedor alterado com sucesso!");
//		} catch (RuntimeException e) {
//			JOptionPane.showMessageDialog(null, "Erro ao alterar o Fornecedor!", null, JOptionPane.ERROR_MESSAGE);
//		}
	}
	

	public void limpar() {
		helper.limparTela();
	}
	
	public void estado() {
		EstadoDao estadoDao = DaoFactory.createEstadoDao();
		List<Estados> estados = estadoDao.findAllEstados();
		//helper.preencherEstado(estados);
		//DefaultComboBoxModel cbxEstadoModel = (DefaultComboBoxModel) view.getCbxEstado().getModel();
		for (Estados estado : estados) {
			view.getCbxEstado().addItem(estado);
		}
	}
	
	public void visualizarFornecedor() {
		try {
			String idString = view.getTxtIdPesquisa().getText();
			int id = Integer.parseInt(idString);
			Fornecedor model = fornecedorDao.findById(id);
			//ArrayList<Estoque> listEstoques =  (ArrayList<Estoque>) estoqueDao.findAllNome(view.getTxtPesquisa().getText());
			helper.dadosJText(model);
			//helper.preencherTabela(listEstoques);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}

	public void cidades() {
		Estados estado = (Estados) view.getCbxEstado().getSelectedItem();
		CidadeDao cidadeDao = DaoFactory.createCidadeDao();
		view.getCbxCidade().removeAllItems();
		List<Cidades> cidades = cidadeDao.findAllCidades(estado.getIdEstado());
		// cidades.clear();
		helper.preencherCidades(cidades);

	}
	
	public void desabilitar() {
		helper.desabilitar();
	}
	
	public void habilitar() {
		helper.habilitar();
	}

}
