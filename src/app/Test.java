package app;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.dao.ClientePessoaFisicaDao;
import model.dao.ClientePessoaJuridoDao;
import model.dao.DaoFactory;
import model.dao.EstadoDao;
import model.dao.EstoqueDao;
import model.dao.FornecedorDao;
import model.dao.VendasDao;
import model.entities.Cidades;
import model.entities.ClientePessoaFisica;
import model.entities.ClientePessoaJuridico;
import model.entities.Endereco;
import model.entities.Estados;
import model.entities.Estoque;
import model.entities.Fornecedor;
import model.entities.Venda;

public class Test {

	public static void main(String[] args) {
		
		ClientePessoaFisicaDao clienteDao = DaoFactory.createPessoaFisicaDao();
		ClientePessoaJuridoDao clienteDao2 = DaoFactory.createPessoaJuridicaDao();
		FornecedorDao fornecedorDao = DaoFactory.createFornecedorDao();
		EstadoDao estadoDao = DaoFactory.createEstadoDao();
		EstoqueDao estoqueDao = DaoFactory.createEstoqueDao();
		VendasDao vendasDao = DaoFactory.createVendasDao();
		
//		Estados estado = new Estados(9);
//		Cidades cidade = new Cidades(894);
//		Endereco endereco = new Endereco("endereço","bairro","00000000","s/n", cidade,estado);
//		ClientePessoaFisica novoCliente = new ClientePessoaFisica("mario ","000000", null,"email@hotmail.com", endereco, "00000000000",new Date());
//		clienteDao.insert(novoCliente);
//		System.out.println("Inserted! New id = " + novoCliente.getIdCliente());
		
//		Endereco endereco = new Endereco("endereço","bandeiras","00000000", "s/n", 894,9);
//		ClientePessoaJuridico novoCliente2 = new ClientePessoaJuridico("murillo","000000", null,"email@hotmail.com", endereco, "razao","00000000000000");
//		clienteDao2.insert(novoCliente2);
//		System.out.println("Inserted! New id = " + novoCliente2.getIdCliente());
		
//		ClientePessoaFisica cliente = clienteDao.findById(5);
//		
//		System.out.println(cliente);
		
		/*List<ClientePessoaFisica> list = clienteDao.findAll();
		for (ClientePessoaFisica cliente : list) {
			System.out.println(cliente);
		}*/
		
		/*List<ClientePessoaJuridico> list = clienteDao2.findAll();
		for (ClientePessoaJuridico cliente : list) {
			System.out.println(cliente);
		}*/
		
//		List<Venda> list = vendasDao.ListItem(1);
//		for (Venda venda : list) {
//			System.out.println(venda);
//		}
		
//		List<Estados> list = estadoDao.findAllEstados();
//		for (Estados estados : list) {
//			System.out.println(estados);
//		}
		
//		String nome = "la";
//		List<ClientePessoaFisica> list = clienteDao.findAllCliente(nome);
//		for (ClientePessoaFisica cliente : list) {
//			System.out.println(cliente);
//		}
		
//		int list = estoqueDao.conferirQuantidade(6,2);
//		int venda = 2;
//		
//		if (list>venda) {
//			estoqueDao.updateQuantidade(6,2);
//		}
//		//for (Estoque estoque : list) {
//		System.out.println(list);
//		//}
		
		List<Venda> list = vendasDao.findAllId();
		for (Venda cliente : list) {
			System.out.println(cliente);
		}
	}

}
