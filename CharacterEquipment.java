
public interface CharacterEquipment {
	
	String[] weaponList();
	
	String[] equipmentList();
	
	String chooseWeapon(String weapon, String characterClass, String race);
	
	String chooseEquipment(String equipment, String characterClass, String race);

}
