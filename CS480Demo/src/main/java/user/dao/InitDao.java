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
			statement.executeUpdate("DROP TABLE IF EXISTS armor");
			statement.executeUpdate("DROP TABLE IF EXISTS weapon");
			statement.executeUpdate("DROP TABLE IF EXISTS pCharacter");
			
			
			String sqlstmt = " create table if not exists armor("
					+ " armor_name varchar(30) not NULL,"
					+ " lightLevel integer not null,"
					+ " armor_type varchar(20),"
					+ " rarity varchar(15),"
					+ " slot varchar(15),"
					+ " id integer not null auto_increment,"
					+ " primary key(id));";
			statement.executeUpdate(sqlstmt);
			
			sqlstmt = " create table if not exists pCharacter("
					+ " pClass varchar(10) not NULL,"
					+ " lightLevel integer not null,"
					+ " subclass varchar(20),"
					+ " id integer not null auto_increment,"
					+ " primary key(id));";
			statement.executeUpdate(sqlstmt);
			
			sqlstmt = " create table if not exists weapon("
					+ " weapon_name varchar(30) not NULL,"
					+ " lightLevel integer not null,"
					+ " weapon_type varchar(20),"
					+ " rarity varchar(15),"
					+ " slot varchar(15),"
					+ " id integer not null auto_increment,"
					+ " primary key(id));";
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
