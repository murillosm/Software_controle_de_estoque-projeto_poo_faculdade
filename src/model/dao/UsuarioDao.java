package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.entities.Usuario;

public interface UsuarioDao{

    public void insert(Usuario obj) throws SQLException;
    public void update(Usuario obj);
    public void deleteById(Integer id);
    public Usuario findById(Integer id);
    public List<Usuario> findAll() throws SQLException;
    public Boolean autenticarUsuarioSenha(Usuario usuario) throws SQLException;
    public Usuario selectUsuario(String userName) throws SQLException;
}
