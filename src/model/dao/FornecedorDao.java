package model.dao;

import model.entities.Cliente;
import model.entities.Fornecedor;

import java.util.List;

public interface FornecedorDao {

    public void insert(Fornecedor obj);
    public void update(Fornecedor obj);
    public void deleteById(Fornecedor id);
    public Cliente findById(Fornecedor id);
    public List<Fornecedor> findAll();
}
