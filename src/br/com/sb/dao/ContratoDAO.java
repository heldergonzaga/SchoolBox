package br.com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sb.entidade.Box;
import br.com.sb.entidade.Contrato;
import br.com.sb.entidade.Usuario;
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
			pstmt.setInt(1, contrato.getUsuario().getIdUsuario());
			pstmt.setInt(2, contrato.getBox().getIdBox());
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
			//pstmt.setInt(1, contrato.getIdUsuario());
			//pstmt.setInt(2, contrato.getIdBox());
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
			pstmt = conn.prepareStatement("select "
						+" i.idinstituicao, l.idlocalizacao, b.numero, b.idbox, u.nome, u.idusuario, c.dataInicial, c.dataFinal, c.termoDeAdesao, c.renovacaoAut, c.periodo, c.valorPeriodo"
						+" from contrato c"
						+" inner join usuario u on u.idusuario = c.idusuario"
						+" inner join box b on b.idbox = c.idbox"
						+" inner join Localizacao l on l.idlocalizacao = b.idlocalizacao"
						+" inner join Instituicao i on i.idinstituicao = l.idinstituicao "
						+" where idcontrato=?");
			
			pstmt.setInt(1, contrato.getIdContrato());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				resultContrato = new Contrato();
				resultContrato.setDataFinal(rs.getDate("dataFinal"));
				resultContrato.setDataInicial(rs.getDate("dataInicial"));
				resultContrato.getBox().setIdBox(rs.getInt("idbox"));
				resultContrato.getUsuario().setIdUsuario(rs.getInt("idusuario"));
				resultContrato.getBox().getLocalizacao().setIdLocalizacao(rs.getInt("l.idlocalizacao"));
				resultContrato.getBox().getLocalizacao().getInstituicao().setIdInstituicao(rs.getInt("i.idinstituicao"));
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
			
			pstmt = conn.prepareStatement(" select"
										  	+" i.idinstituicao, l.idlocalizacao,b.numero, b.idbox, u.nome, u.sobrenome, u.idusuario,c.idcontrato, c.dataInicial, c.dataFinal, c.termoDeAdesao, c.renovacaoAut, c.periodo, c.valorPeriodo"
											+" from contrato c"
											+" inner join usuario u on u.idusuario = c.idusuario"
											+" inner join box b on b.idbox = c.idbox"
											+" inner join Localizacao l on l.idlocalizacao = b.idlocalizacao"
						                    +" inner join Instituicao i on i.idinstituicao = l.idinstituicao");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				Contrato contrato = new Contrato();
				contrato.setIdContrato(rs.getInt("c.idcontrato"));
				contrato.setDataFinal(rs.getDate("dataFinal"));
				contrato.setDataInicial(rs.getDate("dataInicial"));
				contrato.getUsuario().setIdUsuario(new Integer(rs.getInt("u.idusuario")));
				contrato.getUsuario().setNome(rs.getString("u.nome"));
				contrato.getUsuario().setNome(rs.getString("u.sobrenome"));
				contrato.getBox().setIdBox(rs.getInt("b.idbox"));
				contrato.getBox().setNumero(rs.getInt("b.numero"));
				contrato.getBox().getLocalizacao().setIdLocalizacao(rs.getInt("l.idlocalizacao"));
				contrato.getBox().getLocalizacao().getInstituicao().setIdInstituicao(rs.getInt("i.idinstituicao"));
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
