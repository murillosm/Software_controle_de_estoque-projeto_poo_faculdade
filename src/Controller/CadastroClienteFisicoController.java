package Controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Controller.helpers.CadastroClienteFisicoHelper;
import Controller.helpers.TabelaClienteFisicoHelper;
import model.dao.CidadeDao;
import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.dao.EstadoDao;
import model.entities.Cidades;
import model.entities.ClientePessoaFisica;
import model.entities.Estados;
import view.CadastroClienteFisicoJDialog;
import view.TabelaClientesF;

public class CadastroClienteFisicoController {
	private final CadastroClienteFisicoJDialog view;
	private final CadastroClienteFisicoHelper helper;

	public CadastroClienteFisicoController(CadastroClienteFisicoJDialog view) {
		this.view = view;
		this.helper = new CadastroClienteFisicoHelper(view);
	}
	
	public void novoCliente() {
			ClientePessoaFisicaDao clienteFisicoDao = DaoFactory.createPessoaFisicaDao();
			ClientePessoaFisica cliente = helper.obterModelo();
			try {
				boolean nome, cpf, dataNasc, fone, end, bairro;
				nome = view.getTxtNome().getText().equals("");
				cpf = view.getTxtCpf().getText().equals("");
				dataNasc = view.getTxtDataNasc().getText().equals("");
				fone = view.getTxtFone1().getText().equals("");
				end = view.getTxtEndereco().getText().equals("");
				bairro = view.getTxtBairro().getText().equals("");
				if (nome || cpf || dataNasc || fone || end || bairro) {
					JOptionPane.showMessageDialog(null, "Alguns campos então vazios \nCampos com (*) são obrigatórios","AVISO",JOptionPane.WARNING_MESSAGE);
				}
				else {
					clienteFisicoDao.insert(cliente);
					TabelaClienteFisicoController tabelaCliente = new TabelaClienteFisicoController(new TabelaClientesF());
					tabelaCliente.atualizarClienteF();
					helper.limparTela();
					view.dispose();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
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
		//cidades.clear();
		helper.preencherCidades(cidades);
		
	}

}
