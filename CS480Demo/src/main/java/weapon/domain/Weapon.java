package weapon.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Weapon {
	/*
	 * Correspond to the user table
	 */
	
	private String weaponName;
	private int lightLevel;
	private String weaponType;
	private String rarity;
	private String slot;
	private int id;

	@Override
	public String toString() {
		return "Weapon [ name= " + weaponName + ", id= " + id + ", light level= "
				+ lightLevel + ", type= " + weaponType +", rarity= "+rarity+", slot= "+slot +"]";
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getLightLevel() {
		return lightLevel;
	}

	public void setLightLevel(int lightLevel) {
		this.lightLevel = lightLevel;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	
	
}
