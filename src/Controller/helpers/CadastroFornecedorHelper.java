package Controller.helpers;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.entities.Cidades;
import model.entities.ClientePessoaFisica;
import model.entities.ClientePessoaJuridico;
import model.entities.Endereco;
import model.entities.Estados;
import model.entities.Fornecedor;
import view.CadastroClienteFisicoJDialog;
import view.CadastroClienteJuridicoJDialog;
import view.FornecedorViewJDialog;
import view.TabelaClientesF;

public class CadastroFornecedorHelper implements Helper{
	private final FornecedorViewJDialog view;
	//private final TabelaClientesF tabelaClientesF;

	public CadastroFornecedorHelper(FornecedorViewJDialog view) {
		this.view = view;
		//this.tabelaClientesF = new TabelaClientesF();
	}
	@Override
	public void limparTela() {
		//view.getTxtIdCliente().setText("");
		view.getTxtNome().setText("");
		view.getTxtCnpj().setText("");
		view.getTxtRazao().setText("");
		view.getTxtFone1().setText("");
		view.getTxtFone2().setText("");
		view.getTxtEmail().setText("");
		view.getTxtEndereco().setText("");
		view.getTxtNumero().setText("");
		view.getTxtCep().setText("");
		view.getTxtBairro().setText("");
	}
	
	@Override
	public Fornecedor obterModelo(){
		String idString = view.getTxtIdFornecedor().getText();
		int id = Integer.parseInt(idString);
		String nome = view.getTxtNome().getText();
		String cnpj = view.getTxtCnpj().getText();
		String razaoSocial = view.getTxtRazao().getText();
		String fone1 = view.getTxtFone1().getText();
		String fone2 = view.getTxtFone2().getText();
		String email = view.getTxtEmail().getText();
		Endereco endereco = obterEndereco();
		
		//ClientePessoaFisica pf = new ClientePessoaFisica(cpf, true);
		Fornecedor fornecedor = new Fornecedor(id, nome, cnpj, razaoSocial, fone1, fone2, email, endereco);
		return fornecedor;
	}

	public void preencherEstado(List<Estados> estados) {
		DefaultComboBoxModel cbxEstadoModel = (DefaultComboBoxModel) view.getCbxEstado().getModel();
		for (Estados estado : estados) {
			view.getCbxEstado().addItem(estado);
		}
	}

	public void preencherCidades(List<Cidades> cidades) {
		DefaultComboBoxModel cbxCidadeModel = (DefaultComboBoxModel) view.getCbxCidade().getModel();
		for (Cidades cidade : cidades) {
			view.getCbxCidade().addItem(cidade);
		}
	}
	
	public Endereco obterEndereco() {
		String endereco = view.getTxtEndereco().getText();
		String numero = view.getTxtNumero().getText();
		String cep = view.getTxtCep().getText();
		String bairro = view.getTxtBairro().getText();
		Estados estado = obterEstados();
		Cidades cidade = obterCidades();
		
		return new Endereco(endereco, bairro, cep, numero, estado, cidade);
	}
	
	public Estados obterEstados() {
		return (Estados) view.getCbxEstado().getSelectedItem();
	}
	public Cidades obterCidades() {
		return (Cidades) view.getCbxCidade().getSelectedItem();
	}

}
