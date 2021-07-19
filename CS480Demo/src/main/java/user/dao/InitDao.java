package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import user.domain.User;



public class InitDao {
	
	

	public void initDB() {
		Statement statement;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");//this line was changed to acces my local database server, uusing the bookstore db
		   
		    	
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS Student");
			
			String sqlstmt = "CREATE TABLE IF NOT EXISTS Student" +
							"(id INTEGER not NULL AUTO_INCREMENT, " +
							" Name VARCHAR(20), " +
							" Address VARCHAR(50), " +
							" Status VARCHAR(10), " +
							" PRIMARY KEY (id))";
			statement.executeUpdate(sqlstmt);
		    
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
