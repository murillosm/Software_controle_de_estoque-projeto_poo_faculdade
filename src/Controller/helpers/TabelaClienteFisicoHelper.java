package Controller.helpers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.entities.ClientePessoaFisica;
import view.TabelaClientesF;

public class TabelaClienteFisicoHelper {
	private final TabelaClientesF tabelaClientesF;
	

	public TabelaClienteFisicoHelper(TabelaClientesF tabelaClientesF) {
		this.tabelaClientesF = tabelaClientesF;
	}

	public void preencherTabela(ArrayList<ClientePessoaFisica> listClientesFisicos) {
		DefaultTableModel tableModel = (DefaultTableModel) tabelaClientesF.getTbClienteF().getModel();
		tableModel.setNumRows(0);
		
		//percorrer lista
		//ClientePessoaFisicaDao fisicaDao = DaoFactory.createPessoaFisicaDao();
		for (ClientePessoaFisica clientePessoaFisica : listClientesFisicos) {
			tableModel.addRow(new Object[] {
				clientePessoaFisica.getIdCliente(),
				clientePessoaFisica.getNomeCliente(),
				clientePessoaFisica.getCpfCliente(),
				clientePessoaFisica.getDataNascFormatada(),
				clientePessoaFisica.getFoneCliente1(),
				clientePessoaFisica.getFoneCliente2(),
				clientePessoaFisica.getEmailCliente(),
				clientePessoaFisica.getEnderecoCliente().getEndereco(),
				clientePessoaFisica.getEnderecoCliente().getNumero(),
				clientePessoaFisica.getEnderecoCliente().getBairro(),
				clientePessoaFisica.getEnderecoCliente().getEstado().getNomeEstado(),
				clientePessoaFisica.getEnderecoCliente().getCidade().getNomeCidade()
			});
		}
	}
	
		
}
