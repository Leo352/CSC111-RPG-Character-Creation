
public interface CharacterClassification {
	
	public String[] simpleWeaponsList = {"gauntlet", "unarmed strike", "dagger", "dagger, punching", "gauntlet, spiked", "mace, light", "sickle", "club", "mace, heavy", "morningstar", "shortspear", "longspear", "quarterstaff", "spear", "crossbow, heavy", "crossbow, light", "dart", "javelin", "sling"};
	public String[] martialWeaponsList = {"axe, throwing", "hammer. light", "handaxe", "kukri", "pick, light", "sap", "shiled, light", "spiked armor", "spiked shield, light", "sword, short", "battleaxe", "flail", "longsword", "pick, heavy", "rapier", "shield, heavy", "spiked shield, heavy", "trident", "warhammer", "falchion", "glaive", "greataxe", "greatclub", "flail, heavy", "greatsword", "guisarme", "halberd", "lance", "ranseur", "scythe", "longbow", "longbow, composite", "shortbow", "shortbow, composite"};
	public String[] exoticWeaponsList = {"kama", "nunchaku", "sai", "siangham", "sword, bastard", "waraxe, dwarven", "whip", "axe, ord double", "chain, spiked", "flail, dire", "hammer, gnome hooked", "sword, two-bladed", "urgosh, dwarven", "bolas", "crossbow, hand", "crossbow, repeating heavy", "crossbow, repeating light", "net", "shuriken"};
	
	int getClassStatMod(String stat); //TODO figure out what this means
	
	String getClassName();
	
	boolean ableToUseWeapon(String weapon);
	
	boolean ableToUseSpell(String spell);
	
	int getHealth(int conMod);

}
