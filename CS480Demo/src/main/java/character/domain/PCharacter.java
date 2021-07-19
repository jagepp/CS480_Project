package character.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class PCharacter {
	/*
	 * Correspond to the user table
	 */
	
	private String pClass;
	private int lightLevel; 
	private String subclass;
	private int id;
	
	
	public String getpClass() {
		return pClass;
	}
	public void setpClass(String pClass) {
		this.pClass = pClass;
	}
	public int getLightLevel() {
		return lightLevel;
	}
	public void setLightLevel(int lightLevel) {
		this.lightLevel = lightLevel;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Character [ class= " + pClass + ", id= " + id + ", light level= "
				+ lightLevel + ", subclass= " + subclass +"]";
	}
	

	
	
}
