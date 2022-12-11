package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.helpers.VendasHelper;
import model.dao.ClientePessoaFisicaDao;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
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
	
	public VendasController(VendasFrame view) {
		this.view = view;
		this.helper = new VendasHelper(view);
	}
	
	public void buscarItemNome() {
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
	
	public void boxUsuario() throws SQLException{
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDao.findAll();
		helper.preencherUsuario(usuarios);
	}

}
