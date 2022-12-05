package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.helpers.TabelaClienteFisicoHelper;
import Controller.helpers.TabelaClienteJuridicoHelper;
import model.dao.ClientePessoaFisicaDao;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.entities.ClientePessoaFisica;
import model.entities.ClientePessoaJuridico;
import view.TabelaClientesF;
import view.TabelaClientesJ;

public class TabelaClienteJuridicoController {
	private final TabelaClientesJ viewTabelaJ;
	private final TabelaClienteJuridicoHelper helperJuridico;
	
	

	public TabelaClienteJuridicoController(TabelaClientesJ viewTabelaJ) {
		this.viewTabelaJ = viewTabelaJ;
		this.helperJuridico = new TabelaClienteJuridicoHelper(viewTabelaJ);
	}
	
	public void atualizarClienteJ() {
		ClientePessoaJuridoDao JuridoDao = DaoFactory.createPessoaJuridicaDao();
		ArrayList<ClientePessoaJuridico> listClientesJuridicos = (ArrayList<ClientePessoaJuridico>) JuridoDao.findAll();
		//Exibir lista de clientes 
		helperJuridico.preencherTabela(listClientesJuridicos);
	}
}
