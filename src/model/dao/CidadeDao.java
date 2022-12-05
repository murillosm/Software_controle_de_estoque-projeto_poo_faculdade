package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.entities.Cidades;
import model.entities.Estados;

public class CidadeDao {
	private Connection conn;
	
	public CidadeDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<Cidades> findAllCidades(int idEstado){
		PreparedStatement pst = null;
        ResultSet rs = null;
        try {
        	pst = conn.prepareStatement("SELECT cidade.idcidade, cidade.nome_cidade FROM cidade WHERE cidade.fk_estado_idestado = ? ");
        	
        	pst.setInt(1, idEstado);
            rs = pst.executeQuery();

            List<Cidades> list = new ArrayList<>();
            //Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {
        		
        		Cidades cidade = new Cidades();
        		cidade.setIdCidade(rs.getInt("idcidade"));
        		cidade.setNomeCidade(rs.getString("nome_cidade"));
        		
                list.add(cidade);
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
