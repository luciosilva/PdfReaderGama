package com.PdfReaderGama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.PdfReaderGama.dao.connection.PdfConnection;
import com.PdfReaderGama.models.Product;
import java.sql.Statement;

public class Dao {

	
	public void truncate() throws SQLException, ClassNotFoundException{
		
		Connection connection = null;

		connection = PdfConnection.getConnection();
		
		try{
			Statement statement = connection.createStatement();
			statement.execute("truncate productgama");
			
		}catch(SQLException ex){
			System.out.println(ex);
		} 
		connection.close();

	}
	
	
	public void insert(Product product) throws SQLException, ClassNotFoundException{
		
		PreparedStatement stmt = null;
		Connection connection = null;

		connection = PdfConnection.getConnection();
		
		try{
			stmt = connection.prepareStatement("INSERT INTO productgama(cod,name,kind,pdv,stock) VALUES (?,?,?,?,?)");
			stmt.setString(1, product.getCod());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getKind());
			stmt.setDouble(4, Double.valueOf(product.getPdv()));
			stmt.setString(5, product.getStock());
			
			stmt.executeUpdate(); 
		}catch(SQLException ex){
			System.out.println(ex);
		} 
		connection.close();

	}
	
}
