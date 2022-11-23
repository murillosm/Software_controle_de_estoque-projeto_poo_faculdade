package model.dao.impl;

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
import model.dao.FornecedorDao;
import model.entities.Cidades;
import model.entities.Endereco;
import model.entities.Estados;
import model.entities.Fornecedor;

public class FornecedorDaoJDBC implements FornecedorDao{

	private Connection conn;
	
	public FornecedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Fornecedor obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("INSERT INTO fornecedor" 
					+ "(nome_fornecedor, fonefornecedor1, fonefornecedor2,"
					+ " email, endereco, bairro, numero, cep,"
					+ " estado_idestado, cidade_idcidade, cnpj_fornecedor, razao_social)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, obj.getNomeFornecedor());
			pst.setString(2, obj.getFoneFornecedo1());
			pst.setString(3, obj.getFoneFornecedo2());
			pst.setString(4, obj.getEmailFornecedor());
			pst.setString(5, obj.getEnderecoFornecedor().getEndereco());
			pst.setString(6, obj.getEnderecoFornecedor().getBairro());
			pst.setString(7, obj.getEnderecoFornecedor().getNumero());
			pst.setString(8, obj.getEnderecoFornecedor().getCep());
			pst.setInt(9, obj.getEnderecoFornecedor().getEstado().getIdEstado());
			pst.setInt(10, obj.getEnderecoFornecedor().getCidade().getIdCidade());
			pst.setString(11, obj.getCnpjFornecedor());
			pst.setString(12, obj.getRazaoSocialFornecedor());

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdFornecedor(id);
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

	@Override
	public void update(Fornecedor obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("UPDATE fornecedor " 
					+ "SET nome_fornecedor = ?, fonefornecedor1 = ?, fonefornecedor2 = ?,"
					+ " email = ?, endereco = ?, bairro, numero = ?, cep = ?,"
					+ " estado_idestado = ?, cidade_idcidade = ?,"
					+ " cnpj_fornecedor = ?, razao_social = ?" 
					+ "WHERE id_fornecedor = ?");

			pst.setString(1, obj.getNomeFornecedor());
			pst.setString(2, obj.getFoneFornecedo1());
			pst.setString(3, obj.getFoneFornecedo2());
			pst.setString(4, obj.getEmailFornecedor());
			pst.setString(5, obj.getEnderecoFornecedor().getEndereco());
			pst.setString(6, obj.getEnderecoFornecedor().getBairro());
			pst.setString(7, obj.getEnderecoFornecedor().getNumero());
			pst.setString(8, obj.getEnderecoFornecedor().getCep());
			pst.setInt(9, obj.getEnderecoFornecedor().getEstado().getIdEstado());
			pst.setInt(10, obj.getEnderecoFornecedor().getCidade().getIdCidade());
			pst.setString(11, obj.getCnpjFornecedor());
			pst.setString(12, obj.getRazaoSocialFornecedor());
			pst.setInt(13, obj.getIdFornecedor());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			// DB.closeConnection();
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("DELETE FROM fornecedor WHERE id_fornecedor = ?");
			pst.setInt(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
		}
	}

	@Override
	public Fornecedor findById(Integer id){
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT fornecedor.*,"
					+ "estado.nome_estado, cidade.nome_cidade\r\n"
					+ "FROM fornecedor "
					+ "INNER JOIN estado\r\n"
					+ "ON fornecedor.estado_idEstado = estado.idestado\r\n"
					+ "INNER JOIN cidade\r\n"
					+ "ON fornecedor.cidade_idCidade = cidade.idcidade\r\n"
					+ "WHERE id_fornecedor = ?");

			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				Fornecedor fornecedor = instantiateFornecedor(rs);
				return fornecedor;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Fornecedor> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT fornecedor.*,"
					+ "estado.nome_estado, cidade.nome_cidade\r\n"
					+ "FROM fornecedor "
					+ "INNER JOIN estado\r\n"
					+ "ON fornecedor.estado_idEstado = estado.idestado\r\n"
					+ "INNER JOIN cidade\r\n"
					+ "ON fornecedor.cidade_idCidade = cidade.idcidade\r\n"
					+ "ORDER BY nome_fornecedor");

			rs = pst.executeQuery();
			List<Fornecedor> list = new ArrayList<>();

			while (rs.next()) {
				Fornecedor fornecedor = instantiateFornecedor(rs);
				list.add(fornecedor);
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
	private Fornecedor instantiateFornecedor(ResultSet rs) throws SQLException {
		
		Estados estado = new Estados();
		estado.setIdEstado(rs.getInt("estado_idestado"));
		estado.setNomeEstado(rs.getString("nome_estado"));
		//estado.setUF(rs.getString("sigla_estado"));
		
		Cidades cidade = new Cidades();
		cidade.setIdCidade(rs.getInt("cidade_idcidade"));
		cidade.setNomeCidade(rs.getString("nome_cidade"));
		cidade.setEstado(estado);
		
		Endereco endereco = new Endereco();
		endereco.setEndereco(rs.getString("endereco"));
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setBairro(rs.getString("bairro"));
		endereco.setCep(rs.getString("cep"));
		endereco.setNumero(rs.getString("numero"));
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
		fornecedor.setNomeFornecedor(rs.getString("nome_fornecedor"));
		fornecedor.setCnpjFornecedor(rs.getString("cnpj_fornecedor"));
		fornecedor.setRazaoSocialFornecedor(rs.getString("razao_social"));
		fornecedor.setFoneFornecedo1(rs.getString("fonefornecedor1"));
		fornecedor.setFoneFornecedo2(rs.getString("fonefornecedor2"));
		fornecedor.setEmailFornecedor(rs.getString("Email"));
		fornecedor.setEnderecoFornecedor(endereco);
		return fornecedor;
	}	

}
