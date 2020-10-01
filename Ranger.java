
public class Ranger implements CharacterClassification {
	
	Dice dice = new Dice();
	public int health = dice.RollD8();
	
	public String[] rangerSpells = {"alarm", "animal messanger", "calm animals", "charm animal", "delay poison", "detect animals or plants", "detect poison", "detect snares and pits", "endure elements", "entagle", "hide from animals", "jump", "longstrider", "magic fang", "pass without trace", "read magic", "resist energy", "speak with animals", "summon nature's ally"};
	
	@Override
	public int getClassStatMod(String stat) {
		return 0;
	}

	@Override
	public String getClassName() {
		return "Ranger";
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
		boolean usableSpell = false;
		for(int i = 0; i < rangerSpells.length; i++) {
			if(rangerSpells[i] == spell.toLowerCase()) usableSpell = true;
		}
		
		if(usableSpell) return true;
		else return false;
	}
	
	public int getHealth(int conMod) {
		int health2 = health + conMod;
		
		return health2;
	}
	
	public int startingGold() {
		int gold = (dice.RollD4() + dice.RollD4() + dice.RollD4() + dice.RollD4() + dice.RollD4() + dice.RollD4())*10;
		return gold;
	}

}
