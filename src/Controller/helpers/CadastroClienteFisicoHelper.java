package Controller.helpers;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.entities.Cidades;
import model.entities.ClientePessoaFisica;
import model.entities.Endereco;
import model.entities.Estados;
import view.CadastroClienteFisicoJDialog;
import view.TabelaClientesF;

public class CadastroClienteFisicoHelper implements Helper{
	private final CadastroClienteFisicoJDialog view;
	//private final TabelaClientesF tabelaClientesF;

	public CadastroClienteFisicoHelper(CadastroClienteFisicoJDialog view) {
		this.view = view;
		//this.tabelaClientesF = new TabelaClientesF();
	}
	@Override
	public void limparTela() {
		view.getTxtIdCliente().setText("");
		view.getTxtNome().setText("");
		view.getTxtCpf().setText("");
		view.getTxtDataNasc().setText("");
		view.getTxtFone1().setText("");
		view.getTxtFone2().setText("");
		view.getTxtEmail().setText("");
		view.getTxtEndereco().setText("");
		view.getTxtNumero().setText("");
		view.getTxtCep().setText("");
		view.getTxtBairro().setText("");
	}
	
	@Override
	public ClientePessoaFisica obterModelo(){
		String idString = view.getTxtIdCliente().getText();
		int id = Integer.parseInt(idString);
		String nome = view.getTxtNome().getText();
		String cpf = view.getTxtCpf().getText();
		String dataNasc = view.getTxtDataNasc().getText();
		String fone1 = view.getTxtFone1().getText();
		String fone2 = view.getTxtFone2().getText();
		String email = view.getTxtEmail().getText();
		Endereco endereco = obterEndereco();
		
		//ClientePessoaFisica pf = new ClientePessoaFisica(cpf, true);
		ClientePessoaFisica cliente = new ClientePessoaFisica(id, cpf, dataNasc, nome, fone1, fone2, email, endereco);
		return cliente;
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
