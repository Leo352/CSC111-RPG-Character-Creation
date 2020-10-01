import java.util.*;
import java.lang.*;

public class chooseAbilityRolls {
	
	public int strength;
	public int dexterity;
	public int constitution;
	public int wisdom;
	public int intelligence;
	public int charisma;
	
	public int strengthMod;
	public int dexterityMod;
	public int constitutionMod;
	public int wisdomMod;
	public int intelligenceMod;
	public int charismaMod;

	public String[] choose() {
	
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	
	
		Dice dice = new Dice();
		abilityScoreModifying modify = new abilityScoreModifying();
		removeItem remove = new removeItem();
	
		int r1 = dice.RollStats();
		int r2 = dice.RollStats();
		int r3 = dice.RollStats();
		int r4 = dice.RollStats();
		int r5 = dice.RollStats();
		int r6 = dice.RollStats();
		
	
		int[] rolledStats = {r1, r2, r3, r4, r5, r6};
		String[] abilities = {"strength", "dexterity", "constitution", "wisdom", "intelligence", "charisma"};
		String[] abilitiesMatchedWithRolls = new String[6];
		int AMWR = 0;
	
		while(rolledStats.length > 0) {
			boolean availableRoll = false;
			boolean availableAbility = false;
			
			System.out.println("Here are your rolls, select what stat you want them in:");
			for(int i = 0; i < rolledStats.length; i++) {
				System.out.printf("%d\n", rolledStats[i]);
			}
		
			System.out.println("\nPlease choose one of the following");
			for(int i = 0; i < abilities.length; i++) {
				System.out.printf("%s\n", abilities[i]);
			}
		
			String selectedStat = input.nextLine();

		
			for(int i = 0; i < abilities.length; i++) {
				if(selectedStat.toLowerCase().equals(abilities[i])) availableAbility = true;
			}
		
			if(availableAbility) {
				abilities = remove.removeString(abilities, selectedStat);
				System.out.println("\nWhat roll would you like to select for this stat?");
				int selectedRoll = input.nextInt();

			
				for(int i = 0; i < rolledStats.length; i++) {
					if(selectedRoll == rolledStats[i]) availableRoll = true;
				}
			
				if(availableRoll) {
					rolledStats = remove.removeInt(rolledStats,  selectedRoll);
					System.out.printf("%s will be %d\n", selectedStat, selectedRoll);
					abilitiesMatchedWithRolls[AMWR] = String.format("%s is %d\n", selectedStat, selectedRoll);
					AMWR++;
					
					if(selectedStat.equals("strength")) strength = selectedRoll;
					if(selectedStat.equals("dexterity")) dexterity = selectedRoll;
					if(selectedStat.equals("constitution")) constitution = selectedRoll;
					if(selectedStat.equals("wisdom")) wisdom = selectedRoll;
					if(selectedStat.equals("intelligence")) intelligence = selectedRoll;
					if(selectedStat.equals("charisma")) charisma = selectedRoll;
					
				}
				else {
					abilities = Arrays.copyOf(abilities, abilities.length + 1);
					abilities[abilities.length - 1] = selectedStat;
				}
			}
		
		}
		strengthMod = modify.Modify(strength);
		dexterityMod = modify.Modify(dexterity);
		constitutionMod = modify.Modify(constitution);
		wisdomMod = modify.Modify(wisdom);
		intelligenceMod = modify.Modify(intelligence);
		charismaMod = modify.Modify(charisma);
		
		return abilitiesMatchedWithRolls;
	}
}