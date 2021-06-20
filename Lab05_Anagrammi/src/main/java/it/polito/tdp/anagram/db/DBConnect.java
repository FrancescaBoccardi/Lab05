package it.polito.tdp.anagram.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=ReplayMariaDB";
	static private HikariDataSource ds = null;

	public static Connection getConnection() {
		
		if(ds==null) {
			ds = new HikariDataSource(); //si creano le connessioni una sola volta
			
			ds.setJdbcUrl(jdbcUrl);
//			ds.setUsername("root");
//			ds.setPassword("ReplayMariaDB");  --> username e password possono anche essere inseriti così (ma in questo caso andrebbero cancellate dalla stringa jdbculr)
		}

		try {
			Connection connection = ds.getConnection();
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}
}
