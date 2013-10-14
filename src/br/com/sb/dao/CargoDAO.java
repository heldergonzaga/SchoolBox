package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sb.entidade.Cargo;
import br.com.sb.util.Conexao;

public class CargoDAO {

	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	
	public CargoDAO() {
		conn = new Conexao().criarConexao();
	}
	
	public void cadastrarCargo(Cargo cargo) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("insert into cargo set titulo = ?");
			pstmt.setString(1, cargo.getTitulo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			pstmt.close();
		}
	}
	
	public void alterarCargo(Cargo cargo) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("update cargo set titulo = ? where idcargo = ?");	
			pstmt.setString(1, cargo.getTitulo());
			pstmt.setInt(2, cargo.getIdCargo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public Cargo buscarCargo(Cargo cargo) throws SQLException{
		
		Cargo resultCargo = null;
		
		try {
			pstmt = conn.prepareStatement("select idcargo, titulo from cargo where idcargo = ?");
			pstmt.setInt(1, cargo.getIdCargo());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultCargo = new Cargo();
				resultCargo.setIdCargo(rs.getInt("idcargo"));
				resultCargo.setTitulo(rs.getString("titulo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		return resultCargo;
	}
	
	public List<Cargo> listarCargos() throws SQLException{

		List<Cargo> listaCargos = new ArrayList<Cargo>();
		
		try {
			pstmt = conn.prepareStatement("select idcargo, titulo from cargo");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Cargo cargo = new Cargo();
				cargo.setIdCargo(rs.getInt("idcargo"));
				cargo.setTitulo(rs.getString("titulo"));
				listaCargos.add(cargo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaCargos;
	}
	
	public void deletarCargo(Cargo cargo) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("delete from cargo where idCargo = ?");
			pstmt.setInt(1, cargo.getIdCargo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		/*
		Cargo cargo = new Cargo();
		cargo.setTitulo("teste cadastro");
		cargo.setIdCargo(new Integer(1));
		
		new CargoDAO().listarCargos();
		*/
	}
	
}
