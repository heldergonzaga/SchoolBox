package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sb.entidade.Instituicao;
import br.com.sb.util.Conexao;

public class InstituicaoDAO {

	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	
	public InstituicaoDAO() {
		conn = new Conexao().criarConexao();
	}
	
	public void cadastrarInstituicao(Instituicao instituicao) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("insert into instituicao set idusuario = ?, nome = ?, estado = ?, endereco = ?, telefone = ?, email = ?");
			pstmt.setInt(1, instituicao.getIdUsuario());
			pstmt.setString(2, instituicao.getNome());
			pstmt.setString(3, instituicao.getEstado());
			pstmt.setString(4, instituicao.getEndereco());
			pstmt.setString(5, instituicao.getTelefone());
			pstmt.setString(6, instituicao.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			pstmt.close();
		}
	}
	
	public void alterarInstituicao(Instituicao instituicao) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("update instituicao set idusuario = ?, nome = ?, estado = ?, endereco = ?, telefone = ?, email = ? where idinstituicao = ?");	
			pstmt.setInt(1, instituicao.getIdUsuario());
			pstmt.setString(2, instituicao.getNome());
			pstmt.setString(3, instituicao.getEstado());
			pstmt.setString(4, instituicao.getEndereco());
			pstmt.setString(5, instituicao.getTelefone());
			pstmt.setString(6, instituicao.getEmail());
			pstmt.setInt(7, instituicao.getIdInstituicao());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public Instituicao buscarInstituicao(Instituicao instituicao) throws SQLException{
		
		Instituicao resultInstituicao = null;
		
		try {
			pstmt = conn.prepareStatement("select idusuario, nome, estado, endereco, telefone, email from instituicao where idinstituicao = ?");
			pstmt.setInt(1, instituicao.getIdInstituicao());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultInstituicao = new Instituicao();
				resultInstituicao.setIdUsuario(rs.getInt("idusuario"));
				resultInstituicao.setNome(rs.getString("nome"));
				resultInstituicao.setEstado(rs.getString("estado"));
				resultInstituicao.setEndereco(rs.getString("endereco"));
				resultInstituicao.setTelefone(rs.getString("telefone"));
				resultInstituicao.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		return resultInstituicao;
	}
	
	public List<Instituicao> listarInstituicoes() throws SQLException{

		List<Instituicao> listaInstituicoes = new ArrayList<Instituicao>();
		
		try {
			pstmt = conn.prepareStatement("select idusuario, nome, estado, endereco, telefone, email from instituicao from instituicao");
			
			
			while(rs.next()){
				
				Instituicao instituicao = new Instituicao();
				instituicao.setIdUsuario(rs.getInt("idusuario"));
				instituicao.setNome(rs.getString("nome"));
				instituicao.setEstado(rs.getString("estado"));
				instituicao.setEndereco(rs.getString("endereco"));
				instituicao.setTelefone(rs.getString("telefone"));
				instituicao.setEmail(rs.getString("email"));
				
				listaInstituicoes.add(instituicao);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaInstituicoes;
	}
	
	public void deletarInstituicao(Instituicao instituicao) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("delete from instituicao where isinstituicao = ?");
			pstmt.setInt(1, instituicao.getIdInstituicao());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		/*
		Localizacao localizacao = new Localizacao();
		localizacao.setIdLocalizacao(new Integer(1));
		new LocalizacaoDAO().listarLocalizacoes();
		*/
	}
}
