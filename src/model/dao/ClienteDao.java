package model.dao;

import java.util.List;

import model.entities.Cliente;

public interface ClienteDao {

    public void insert(Cliente obj);
    public void update(Cliente obj);
    public void deleteById(Integer id);
    public Cliente findById(Integer id);
    public List<Cliente> findAll();
    //List<Cliente> findByDepartment(Endereco enderecoCliente);
}
