
public class Barbarian implements CharacterClassification {

	@Override
	public int getClassStatMod(String stat) {
		return 0;
	}

	@Override
	public String getClassName() {
		return "Barbarian";
	}

	@Override
	public boolean ableToUseWeapon(String weapon) {
		boolean usableWeapon = false;
		for(int i = 0; i < CharacterClassification.simpleWeaponsList.length; i++) {
			if(CharacterClassification.simpleWeaponsList[i] == weapon.toLowerCase()) usableWeapon = true;
		}
		
		for(int i = 0; i < CharacterClassification.martialWeaponsList.length; i++) {
			if(CharacterClassification.martialWeaponsList[i] == weapon.toLowerCase()) usableWeapon = true;
		}
		
		if(usableWeapon) return true;
		else return false;
	}

	@Override
	public boolean ableToUseSpell(String spell) {
		return false;
	}
	
	public int getHealth(int conMod) {
		Dice healthRoll = new Dice();
		int health = healthRoll.RollD12() + conMod;
		
		return health;
	}

}
