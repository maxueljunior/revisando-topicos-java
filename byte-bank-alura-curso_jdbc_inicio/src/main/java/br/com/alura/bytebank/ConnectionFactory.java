package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recuperarConexao() {
		try {
			String url = "jdbc:mysql://localhost:3306/byte_bank?user=root&password=maxuelt123";
			return DriverManager.getConnection(url);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}	
