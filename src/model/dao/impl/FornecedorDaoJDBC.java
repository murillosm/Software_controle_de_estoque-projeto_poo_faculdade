package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.FornecedorDao;
import model.entities.Cliente;
import model.entities.Fornecedor;

public class FornecedorDaoJDBC implements FornecedorDao{

	private Connection conn;
	
	public FornecedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Fornecedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Fornecedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Fornecedor id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(Fornecedor id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
