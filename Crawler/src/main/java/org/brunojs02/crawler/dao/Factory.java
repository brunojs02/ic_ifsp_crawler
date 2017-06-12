package org.brunojs02.crawler.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
	
	private Connection con = null;
	private String server = "jdbc:mysql://localhost/";
	private String database = "webcrawler";
	private String username = "root";
	private String password = "33960206";
	
	public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(server + database, username, password);
			con.setAutoCommit(false);
			return con;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection(){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
