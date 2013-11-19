package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sb.entidade.Localizacao;
import br.com.sb.util.Conexao;

public class LocalizacaoDAO {

	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	
	public LocalizacaoDAO() {
		conn = new Conexao().criarConexao();
	}
	
	public void cadastrarLocalizacao(Localizacao localizacao) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("insert into localizacao set idInstituicao = ?, nome = ?");
			pstmt.setInt(1, localizacao.getInstituicao().getIdInstituicao());
			pstmt.setString(2, localizacao.getNome());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			pstmt.close();
		}
	}
	
	public void alterarLocalizacao(Localizacao localizacao) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("update localizacao set idInstituicao = ?, nome = ? where idlocalizacao = ?");	
			pstmt.setInt(1, localizacao.getInstituicao().getIdInstituicao());
			pstmt.setString(2, localizacao.getNome());
			pstmt.setInt(3, localizacao.getIdLocalizacao());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public Localizacao buscarLocalizacao(Localizacao localizacao) throws SQLException{
		
		Localizacao resultLocalizacao = null;
		
		try {
			pstmt = conn.prepareStatement("select idlocalizacao, idinstituicao, nome from localizacao where idlocalizacao = ?");
			pstmt.setInt(1, localizacao.getIdLocalizacao());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultLocalizacao = new Localizacao();
				resultLocalizacao.setIdLocalizacao(rs.getInt("idlocalizacao"));
				resultLocalizacao.getInstituicao().setIdInstituicao(rs.getInt("idinstituicao"));
				resultLocalizacao.setNome(rs.getString("nome"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		return resultLocalizacao;
	}
	
	public List<Localizacao> listarLocalizacoes() throws SQLException{

		List<Localizacao> listaLocalizacoes = new ArrayList<Localizacao>();
		
		try {
			pstmt = conn.prepareStatement("select idLocalizacao, idInstituicao, nome from localizacao");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Localizacao localizacao = new Localizacao();
				localizacao.getInstituicao().setIdInstituicao(rs.getInt("idInstituicao"));
				localizacao.setIdLocalizacao(rs.getInt("idLocalizacao"));
				localizacao.setNome(rs.getString("nome"));
				
				listaLocalizacoes.add(localizacao);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaLocalizacoes;
	}
	
	public void deletarLocalizacao(Localizacao localizacao) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("delete from localizacao where idlocalizacao = ?");
			pstmt.setInt(1, localizacao.getIdLocalizacao());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public List<Localizacao> listarLocalizacoesIdInstituicao(Integer idInstituicao) throws SQLException{

		List<Localizacao> listaLocalizacoes = new ArrayList<Localizacao>();
		
		try {
			pstmt = conn.prepareStatement("select idLocalizacao, idInstituicao, nome from localizacao where idinstituicao = ?");
			pstmt.setInt(1, idInstituicao);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Localizacao localizacao = new Localizacao();
				localizacao.getInstituicao().setIdInstituicao(rs.getInt("idLocalizacao"));
				localizacao.setIdLocalizacao(rs.getInt("idInstituicao"));
				localizacao.setNome(rs.getString("nome"));
				
				listaLocalizacoes.add(localizacao);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaLocalizacoes;
	}
	
	public static void main(String[] args) throws SQLException {
		/*
		Localizacao localizacao = new Localizacao();
		localizacao.setIdLocalizacao(new Integer(1));
		new LocalizacaoDAO().listarLocalizacoes();
		*/
	}
}
