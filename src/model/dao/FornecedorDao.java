package model.dao;

import model.entities.Cliente;
import model.entities.Fornecedor;

import java.util.List;

public interface FornecedorDao {

    public void insert(Fornecedor obj);
    public void update(Fornecedor obj);
    public void deleteById(Integer id);
    public Fornecedor findById(Integer id);
    public List<Fornecedor> findByNome(String nome);
    public Fornecedor findByCnpj(String cnpj);
    public List<Fornecedor> findAll();
	public List<Fornecedor> findAllNome(String model);
	public List<Fornecedor> findAllID(int model);
	public List<Fornecedor> findAllCnpj(String cnpj);
}
