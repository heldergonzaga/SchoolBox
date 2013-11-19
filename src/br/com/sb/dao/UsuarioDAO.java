package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.sb.entidade.Usuario;
import br.com.sb.util.Conexao;

public class UsuarioDAO {

	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	
	public UsuarioDAO() {
		conn = new Conexao().criarConexao();
	}
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException{
		
		try {
			
			pstmt = conn.prepareStatement("insert into usuario set  idcargo = ?,  nome= ?, sobrenome= ?, cpf= ?, email= ?, bairro= ?, cidade= ?, uf= ?, complemento= ?, numero= ?, senha= ?, login= ?, statusCadastro= ?, dataCadastro= ?");
			pstmt.setInt(1, usuario.getIdCargo());
			pstmt.setString(2, usuario.getNome());
			pstmt.setString(3, usuario.getSobrenome());
			pstmt.setString(4, usuario.getCpf());
			pstmt.setString(5, usuario.getEmail());
			pstmt.setString(6, usuario.getBairro());
			pstmt.setString(7, usuario.getCidade());
			pstmt.setString(8, usuario.getUf().trim());
			pstmt.setString(9, usuario.getComplemento());
			pstmt.setString(10, usuario.getNumero());
			pstmt.setString(11, usuario.getSenha());
			pstmt.setString(12, usuario.getLogin());
			pstmt.setInt(13, usuario.getStatusCadastro());
			pstmt.setTimestamp(14, new java.sql.Timestamp(usuario.getDataCadastro().getTime()));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			pstmt.close();
		}
	}
	
	
	
	public void alterarUsuario(Usuario usuario) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("update usuario set idcargo = ?, nome= ?, sobrenome= ?, cpf= ?, email= ?, bairro= ?, cidade= ?, uf= ?, complemento= ?, numero= ?, senha= ?, login= ? where idusuario = ?");	
			pstmt.setInt(1, usuario.getIdCargo());
			pstmt.setString(2, usuario.getNome());
			pstmt.setString(3, usuario.getSobrenome());
			pstmt.setString(4, usuario.getCpf());
			pstmt.setString(5, usuario.getEmail());
			pstmt.setString(6, usuario.getBairro());
			pstmt.setString(7, usuario.getCidade());
			pstmt.setString(8, usuario.getUf().trim());
			pstmt.setString(9, usuario.getComplemento());
			pstmt.setString(10, usuario.getNumero());
			pstmt.setString(11, usuario.getSenha());
			pstmt.setString(12, usuario.getLogin());
			pstmt.setInt(13, usuario.getIdUsuario());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public Usuario buscarUsuario(Integer idUsuario) throws SQLException{
		
		Usuario resultUsuario = null;
		
		try {
			pstmt = conn.prepareStatement("select idusuario, idcargo, nome, sobrenome, cpf, email, bairro, cidade, uf, complemento, numero, senha, login from usuario where idusuario = ?");
			pstmt.setInt(1, idUsuario);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultUsuario = new Usuario();
				resultUsuario.setIdUsuario(rs.getInt("idusuario"));
				resultUsuario.setBairro(rs.getString("bairro"));
				resultUsuario.setCidade(rs.getString("cidade"));
				resultUsuario.setComplemento(rs.getString("complemento"));
				resultUsuario.setCpf(rs.getString("cpf"));
				resultUsuario.setEmail(rs.getString("email"));
				resultUsuario.setIdCargo(rs.getInt("idcargo"));
				resultUsuario.setLogin(rs.getString("login"));
				resultUsuario.setNome(rs.getString("nome"));
				resultUsuario.setSobrenome(rs.getString("sobrenome"));
				resultUsuario.setNumero(rs.getString("numero"));
				resultUsuario.setSenha(rs.getString("senha"));
				resultUsuario.setUf(rs.getString("uf"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		return resultUsuario;
	}
	
	public List<Usuario> listarUsuarios() throws SQLException{

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			pstmt = conn.prepareStatement("select idUsuario, idcargo, nome, sobrenome, cpf, email, bairro, cidade, uf, complemento, numero, senha, login from usuario");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idusuario"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setComplemento(rs.getString("complemento"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setIdCargo(rs.getInt("idcargo"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setNumero(rs.getString("numero"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setUf(rs.getString("uf"));
				
				listaUsuarios.add(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaUsuarios;
	}
	
	public void deletarUsuario(Integer idusuario) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("delete from usuario where idusuario= ?");
			pstmt.setInt(1, idusuario);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	
}
