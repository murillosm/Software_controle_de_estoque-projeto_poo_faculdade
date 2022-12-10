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
import model.entities.Estoque;
import model.entities.Fornecedor;
import view.CadastroClienteFisicoJDialog;
import view.CadastroClienteJuridicoJDialog;
import view.FornecedorViewJDialog;
import view.TabelaClientesF;

public class CadastroFornecedorHelper implements Helper{
	private final FornecedorViewJDialog view;

	public CadastroFornecedorHelper(FornecedorViewJDialog view) {
		this.view = view;
	}
	@Override
	public void limparTela() {
		view.getTxtIdFornecedor().setText("0");
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
	
	public void dadosJText(Fornecedor model) {	
		view.getTxtIdFornecedor().setText(String.valueOf(model.getIdFornecedor()));
		view.getTxtNome().setText(model.getNomeFornecedor());
		view.getTxtCnpj().setText(model.getCnpjFornecedor());
		view.getTxtRazao().setText(model.getRazaoSocialFornecedor());
		view.getTxtFone1().setText(model.getFoneFornecedo1());
		view.getTxtFone2().setText(model.getFoneFornecedo2());
		view.getTxtEmail().setText(model.getEmailFornecedor());
		view.getTxtEndereco().setText(model.getEnderecoFornecedor().getEndereco());
		view.getTxtNumero().setText(model.getEnderecoFornecedor().getNumero());
		view.getTxtCep().setText(model.getEnderecoFornecedor().getCep());
		view.getTxtBairro().setText(model.getEnderecoFornecedor().getBairro());
		view.getCbxEstado().setSelectedItem(model.getEnderecoFornecedor().getEstado());
		view.getCbxCidade().setSelectedItem(model.getEnderecoFornecedor().getCidade());
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
	
	public void desabilitar() {
		view.getTxtIdFornecedor().setEnabled(false);
		view.getTxtNome().setEnabled(false);
		view.getTxtCnpj().setEnabled(false);
		view.getTxtRazao().setEnabled(false);
		view.getTxtFone1().setEnabled(false);
		view.getTxtFone2().setEnabled(false);
		view.getTxtEmail().setEnabled(false);
		view.getTxtEndereco().setEnabled(false);
		view.getTxtNumero().setEnabled(false);
		view.getTxtCep().setEnabled(false);
		view.getTxtBairro().setEnabled(false);
		view.getCbxEstado().setEnabled(false);
		view.getCbxCidade().setEnabled(false);
		view.getBtnNovo().setEnabled(false);
		view.getBtSalvar().setEnabled(false);
		//view.getBtAlterar().setEnabled(true);
	}
	
	public void habilitar() {
		view.getTxtIdFornecedor().setEnabled(!false);
		view.getTxtNome().setEnabled(!false);
		view.getTxtCnpj().setEnabled(!false);
		view.getTxtRazao().setEnabled(!false);
		view.getTxtFone1().setEnabled(!false);
		view.getTxtFone2().setEnabled(!false);
		view.getTxtEmail().setEnabled(!false);
		view.getTxtEndereco().setEnabled(!false);
		view.getTxtNumero().setEnabled(!false);
		view.getTxtCep().setEnabled(!false);
		view.getTxtBairro().setEnabled(!false);
		view.getCbxEstado().setEnabled(!false);
		view.getCbxCidade().setEnabled(!false);
		view.getBtnNovo().setEnabled(false);
		view.getBtSalvar().setEnabled(false);
		view.getBtCancel().setEnabled(true);
		view.getBtAlterar().setEnabled(true);
	}

}
