package model.dao;


import model.entities.Endereco;

import java.util.List;

public interface EnderecoDao {
    public void insert(Endereco obj);
    public void update(Endereco obj);
    public void deleteById(Integer id);
    public Endereco findById(Integer id);
    public List<Endereco> findAll();
}
