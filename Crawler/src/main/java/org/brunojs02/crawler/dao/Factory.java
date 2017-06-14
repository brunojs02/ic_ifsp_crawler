package org.brunojs02.crawler.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Factory {
	
	private Connection con = null;
	private String server = "jdbc:mysql://";
	private String database = null;
	private String username = null;
	private String password = null;
	
	public Factory(){
		Properties prop = new Properties();
		InputStream input = null;
		try{
			input = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
			prop.load(input);
			server += prop.getProperty("dbserver") + "/";
			database = prop.getProperty("dbdatabase");
			username = prop.getProperty("dbuser");
			password = prop.getProperty("dbpassword");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
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
