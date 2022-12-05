package Controller.helpers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.entities.ClientePessoaJuridico;
import view.TabelaClientesJ;

public class TabelaClienteJuridicoHelper {
	private final TabelaClientesJ view;
	

	public TabelaClienteJuridicoHelper(TabelaClientesJ tabelaClientesJ) {
		this.view = tabelaClientesJ;
	}

	public void preencherTabela(ArrayList<ClientePessoaJuridico> listClientesJuridicos) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbClienteJ().getModel();
		tableModel.setNumRows(0);
		
		//percorrer lista
		//ClientePessoaFisicaDao fisicaDao = DaoFactory.createPessoaFisicaDao();
		for (ClientePessoaJuridico clientePessoaJuridico : listClientesJuridicos) {
			tableModel.addRow(new Object[] {
				clientePessoaJuridico.getIdCliente(),
				clientePessoaJuridico.getNomeCliente(),
				clientePessoaJuridico.getCnpjCliente(),
				clientePessoaJuridico.getRazaoSocialCliente(),
				clientePessoaJuridico.getFoneCliente1(),
				clientePessoaJuridico.getFoneCliente2(),
				clientePessoaJuridico.getEmailCliente(),
				clientePessoaJuridico.getEnderecoCliente().getEndereco(),
				clientePessoaJuridico.getEnderecoCliente().getNumero(),
				clientePessoaJuridico.getEnderecoCliente().getBairro(),
				clientePessoaJuridico.getEnderecoCliente().getEstado().getNomeEstado(),
				clientePessoaJuridico.getEnderecoCliente().getCidade().getNomeCidade()
			});
		}
	}
	
		
}
