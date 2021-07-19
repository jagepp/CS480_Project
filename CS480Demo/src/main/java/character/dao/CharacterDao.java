package character.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import character.domain.PCharacter;
import user.domain.User;


public class CharacterDao {
	

	public PCharacter findByID(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PCharacter p_character = new PCharacter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
		    String sql = "select * from pCharacter where id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, String.valueOf(id));
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	int result_id = resultSet.getInt("id");
		    	if(result_id == id){
		    		p_character.setId(result_id);
		    		p_character.setLightLevel(resultSet.getInt("lightLevel"));
		    		p_character.setpClass(resultSet.getString("pClass"));
		    		p_character.setSubclass(resultSet.getString("subclass"));
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return p_character;
	}
	
	
	public void add(PCharacter pChar) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			
			String sql = "insert into pCharacter(pClass, lightLevel, subClass) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,pChar.getpClass());
		    preparestatement.setString(2,String.valueOf(pChar.getLightLevel()));
		    preparestatement.setString(3,pChar.getSubclass());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(PCharacter updatedChar) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			if(updatedChar != null) {
				String sql = "update pCharacter set pClass=?, lightLevel=?, subclass=? where id=?";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				preparestatement.setString(1,updatedChar.getpClass());
			    preparestatement.setInt(2,updatedChar.getLightLevel());
			    preparestatement.setString(3,updatedChar.getSubclass());
				preparestatement.setInt(4,updatedChar.getId());
				preparestatement.executeUpdate();
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			
			String sql = "select * from pCharacter";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				PCharacter pChar = new PCharacter();
				pChar.setId(resultSet.getInt("id"));
				pChar.setLightLevel(resultSet.getInt("lightLevel"));
	    		pChar.setpClass(resultSet.getString("pClass"));
	    		pChar.setSubclass(resultSet.getString("subclass"));
	    		list.add(pChar);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public boolean deleteCharacter(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		PCharacter pChar = findByID(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			if(pChar != null) {
				String sql = "delete from pCharacter where id=?";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				preparestatement.setString(1,String.valueOf(pChar.getId()));
				preparestatement.executeUpdate();
			}
			else return false;
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return true;
	}
		
}
