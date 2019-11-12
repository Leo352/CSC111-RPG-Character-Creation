
public class PlayerCharacter {
	public static void main(String[] args) {
		
		Barbarian player = new Barbarian();
		Dice dice = new Dice();
		abilityScoreModifying modify = new abilityScoreModifying();
		
		int str = dice.RollStats();
		int dex = dice.RollStats();
		int con = dice.RollStats();
		int wis = dice.RollStats();
		int int_ = dice.RollStats();
		int cha = dice.RollStats();
		
		int strMod = modify.Modify(str);
		int dexMod = modify.Modify(dex);
		int conMod = modify.Modify(con);
		int wisMod = modify.Modify(wis);
		int int_Mod = modify.Modify(int_);
		int chaMod = modify.Modify(cha);
		
		System.out.println(con);
		System.out.println(conMod);
		System.out.println(player.getHealth(conMod));
		
	}

}
