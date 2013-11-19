package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sb.entidade.Box;
import br.com.sb.util.Conexao;

public class BoxDAO {

	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	
	public BoxDAO() {
		conn = new Conexao().criarConexao();
	}
	
	public void cadastrarBox(Box box) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("insert into box set idlocalizacao = ?, senha= ?, numero = ?");
			pstmt.setInt(1, box.getLocalizacao().getIdLocalizacao());
			pstmt.setString(2, box.getSenha());
			pstmt.setInt(3, box.getNumero());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			pstmt.close();
		}
	}
	
	public void alterarBox(Box box) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("update box set idlocalizacao = ?, senha= ?, numero = ? where idbox = ?");	
			pstmt.setInt(1, box.getLocalizacao().getIdLocalizacao());
			pstmt.setString(2, box.getSenha());
			pstmt.setInt(3, box.getNumero());
			pstmt.setInt(4, box.getIdBox());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public Box buscarBox(Box box) throws SQLException{
		
		Box resultBox = null;
		
		try {
			pstmt = conn.prepareStatement("select idbox, idlocalizacao, senha, numero from box where idbox = ?");
			pstmt.setInt(1, box.getIdBox());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultBox = new Box();
				resultBox.setIdBox(rs.getInt("idbox"));
				resultBox.getLocalizacao().setIdLocalizacao(rs.getInt("idlocalizacao"));
				resultBox.setSenha(rs.getString("senha"));
				resultBox.setNumero(rs.getInt("numero"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		return resultBox;
	}
	
	public List<Box> listarBoxs() throws SQLException{

		List<Box> listaBoxs = new ArrayList<Box>();
		
		try {
			pstmt = conn.prepareStatement("select idbox, idlocalizacao, senha, numero from box");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Box box = new Box();
				box.setIdBox(rs.getInt("idbox"));
				box.getLocalizacao().setIdLocalizacao(rs.getInt("idlocalizacao"));
				box.setSenha(rs.getString("senha"));
				box.setNumero(rs.getInt("numero"));
				
				listaBoxs.add(box);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaBoxs;
	}
	
	public void deletarBox(Box box) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("delete from box where idbox = ?");
			pstmt.setInt(1, box.getIdBox());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public List<Box> listarBoxsIdLocalizacao(Integer idLocalizacao) throws SQLException{

		List<Box> listaBoxs = new ArrayList<Box>();
		
		try {
			pstmt = conn.prepareStatement("select idbox, idlocalizacao, senha, numero from box where idlocalizacao = ?");
			pstmt.setInt(1, idLocalizacao);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Box box = new Box();
				box.getLocalizacao().setIdLocalizacao(rs.getInt("idlocalizacao"));
				box.setSenha(rs.getString("senha"));
				box.setNumero(rs.getInt("numero"));
				box.setIdBox(rs.getInt("idbox"));
				
				listaBoxs.add(box);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaBoxs;
	}
	
	public static void main(String[] args) throws SQLException {
		/*
		Box box = new Box();
		box.setIdBox(new Integer(2));
		box.setIdLocalizacao(new Integer(1));
		box.setNumero(new Integer(5));
		box.setSenha("1");
		
		new BoxDAO().deletarCargo(box);
		*/
	}
}
