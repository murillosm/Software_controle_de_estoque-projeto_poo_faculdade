package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Estoque;
import model.entities.Venda;

public class VendasDao {
	private Connection conn;

	public VendasDao(Connection conn) {
		this.conn = conn;
	}

	public void insert(Venda obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("UPDATE public.venda\r\n"
					+ "	SET valor_venda=?, data_venda=?, idusuario=?, idcliente=?\r\n"
					+ "	WHERE id_venda=?");

			pst.setDouble(1, obj.getValor());
			pst.setDate(2, new java.sql.Date(obj.getData().getTime()));
			pst.setInt(3, obj.getUsuario().getIdUsuario());
			pst.setInt(4, obj.getCliente());
			pst.setInt(5, obj.getIdVenda());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			// DB.closeConnection();
		}
	}
	
	
	public void insertIniciarVenda(Venda obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("INSERT INTO venda(valor_venda) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

			pst.setDouble(1, 0);
			int rowsAffected = pst.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdVenda(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			// DB.closeConnection();
		}
	}
	
	public int findBy() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1");
			rs = pst.executeQuery();
			//List<Venda> list = new ArrayList<>();

			if (rs.next()) {
				//Venda venda = instantiateID(rs);
				Venda venda = new Venda();
				venda.setIdVenda(rs.getInt("id_venda"));
				
				return venda.getIdVenda();
			}
			return 0;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			//DB.closeResultSet(rs);
		}
	}
	
	public void insertItemVenda(Venda obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("INSERT INTO item_vendido(id_venda, id_item, quantidade)"
					+ " VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1, obj.getIdVenda());
			pst.setInt(2, obj.getProduto().getIdItem());
			pst.setInt(3, obj.getQtd());
			
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdVenda(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			//DB.closeConnection();
		}
	}
	
	public List<Venda> ListItem(int idVenda) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(
					"SELECT id_venda, estoque.id_item, quantidade, estoque.nome_item\r\n"
					+ "FROM item_vendido \r\n"
					+ "INNER JOIN estoque \r\n"
					+ "ON item_vendido.id_item = estoque.id_item"
					+ " WHERE item_vendido.id_venda =" + idVenda);
			//pst = conn.prepareStatement("SELECT * FROM item_vendido");

			rs = pst.executeQuery();
			List<Venda> list = new ArrayList<>();

			while (rs.next()) {
				Venda venda = instantiateItem(rs);
				list.add(venda);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}
	
	public List<Venda> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT item_vendido.*, estoque.nome_item\r\n"
					+ "FROM item_vendido \r\n"
					+ "INNER JOIN estoque \r\n"
					+ "ON estoque.id_item = item_vendido.id_item");

			rs = pst.executeQuery();
			List<Venda> list = new ArrayList<>();

			while (rs.next()) {
				Venda venda = instantiateItem(rs);
				list.add(venda);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}
	
	private Venda instantiateItem(ResultSet rs) throws SQLException {
		Estoque estoque = new Estoque();
		estoque.setNomeItem(rs.getString("nome_item"));
		estoque.setIdItem(rs.getInt("id_item"));

		Venda venda = new Venda();
		venda.setIdVenda(rs.getInt("id_venda"));
		venda.setQtd(rs.getInt("quantidade"));
		venda.setProduto(estoque);
		return venda;
	}



	public void deleteById(Integer id) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("DELETE FROM public.venda WHERE id_venda = ?");
			pst.setInt(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
		}
	}
}
	


