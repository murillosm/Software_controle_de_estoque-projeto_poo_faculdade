package Controller;

import java.util.List;

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

	public CadastroFornecedorController(FornecedorViewJDialog view) {
		this.view = view;
		this.helper = new CadastroFornecedorHelper(view);
		this.frame = new CadastroFornecedorFrame();
	}

	public void novoFornecedor() {
		FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
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
		FornecedorController fornecedorController = new FornecedorController(frame);
		fornecedorController.atualizarFornecedor();
		view.dispose();
	}

	public void estado() {
		EstadoDao estadoDao = DaoFactory.createEstadoDao();
		List<Estados> estados = estadoDao.findAllEstados();
		helper.preencherEstado(estados);
	}

	public void cidades() {
		Estados estado = (Estados) view.getCbxEstado().getSelectedItem();
		CidadeDao cidadeDao = DaoFactory.createCidadeDao();
		view.getCbxCidade().removeAllItems();
		List<Cidades> cidades = cidadeDao.findAllCidades(estado.getIdEstado());
		// cidades.clear();
		helper.preencherCidades(cidades);

	}

}
