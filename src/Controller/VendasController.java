package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.helpers.VendasHelper;
import model.dao.ClientePessoaFisicaDao;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.dao.EstoqueDao;
import model.dao.FornecedorDao;
import model.dao.UsuarioDao;
import model.entities.Cliente;
import model.entities.ClientePessoaFisica;
import model.entities.ClientePessoaJuridico;
import model.entities.Estoque;
import model.entities.Fornecedor;
import model.entities.Usuario;
import view.VendasFrame;

public class VendasController {
	private final VendasFrame view;
	private final VendasHelper helper;
	ClientePessoaFisicaDao clienteFDao = DaoFactory.createPessoaFisicaDao();
	ClientePessoaJuridoDao clienteJDao = DaoFactory.createPessoaJuridicaDao();
	EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();
	
	public VendasController(VendasFrame view) {
		this.view = view;
		this.helper = new VendasHelper(view);
	}
	
	public void buscarNomeCliente() {
		helper.tabelaCliente();
		String tipo = view.getCbxTipoCliente().getSelectedItem().toString().trim();
		try {
			if (tipo.equals("Pessoa Fisica")) {
					//ClientePessoaFisica model = clienteDao.findAllCliente(view.getTxtPesquisaNome().getText());
					ArrayList<ClientePessoaFisica> listClienteF =  (ArrayList<ClientePessoaFisica>) clienteFDao.findAllCliente(view.getTxtPesquisaNome().getText());
					//helper.dadosJText(model);
					helper.preencherTabelaFisica(listClienteF);
			}
			if (tipo.equals("Pessoa Juridida")) {
				ArrayList<ClientePessoaJuridico> listClienteJ =  (ArrayList<ClientePessoaJuridico>) clienteJDao.findAllCliente(view.getTxtPesquisaNome().getText());
				//helper.dadosJText(model);
				helper.preencherTabelaJuridica(listClienteJ);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,
					"O cliente buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",
					null, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void buscarItem() {
		helper.tabelaProdutos();
		try {
			ArrayList<Estoque> listEstoque = (ArrayList<Estoque>) estoqueDao.findAllItemVendas(view.getTxtPesquisaProduto().getText());
			// helper.dadosJText(model);
			helper.preencherTabelaItens(listEstoque);

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,
					"O cliente buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",
					null, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void boxUsuario() throws SQLException{
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDao.findAll();
		helper.preencherUsuario(usuarios);
	}
	
	public void clickedTabelaCliente() {
		try {
			String nomeCliente =""+ view.getTbPesquisa().getValueAt(view.getTbPesquisa().getSelectedRow(), 0);
			int id = Integer.parseInt(nomeCliente);
			ClientePessoaFisica cliente = clienteFDao.findById(id);
			view.getTxtIDCliente().setText(String.valueOf(cliente.getIdCliente()));
			view.getTxtPesquisaNome().setText(cliente.getNomeCliente());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao escolher linha tente novamente!");
		}
	}
	
	public void clickedTabelaItem() {
		try {
			String nomeItem =""+ view.getTbPesquisa().getValueAt(view.getTbPesquisa().getSelectedRow(), 0);
			int id = Integer.parseInt(nomeItem);
			Estoque estoque = estoqueDao.findById(id);
			view.getTxtPesquisaProduto().setText(estoque.getNomeItem());
			view.getTxtValorItem().setText(String.valueOf(estoque.getPrecoItem()));
			view.getTxtQuatidade().setText("1");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao escolher linha tente novamente!");
		}
	}
	
	public void calcularTotal() {
		Float valorTotar, valorItem;
		Integer qtd;
		
		valorItem = Float.parseFloat(view.getTxtValorItem().getText());
		qtd = Integer.parseInt(view.getTxtQuatidade().getText());
		
		valorTotar = valorItem * qtd;
		
		view.getTxtValorTotal().setText(String.valueOf(valorTotar));
	}
}
