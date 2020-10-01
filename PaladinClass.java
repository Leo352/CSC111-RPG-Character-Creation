
public class PaladinClass implements CharacterClassification {
	Dice dice = new Dice();
	public int health = dice.RollD10();
	
	public String[] paladinSpells = {"bless", "bless water", "bless weapon", "create water", "cure light wounds", "detect poison", "detect undead", "divine favor", "endure elements", "magic weapon", "protection from chaos", "protection from evil", "read magic", "resistance", "restoration, lesser", "virtue"};
	
	@Override
	public int getClassStatMod(String stat) {
		return 0;
	}

	@Override
	public String getClassName() {
		return "Paladin";
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
		for(int i = 0; i < paladinSpells.length; i++) {
			if(paladinSpells[i] == spell.toLowerCase()) usableSpell = true;
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
