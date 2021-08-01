package armor.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Armor {
	/*
	 * Correspond to the user table
	 */
	
	private String armorName;
	private int lightLevel;
	private String armorType;
	private String rarity;
	private String slot;
	private int id;

	@Override
	public String toString() {
		return "Armor [ name= " + armorName + ", id= " + id + ", light level= "
				+ lightLevel + ", type= " + armorType +", rarity= "+rarity+", slot= "+slot +"]";
	}

	public String getArmorName() {
		return armorName;
	}

	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}

	public int getLightLevel() {
		return lightLevel;
	}

	public void setLightLevel(int lightLevel) {
		this.lightLevel = lightLevel;
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

	public String getArmorType() {
		return armorType;
	}

	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}
	

	
	
}
