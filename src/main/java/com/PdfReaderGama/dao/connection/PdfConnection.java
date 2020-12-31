package com.PdfReaderGama.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class PdfConnection{

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/lftech?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try{
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(ClassNotFoundException | SQLException ex){ // Tratamento de Exceções
			System.out.println(ex);
			return null;
		}
	
	}

}