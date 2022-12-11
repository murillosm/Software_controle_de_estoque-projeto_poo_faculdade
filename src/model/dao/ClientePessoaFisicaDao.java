package model.dao;

import java.util.List;

import model.entities.ClientePessoaFisica;

public interface ClientePessoaFisicaDao {

    public void insert(ClientePessoaFisica obj);
    public void update(ClientePessoaFisica obj);
    public void deleteById(Integer id);
    public ClientePessoaFisica findById(Integer id);
    public List<ClientePessoaFisica> findAll();
    //List<ClientePessoaFisica> findByDepartment(Endereco enderecoCliente);
    public List<ClientePessoaFisica> findAllCliente(String nome);
}
