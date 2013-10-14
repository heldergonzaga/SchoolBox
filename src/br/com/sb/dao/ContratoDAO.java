package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sb.entidade.Contrato;
import br.com.sb.util.Conexao;

public class ContratoDAO {

	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	
	public ContratoDAO() {
		conn = new Conexao().criarConexao();
	}
	
	public void cadastrarContrato(Contrato contrato) throws SQLException{
		
		try {
			
			pstmt = conn.prepareStatement("insert contrato set idusuario = ?, idbox = ?, dataInicial = ?, dataFinal = ?, termoDeAdesao = ?, renovacaoAut = ?, periodo = ?, valorPeriodo = ?");
			pstmt.setInt(1, contrato.getIdUsuario());
			pstmt.setInt(2, contrato.getIdBox());
			pstmt.setDate(3, contrato.getDataInicial());
			pstmt.setDate(4, contrato.getDataFinal());
			pstmt.setString(5, contrato.getTermoDeAdesao());
			pstmt.setString(6, contrato.getRenovacaoAuto());
			pstmt.setString(7, contrato.getPeriodo());
			pstmt.setString(8, contrato.getValorPeriodo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			pstmt.close();
		}
	}
	
	public void alterarContrato(Contrato contrato) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("update contrato set idusuario = ?, idbox = ?, dataInicial = ?, dataFinal = ?, termoDeAdesao = ?, renovacaoAut = ?, periodo = ?, valorPeriodo = ? where idcontrato=?");	
			pstmt.setInt(1, contrato.getIdUsuario());
			pstmt.setInt(2, contrato.getIdBox());
			pstmt.setDate(3, contrato.getDataInicial());
			pstmt.setDate(4, contrato.getDataFinal());
			pstmt.setString(5, contrato.getTermoDeAdesao());
			pstmt.setString(6, contrato.getRenovacaoAuto());
			pstmt.setString(7, contrato.getPeriodo());
			pstmt.setString(8, contrato.getValorPeriodo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
		}
	}
	
	public Contrato buscarContrato(Contrato contrato) throws SQLException{
		
		Contrato resultContrato = null;
		
		try {
			pstmt = conn.prepareStatement("select idusuario, idbox, dataInicial, dataFinal, termoDeAdesao, renovacaoAut, periodo, valorPeriodo from contrato where idcontrato=?");
			pstmt.setInt(1, contrato.getIdContrato());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultContrato = new Contrato();
				resultContrato.setDataFinal(rs.getDate("dataFinal"));
				resultContrato.setDataInicial(rs.getDate("dataInicial"));
				resultContrato.setIdBox(rs.getInt("idbox"));
				resultContrato.setIdUsuario(rs.getInt("idusuario"));
				resultContrato.setPeriodo(rs.getString("periodo"));
				resultContrato.setRenovacaoAuto(rs.getString("renovacaoAut"));
				resultContrato.setTermoDeAdesao(rs.getString("termoDeAdesao"));
				resultContrato.setValorPeriodo(rs.getString("valorPeriodo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		return resultContrato;
	}
	
	public List<Contrato> listarContratos() throws SQLException{

		List<Contrato> listaContratos = new ArrayList<Contrato>();
		
		try {
			pstmt = conn.prepareStatement("select idusuario, idbox, dataInicial, dataFinal, termoDeAdesao, renovacaoAut, periodo, valorPeriodo from contrato");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				Contrato contrato = new Contrato();
				contrato.setDataFinal(rs.getDate("dataFinal"));
				contrato.setDataInicial(rs.getDate("dataInicial"));
				contrato.setIdBox(rs.getInt("idbox"));
				contrato.setIdUsuario(rs.getInt("idusuario"));
				contrato.setPeriodo(rs.getString("periodo"));
				contrato.setRenovacaoAuto(rs.getString("renovacaoAut"));
				contrato.setTermoDeAdesao(rs.getString("termoDeAdesao"));
				contrato.setValorPeriodo(rs.getString("valorPeriodo"));
				
				listaContratos.add(contrato);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			rs.close();
		}
		
		return listaContratos;
	}
	
	public void deletarContrato(Contrato contrato) throws SQLException{
		
		try {
			pstmt = conn.prepareStatement("delete from contrato where idcontrato = ?");
			pstmt.setInt(1, contrato.getIdContrato());
			
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
