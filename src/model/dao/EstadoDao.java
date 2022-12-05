package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.entities.ClientePessoaFisica;
import model.entities.Estados;

public class EstadoDao {
	private Connection conn;

	public EstadoDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<Estados> findAllEstados(){
		PreparedStatement pst = null;
        ResultSet rs = null;
        try {
        	pst = conn.prepareStatement("SELECT estado.idestado, estado.nome_estado FROM estado");

            rs = pst.executeQuery();

            List<Estados> list = new ArrayList<>();
            //Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {
            	Estados estado = new Estados();
        		estado.setIdEstado(rs.getInt("idestado"));
        		estado.setNomeEstado(rs.getString("nome_estado"));
                list.add(estado);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(pst);
            DB.closeResultSet(rs);
        }
	}
}
