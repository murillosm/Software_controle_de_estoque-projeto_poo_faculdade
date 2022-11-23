package model.dao;

import java.util.List;

import model.entities.ClientePessoaJuridico;

public interface ClientePessoaJuridoDao {

    public void insert(ClientePessoaJuridico obj);
    public void update(ClientePessoaJuridico obj);
    public void deleteById(Integer id);
    public ClientePessoaJuridico findById(Integer id);
    public List<ClientePessoaJuridico> findAll();
   //List<ClientePessoaJuridico> findByDepartment(Endereco enderecoCliente);
}
