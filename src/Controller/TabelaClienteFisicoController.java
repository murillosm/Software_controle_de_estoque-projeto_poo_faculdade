package Controller;

import java.util.List;

import Controller.helpers.TabelaClienteFisicoHelper;
import model.dao.ClientePessoaFisicaDao;
import model.dao.DaoFactory;
import model.entities.ClientePessoaFisica;
import view.TabelaClientesF;

public class TabelaClienteFisicoController {
	private final TabelaClientesF viewTabelaF;
	private final TabelaClienteFisicoHelper helperFisico;
	
	

	public TabelaClienteFisicoController(TabelaClientesF viewTabelaF) {
		this.viewTabelaF = viewTabelaF;
		this.helperFisico = new TabelaClienteFisicoHelper(viewTabelaF);
	}
	
	public void atualizarClienteF() {
		ClientePessoaFisicaDao fisicaDao = DaoFactory.createPessoaFisicaDao();
		List<ClientePessoaFisica> listClientesFisicos = fisicaDao.findAll();
		//Exibir lista de clientes 
		helperFisico.preencherTabela(listClientesFisicos);
	}
}
