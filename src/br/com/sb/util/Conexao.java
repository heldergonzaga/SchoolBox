package br.com.sb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection criarConexao(){
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(""
					+ "jdbc:mysql://localhost/SchoolBox","root","root");
				
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		return conexao;
	}
	public void fecharConexao(Connection conexao) throws SQLException{
		conexao.close();
	}
	/*
	public static void main(String[] args) throws SQLException {
		new Conexao().criarConexao();
	}*/
}
