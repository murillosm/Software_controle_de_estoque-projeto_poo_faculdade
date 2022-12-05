package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Controller.helpers.CadastroClienteJuridicoHelper;
import model.dao.CidadeDao;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.dao.EstadoDao;
import model.entities.Cidades;
import model.entities.ClientePessoaJuridico;
import model.entities.Estados;
import view.CadastroClienteJuridicoJDialog;
import view.TabelaClientesJ;

public class CadastroClienteJuridicoController {
	private final CadastroClienteJuridicoJDialog view;
	private final CadastroClienteJuridicoHelper helper;

	public CadastroClienteJuridicoController(CadastroClienteJuridicoJDialog view) {
		this.view = view;
		this.helper = new CadastroClienteJuridicoHelper(view);
	}
	
	public void novoCliente() {
			ClientePessoaJuridoDao clienteJuridoDao = DaoFactory.createPessoaJuridicaDao();
			ClientePessoaJuridico cliente = helper.obterModelo();
			try {
				boolean nome, cnpj, fone, end, bairro;
				nome = view.getTxtNome().getText().equals("");
				cnpj = view.getTxtCnpj().getText().equals("");
				fone = view.getTxtFone1().getText().equals("");
				end = view.getTxtEndereco().getText().equals("");
				bairro = view.getTxtBairro().getText().equals("");
				if (nome || cnpj || fone || end || bairro) {
					JOptionPane.showMessageDialog(null, "Alguns campos então vazios \nCampos com (*) são obrigatórios","AVISO",JOptionPane.WARNING_MESSAGE);
				}
				else {
					clienteJuridoDao.insert(cliente);
					TabelaClienteJuridicoController tabelaCliente = new TabelaClienteJuridicoController(new TabelaClientesJ());
					tabelaCliente.atualizarClienteJ();
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
