package model.dao;

import model.entities.Cliente;
import model.entities.Fornecedor;

import java.util.List;

public interface FornecedorDao {

    public void insert(Fornecedor obj);
    public void update(Fornecedor obj);
    public void deleteById(Integer id);
    public Fornecedor findById(Integer id);
    public List<Fornecedor> findAll();
}
