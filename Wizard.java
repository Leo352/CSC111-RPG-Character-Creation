

public class Wizard implements CharacterClassification {
	
	public String[] wizardWeapons= {"club", "dagger", "crossbow, heavy", "crossbow, light", "quarterstaff"};
	public String[] wizardSpells = {"resistance", "acid splash", "detect poison", "detect magic", "read magic", "daze", "dancing lights", "flare", "light", "ray of frost", "ghost sound", "disrupt undead", "touch of fatigue", "mage hand", "mending", "message", "open/close", "arcane mark", "prestidigitation",
			"alarm", "endure elements", "hold portal", "protection from chaos", "protection from evil", "protection from good", "protection from law", "shield", "grease", "mage armor", "mount", "obscuring mist", "summon monster I", "unseen servant", "comprehend languages", "detect secret doors", "detect undead", "identify", "true strike", "charm person", "hypnotism", "sleep", "burning hands", "magic missile", "shocking grasp", "tenser's floating disk", "color spray", "disguise self", "nystul's magic aura", "silent image", "ventriloquism", "cause fear", "chill touch", "ray of enfeeblement", "animate rope", "enlarge person", "erase", "expeditious retreat", "feather fall", "jump", "magic weapon", "reduce person"};
	
	Dice dice = new Dice();
	public int health = dice.RollD4();

	@Override
	public int getClassStatMod(String stat) {
		return 0;
	}

	@Override
	public String getClassName() {
		return "Wizard";
	}

	@Override
	public boolean ableToUseWeapon(String weapon) {
		boolean usableWeapon = false;
		for(int i = 0; i < wizardWeapons.length; i++) {
			if(wizardWeapons[i] == weapon.toLowerCase()) usableWeapon = true;
		}
		
		if(usableWeapon) return true;
		else return false;
	}

	@Override
	public boolean ableToUseSpell(String spell) {
		boolean usableSpell = false;
		for(int i = 0; i < wizardSpells.length; i++) {
			if(wizardSpells[i] == spell.toLowerCase()) usableSpell = true;
		}
		
		if(usableSpell) return true;
		else return false;
	}
	
	public int getHealth(int conMod) {
		int health2 = health + conMod;
		
		return health2;
	}
	
	public int startingGold() {
		int gold = (dice.RollD4() + dice.RollD4() + dice.RollD4())*10;
		return gold;
	}

}



