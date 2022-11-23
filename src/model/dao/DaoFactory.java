package model.dao;

import db.DB;
import model.dao.impl.ClientePessoaFisicaDaoJDBC;
import model.dao.impl.ClientePessoaJuridicaDaoJDBC;

public class DaoFactory {

    public static ClientePessoaFisicaDao createPessoaFisicaDao(){
        return new ClientePessoaFisicaDaoJDBC(DB.getConnection());
    }
    
    public static ClientePessoaJuridoDao createPessoaJuridicaDao(){
        return new ClientePessoaJuridicaDaoJDBC(DB.getConnection());
    }

    /*public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }*/
}
