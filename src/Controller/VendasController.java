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
import model.dao.VendasDao;
import model.entities.Cliente;
import model.entities.ClientePessoaFisica;
import model.entities.ClientePessoaJuridico;
import model.entities.Estoque;
import model.entities.Fornecedor;
import model.entities.Usuario;
import model.entities.Venda;
import view.VendasFrame;

public class VendasController {
	private final VendasFrame view;
	private final VendasHelper helper;
	ClientePessoaFisicaDao clienteFDao = DaoFactory.createPessoaFisicaDao();
	ClientePessoaJuridoDao clienteJDao = DaoFactory.createPessoaJuridicaDao();
	EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();
	VendasDao vendasDao = DaoFactory.createVendasDao();
	Venda venda;
	
	
	
	public VendasController(VendasFrame view) {
		this.view = view;
		this.helper = new VendasHelper(view);
	}
	
	public void finalizarVenda() {
		try {
			venda = helper.obterModelo();
			vendasDao.insert(venda);
			JOptionPane.showMessageDialog(null, "Venda Cadastrado com sucesso!");
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Alguns campos estão vazios", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void novoItem() {
		try {
			//Venda venda;
			venda = helper.obterItems();
			vendasDao.insertItemVenda(venda);
			listaItem();
			//helper.limparTela();
			JOptionPane.showMessageDialog(null, "Item Cadastrado com sucesso!");
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Alguns campos estão vazios", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void listaItem() {
		String idVendaString = view.getTxtIDVenda().getText();
		int idVenda = Integer.parseInt(idVendaString);
		ArrayList<Venda> listVendas = (ArrayList<Venda>) vendasDao.ListItem(idVenda);
		helper.preencherItensList(listVendas);
	}
	
	
	public void iniciarVenda() {
			vendasDao.insertIniciarVenda(new Venda());	
			//preecherEstoque();
			int vendaID =  vendasDao.findBy(); 
			view.getTxtIDVenda().setText(String.valueOf(vendaID));
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
					"O Item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",
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
			view.getTxtIDProduto().setText(String.valueOf(estoque.getIdItem()));
			view.getTxtQuatidade().setText("1");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao escolher linha tente novamente!");
		}
	}
	
	public void excluirVenda() {
		//venda = helper.obterModelo();
		try {
			String idString = view.getTxtIDVenda().getText();
			int id = Integer.parseInt(idString);
			vendasDao.deleteById(id);
			helper.limparTela();
			view.dispose();
			JOptionPane.showMessageDialog(null, "Venda deletada com sucesso!");
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar o venda!");
		}
	}
	
	public void baixaEstoque() {
		
		String idProdutoString = view.getTxtIDProduto().getText();
		int id = Integer.parseInt(idProdutoString);
		
		String qString = view.getTxtQuatidade().getText();
		int qtd = Integer.parseInt(qString);
		
		int list = estoqueDao.conferirQuantidade(id,qtd);

		if (list>=qtd) {
			estoqueDao.updateQuantidade(id,qtd);
			novoItem();
		}else {
			JOptionPane.showMessageDialog(null, "A quantidade do produto esta indisponivel no estoque!\n A quantidade maxima e de apenas "+ list);
		}
	}
	
}
