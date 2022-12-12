package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.helpers.RelatorioHelper;
import Controller.helpers.VendasHelper;
import model.dao.ClientePessoaFisicaDao;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.dao.EstoqueDao;
import model.dao.VendasDao;
import model.entities.Estoque;
import model.entities.Fornecedor;
import model.entities.Venda;
import view.RelatorioVenda;
import view.VendasFrame;

public class RelatorioController {
	private final RelatorioVenda view;
	private final RelatorioHelper helper;
	VendasDao vendasDao = DaoFactory.createVendasDao();

	
	
	
	public RelatorioController(RelatorioVenda view) {
		this.view = view;
		this.helper = new RelatorioHelper(view);
	}
	
	public void ListaVendas() {
		ArrayList<Venda> listVendas = (ArrayList<Venda>) vendasDao.findAllVendas();
		helper.preencherVendas(listVendas);
	}
	
	public void buscarItemVenda() {
		try {
			String idString = view.getTxtID().getText();
			int id = Integer.parseInt(idString);
			ArrayList<Venda> listVendas = (ArrayList<Venda>)vendasDao.ListItem(id);
			helper.preencherItensList(listVendas);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "O id de venda buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",null,JOptionPane.WARNING_MESSAGE);
		}
	}
	
}