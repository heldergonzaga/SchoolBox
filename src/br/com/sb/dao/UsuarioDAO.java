package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			pstmt = conn.prepareStatement("insert into usuario set idcargo = ?, nome= ?, cpf= ?, email= ?, bairro= ?, cidade= ?, uf= ?, complemento= ?, numero= ?, senha= ?, login= ?");
			pstmt.setInt(1, usuario.getIdCargo());
			pstmt.setString(2, usuario.getNome());
			pstmt.setString(3, usuario.getCpf());
			pstmt.setString(4, usuario.getEmail());
			pstmt.setString(5, usuario.getBairro());
			pstmt.setString(6, usuario.getCidade());
			pstmt.setString(7, usuario.getUf());
			pstmt.setString(8, usuario.getComplemento());
			pstmt.setString(9, usuario.getNumero());
			pstmt.setString(10, usuario.getSenha());
			pstmt.setString(11, usuario.getLogin());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			pstmt.close();
		}
	}
	
	public void alterarUsuario(Usuario usuario) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("update usuario set idcargo = ?, nome= ?, cpf= ?, email= ?, bairro= ?, cidade= ?, uf= ?, complemento= ?, numero= ?, senha= ?, login= ? where idusuario = ?");	
			pstmt.setInt(1, usuario.getIdCargo());
			pstmt.setString(2, usuario.getNome());
			pstmt.setString(3, usuario.getCpf());
			pstmt.setString(4, usuario.getEmail());
			pstmt.setString(5, usuario.getBairro());
			pstmt.setString(6, usuario.getCidade());
			pstmt.setString(7, usuario.getUf());
			pstmt.setString(8, usuario.getComplemento());
			pstmt.setString(9, usuario.getNumero());
			pstmt.setString(10, usuario.getSenha());
			pstmt.setString(11, usuario.getLogin());
			pstmt.setInt(12, usuario.getIdUsuario());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public Usuario buscarUsuario(Usuario usuario) throws SQLException{
		
		Usuario resultUsuario = null;
		
		try {
			pstmt = conn.prepareStatement("select idcargo, nome, cpf, email, bairro, cidade, uf, complemento, numero, senha, login from usuario where idusuario = ?");
			pstmt.setInt(1, usuario.getIdUsuario());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultUsuario = new Usuario();
				resultUsuario.setBairro(rs.getString("bairro"));
				resultUsuario.setCidade(rs.getString("cidade"));
				resultUsuario.setComplemento(rs.getString("complemento"));
				resultUsuario.setCpf(rs.getString("cpf"));
				resultUsuario.setEmail(rs.getString("email"));
				resultUsuario.setIdCargo(rs.getInt("idcargo"));
				resultUsuario.setLogin(rs.getString("login"));
				resultUsuario.setNome(rs.getString("nome"));
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
			pstmt = conn.prepareStatement("select idcargo, nome, cpf, email, bairro, cidade, uf, complemento, numero, senha, login from usuario");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setComplemento(rs.getString("complemento"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setIdCargo(rs.getInt("idcargo"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
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
	
	public void deletarUsuario(Usuario usuario) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("delete from usuario where idusuario= ?");
			pstmt.setInt(1, usuario.getIdUsuario());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		
		/*Usuario usuario = new Usuario();
		usuario.setIdUsuario(new Integer(2));
		usuario.setBairro("teste");
		usuario.setCidade("teste");
		usuario.setComplemento("teste");
		usuario.setCpf("55555555555");
		usuario.setEmail("sanuse@sanuse.com.br");
		usuario.setIdCargo(new Integer(1));
		usuario.setLogin("sanuse");
		usuario.setNome("sanuse queiroz");
		usuario.setNumero("test");
		usuario.setSenha("1234");
		usuario.setUf("df");
		
		new UsuarioDAO().deletarUsuario(usuario);
		
		*/
		
	}
}
