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
			pst = conn.prepareStatement("INSERT INTO fornecedor(\r\n"
					+ "	nome_fornecedor, cnpj_fornecedor, email,"
					+ " razao_social, fonefornecedor1, fonefornecedor2, endereco,"
					+ " bairro, numero, cep, estado_idestado, cidade_idcidade)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, obj.getNomeFornecedor());
			pst.setString(2, obj.getCnpjFornecedor());
			pst.setString(3, obj.getEmailFornecedor());
			pst.setString(4, obj.getRazaoSocialFornecedor());
			pst.setString(5, obj.getFoneFornecedo1());
			pst.setString(6, obj.getFoneFornecedo2());
			pst.setString(7, obj.getEnderecoFornecedor().getEndereco());
			pst.setString(8, obj.getEnderecoFornecedor().getBairro());
			pst.setString(9, obj.getEnderecoFornecedor().getNumero());
			pst.setString(10, obj.getEnderecoFornecedor().getCep());
			pst.setInt(11, obj.getEnderecoFornecedor().getEstado().getIdEstado());
			pst.setInt(12, obj.getEnderecoFornecedor().getCidade().getIdCidade());

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
			pst = conn.prepareStatement("UPDATE public.fornecedor\r\n"
					+ "	SET nome_fornecedor=?, cnpj_fornecedor=?, email=?,\r\n"
					+ "	razao_social=?, fonefornecedor1=?, fonefornecedor2=?, endereco=?,\r\n"
					+ "	bairro=?, numero=?, cep=?, estado_idestado=?, cidade_idcidade=?" 
					+ "WHERE id_fornecedor ="+obj.getIdFornecedor());

			pst.setString(1, obj.getNomeFornecedor());
			pst.setString(2, obj.getCnpjFornecedor());
			pst.setString(3, obj.getEmailFornecedor());
			pst.setString(4, obj.getRazaoSocialFornecedor());
			pst.setString(5, obj.getFoneFornecedo1());
			pst.setString(6, obj.getFoneFornecedo2());
			pst.setString(7, obj.getEnderecoFornecedor().getEndereco());
			pst.setString(8, obj.getEnderecoFornecedor().getBairro());
			pst.setString(9, obj.getEnderecoFornecedor().getNumero());
			pst.setString(10, obj.getEnderecoFornecedor().getCep());
			pst.setInt(11, obj.getEnderecoFornecedor().getEstado().getIdEstado());
			pst.setInt(12, obj.getEnderecoFornecedor().getCidade().getIdCidade());
			//pst.setInt(13, obj.getIdFornecedor());

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
			pst = conn.prepareStatement("SELECT fornecedor.*, estado.nome_estado, cidade.nome_cidade \r\n"
					+ "FROM fornecedor \r\n"
					+ "INNER JOIN estado ON fornecedor.estado_idEstado = estado.idestado\r\n"
					+ "INNER JOIN cidade ON fornecedor.cidade_idCidade = cidade.idcidade\r\n"
					+ "WHERE fornecedor.id_fornecedor = ?");

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
	public List<Fornecedor> findByNome(String nome) {
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
					+ "WHERE nome_cliente LIKE ?");

			pst.setString(1, nome + '%');
			rs = pst.executeQuery();
			List<Fornecedor> list = new ArrayList<>();

			while (rs.next()) {
				Fornecedor fornecedor = instantiateFornecedor(rs);
				list.add(fornecedor);
				//return fornecedor;
			}
			return list;
			//return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public Fornecedor findByCnpj(String cnpj) {
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
					+ "WHERE cnpj_fornecedor LIKE ?");

			pst.setString(1, cnpj + '%');
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
	
	@Override
	public List<Fornecedor> findAllNome(String model) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT fornecedor.*, estado.nome_estado, cidade.nome_cidade \r\n"
					+ "FROM fornecedor \r\n"
					+ "INNER JOIN estado ON fornecedor.estado_idEstado = estado.idestado\r\n"
					+ "INNER JOIN cidade ON fornecedor.cidade_idCidade = cidade.idcidade\r\n"
					+ "WHERE fornecedor.nome_fornecedor LIKE '%" + model + "%'\r\n"
					+ "ORDER BY fornecedor.nome_fornecedor");

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
	
	@Override
	public List<Fornecedor> findAllID(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT fornecedor.*, estado.nome_estado, cidade.nome_cidade \r\n"
					+ "FROM fornecedor \r\n"
					+ "INNER JOIN estado ON fornecedor.estado_idEstado = estado.idestado\r\n"
					+ "INNER JOIN cidade ON fornecedor.cidade_idCidade = cidade.idcidade\r\n"
					+ "WHERE fornecedor.id_fornecedor >= " + id + "\r\n"
					+ "ORDER BY fornecedor.id_fornecedor");

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
	
	@Override
	public List<Fornecedor> findAllCnpj(String cnpj) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT fornecedor.*, estado.nome_estado, cidade.nome_cidade \r\n"
					+ "FROM fornecedor \r\n"
					+ "INNER JOIN estado ON fornecedor.estado_idEstado = estado.idestado\r\n"
					+ "INNER JOIN cidade ON fornecedor.cidade_idCidade = cidade.idcidade\r\n"
					+ "WHERE fornecedor.cnpj_fornecedor LIKE '%" + cnpj + "%'\r\n"
					+ "ORDER BY fornecedor.id_fornecedor");

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
