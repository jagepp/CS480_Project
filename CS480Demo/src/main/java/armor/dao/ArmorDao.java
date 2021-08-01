package armor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import armor.domain.Armor;


public class ArmorDao {
	

	public Armor findByID(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Armor armor = new Armor();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
		    String sql = "select * from Armor where id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, String.valueOf(id));
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	int result_id = resultSet.getInt("id");
		    	if(result_id == id){
		    		armor.setId(result_id);
		    		armor.setArmorName(resultSet.getString("armor_name"));
		    		armor.setLightLevel(resultSet.getInt("lightLevel"));
		    		armor.setArmorType(resultSet.getString("armor_type"));
		    		armor.setRarity(resultSet.getString("rarity"));
		    		armor.setSlot(resultSet.getString("slot"));
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return armor;
	}
	
	
	public void add(Armor armor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			
			String sql = "insert into Armor(armor_name, lightLevel, armor_type, rarity, slot) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,armor.getArmorName());
		    preparestatement.setString(2,String.valueOf(armor.getLightLevel()));
		    preparestatement.setString(3,armor.getArmorType());
		    preparestatement.setString(4,armor.getRarity());
		    preparestatement.setString(5,armor.getSlot());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Armor armor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			if(armor != null) {
				String sql = "update Armor set armor_name=?, lightLevel=?, armor_type=?, rarity=?, slot=? where id=?";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				preparestatement.setString(1,armor.getArmorName());
			    preparestatement.setString(2,String.valueOf(armor.getLightLevel()));
			    preparestatement.setString(3,armor.getArmorType());
			    preparestatement.setString(4,armor.getRarity());
			    preparestatement.setString(5,armor.getSlot());
			    preparestatement.setInt(6,armor.getId());
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
			
			
			String sql = "select * from Armor";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Armor armor = new Armor();
				armor.setId(resultSet.getInt("id"));
				armor.setArmorName(resultSet.getString("armor_name"));
	    		armor.setLightLevel(resultSet.getInt("lightLevel"));
	    		armor.setArmorType(resultSet.getString("armor_type"));
	    		armor.setRarity(resultSet.getString("rarity"));
	    		armor.setSlot(resultSet.getString("slot"));
	    		list.add(armor);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public boolean deleteCharacter(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Armor armor = findByID(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			if(armor != null) {
				String sql = "delete from Armor where id=?";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				preparestatement.setString(1,String.valueOf(armor.getId()));
				preparestatement.executeUpdate();
			}
			else return false;
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return true;
	}
		
}
