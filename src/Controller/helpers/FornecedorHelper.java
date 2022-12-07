package Controller.helpers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.dao.FornecedorDao;
import model.entities.ClientePessoaJuridico;
import model.entities.Fornecedor;
import view.CadastroFornecedorFrame;
import view.TabelaClientesJ;

public class FornecedorHelper implements Helper {
	private final CadastroFornecedorFrame view;
	
	public FornecedorHelper(CadastroFornecedorFrame view) {
		this.view = view;
	}

	public void preencherTabela(ArrayList<Fornecedor> listFornecedor) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbFornecedor().getModel();
		tableModel.setNumRows(0);

		// percorrer lista
		//FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		for (Fornecedor fornecedor : listFornecedor) {
			tableModel.addRow(new Object[] {
					fornecedor.getIdFornecedor(),
					fornecedor.getNomeFornecedor(),
					fornecedor.getCnpjFornecedor(),
					fornecedor.getRazaoSocialFornecedor(),
					fornecedor.getFoneFornecedo1(),
					fornecedor.getFoneFornecedo2(),
					fornecedor.getEmailFornecedor(),
					fornecedor.getEnderecoFornecedor().getEndereco(),
					fornecedor.getEnderecoFornecedor().getNumero(),
					fornecedor.getEnderecoFornecedor().getBairro(),
					fornecedor.getEnderecoFornecedor().getEstado().getNomeEstado(),
					fornecedor.getEnderecoFornecedor().getCidade().getNomeCidade() });
		}
	}
	
	public void preencher(Fornecedor fornecedor) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbFornecedor().getModel();
		tableModel.setNumRows(0);

		// percorrer lista
		//FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		//for (Fornecedor fornecedor : listFornecedor) {
			tableModel.addRow(new Object[] {
					fornecedor.getIdFornecedor(),
					fornecedor.getNomeFornecedor(),
					fornecedor.getCnpjFornecedor(),
					fornecedor.getRazaoSocialFornecedor(),
					fornecedor.getFoneFornecedo1(),
					fornecedor.getFoneFornecedo2(),
					fornecedor.getEmailFornecedor(),
					fornecedor.getEnderecoFornecedor().getEndereco(),
					fornecedor.getEnderecoFornecedor().getNumero(),
					fornecedor.getEnderecoFornecedor().getBairro(),
					fornecedor.getEnderecoFornecedor().getEstado().getNomeEstado(),
					fornecedor.getEnderecoFornecedor().getCidade().getNomeCidade() });
		//}
	}

	@Override
	public Object obterModelo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limparTela() {
		// TODO Auto-generated method stub

	}

}
