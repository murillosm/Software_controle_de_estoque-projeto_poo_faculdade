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
import model.entities.Cidades;
import model.entities.Endereco;
import model.entities.Estados;
import model.entities.Estoque;
import model.entities.Fornecedor;

public class EstoqueDao {
	private Connection conn;

	public EstoqueDao(Connection conn) {
		this.conn = conn;
	}

	public void insert(Estoque obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("INSERT INTO estoque(\r\n"
					+ "	preco, quantidade_item, nome_item, marca_item, descricao_item, idfornecedor)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			pst.setDouble(1, obj.getPrecoItem());
			pst.setInt(2, obj.getQuantidade());
			pst.setString(3, obj.getNomeItem());
			pst.setString(4, obj.getMarcaItem());
			pst.setString(5, obj.getDescricaoItem());
			pst.setInt(6, obj.getForn().getIdFornecedor());
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdItem(id);
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

	public void update(Estoque obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("UPDATE public.estoque\r\n"
					+ "	SET preco = ?, quantidade_item = ?, nome_item = ?, marca_item = ?, descricao_item = ?, idfornecedor = ?\r\n"
					+ "	WHERE id_item = ?");

			pst.setDouble(1, obj.getPrecoItem());
			pst.setInt(2, obj.getQuantidade());
			pst.setString(3, obj.getNomeItem());
			pst.setString(4, obj.getMarcaItem());
			pst.setString(5, obj.getDescricaoItem());
			pst.setInt(6, obj.getForn().getIdFornecedor());
			pst.setInt(7, obj.getIdItem());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			// DB.closeConnection();
		}

	}

	public void deleteById(Integer id) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("DELETE FROM public.estoque WHERE id_item = ?");
			pst.setInt(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
		}
	}

	public Estoque findById(Integer id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM public.estoque WHERE id_item = ?");

			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				Estoque estoque = instantiateEstoque(rs);
				return estoque;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}

	public List<Estoque> findByNome(String nome) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM public.estoque WHERE nome_item = ?");

			pst.setString(1, nome + '%');
			rs = pst.executeQuery();
			List<Estoque> list = new ArrayList<>();

			while (rs.next()) {
				Estoque estoque = instantiateEstoque(rs);
				list.add(estoque);
				// return fornecedor;
			}
			return list;
			// return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}

	public List<Estoque> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM public.estoque ORDER BY nome_item");

			rs = pst.executeQuery();
			List<Estoque> list = new ArrayList<>();

			while (rs.next()) {
				Estoque estoque = instantiateEstoque(rs);
				list.add(estoque);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
	private Estoque instantiateEstoque(ResultSet rs) throws SQLException {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setIdFornecedor(rs.getInt("idfornecedor"));
		
		Estoque estoque = new Estoque();
		estoque.setIdItem(rs.getInt("id_item"));
		estoque.setPrecoItem(rs.getDouble("preco"));
		estoque.setNomeItem(rs.getString("nome_item"));
		estoque.setQuantidade(rs.getInt("quantidade_item"));
		estoque.setMarcaItem(rs.getString("marca_item"));
		estoque.setDescricaoItem(rs.getString("descricao_item"));
		estoque.setForn(fornecedor);
		return estoque;
	}
}
