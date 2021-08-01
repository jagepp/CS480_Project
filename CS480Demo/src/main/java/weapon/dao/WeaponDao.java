package weapon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import character.domain.PCharacter;
import user.domain.User;
import weapon.domain.Weapon;


public class WeaponDao {
	

	public Weapon findByID(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Weapon weap = new Weapon();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
		    String sql = "select * from weapon where id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, String.valueOf(id));
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	int result_id = resultSet.getInt("id");
		    	if(result_id == id){
		    		weap.setId(result_id);
		    		weap.setWeaponName(resultSet.getString("weapon_name"));
		    		weap.setLightLevel(resultSet.getInt("lightLevel"));
		    		weap.setWeaponType(resultSet.getString("weapon_type"));
		    		weap.setRarity(resultSet.getString("rarity"));
		    		weap.setSlot(resultSet.getString("slot"));
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return weap;
	}
	
	
	public void add(Weapon weap) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			
			String sql = "insert into weapon(weapon_name, lightLevel, weapon_type, rarity, slot) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,weap.getWeaponName());
		    preparestatement.setString(2,String.valueOf(weap.getLightLevel()));
		    preparestatement.setString(3,weap.getWeaponType());
		    preparestatement.setString(4,weap.getRarity());
		    preparestatement.setString(5,weap.getSlot());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Weapon weap) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			if(weap != null) {
				String sql = "update weapon set weapon_name=?, lightLevel=?, weapon_type=?, rarity=?, slot=? where id=?";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				preparestatement.setString(1,weap.getWeaponName());
			    preparestatement.setString(2,String.valueOf(weap.getLightLevel()));
			    preparestatement.setString(3,weap.getWeaponType());
			    preparestatement.setString(4,weap.getRarity());
			    preparestatement.setString(5,weap.getSlot());
			    preparestatement.setInt(6,weap.getId());
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
			
			
			String sql = "select * from weapon";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Weapon weap = new Weapon();
				weap.setId(resultSet.getInt("id"));
				weap.setWeaponName(resultSet.getString("weapon_name"));
	    		weap.setLightLevel(resultSet.getInt("lightLevel"));
	    		weap.setWeaponType(resultSet.getString("weapon_type"));
	    		weap.setRarity(resultSet.getString("rarity"));
	    		weap.setSlot(resultSet.getString("slot"));
	    		list.add(weap);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public boolean deleteCharacter(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Weapon weap = findByID(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/d2_inventory","root","Boogwee14");
			
			if(weap != null) {
				String sql = "delete from weapon where id=?";
				PreparedStatement preparestatement = connect.prepareStatement(sql); 
				preparestatement.setString(1,String.valueOf(weap.getId()));
				preparestatement.executeUpdate();
			}
			else return false;
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return true;
	}
		
}
