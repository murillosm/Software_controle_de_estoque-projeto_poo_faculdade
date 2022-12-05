package model.dao;

import db.DB;
import model.dao.impl.ClientePessoaFisicaDaoJDBC;
import model.dao.impl.ClientePessoaJuridicaDaoJDBC;
import model.dao.impl.FornecedorDaoJDBC;
import model.dao.impl.UsuarioDaoJDBC;

public class DaoFactory {

    public static ClientePessoaFisicaDao createPessoaFisicaDao(){
        return new ClientePessoaFisicaDaoJDBC(DB.getConnection());
    }
    
    public static ClientePessoaJuridoDao createPessoaJuridicaDao(){
        return new ClientePessoaJuridicaDaoJDBC(DB.getConnection());
    }

    public static FornecedorDao createFornecedorDao(){
        return new FornecedorDaoJDBC(DB.getConnection());
    }
    public static UsuarioDao createUsuarioDao(){
        return new UsuarioDaoJDBC(DB.getConnection());
    }
    
    public static EstadoDao createEstadoDao() {
		return new EstadoDao(DB.getConnection());
	}
    
    public static CidadeDao createCidadeDao() {
		return new CidadeDao(DB.getConnection());
	}
    
}
