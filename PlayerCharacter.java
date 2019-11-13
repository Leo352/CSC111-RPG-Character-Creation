import java.util.*;

public class PlayerCharacter {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Choose your class");
		String selectClass = input.nextLine();
		
		CharacterClassification player;
		
		if(selectClass.equals("barbarian")) {
			player = new Barbarian();
		}
		else {
			System.out.println("You have not chosen a proper class. One will be assigned to you");
			player = new Barbarian();
		}
		
		Dice dice = new Dice();
		abilityScoreModifying modify = new abilityScoreModifying();
		
		String[] a = {"1", "2", "3"};
		removeItem b = new removeItem();
		a = b.removeElements(a, "2");
		System.out.printf("%s %s", a[0], a[1]);
		
		/*int r1 = dice.RollStats();
		int r2 = dice.RollStats();
		int r3 = dice.RollStats();
		int r4 = dice.RollStats();
		int r5 = dice.RollStats();
		int r6 = dice.RollStats();
		
		int[] rolledStats = {r1, r2, r3, r4, r5, r6};
		String[] abilities = {"strength", "dexterity", "constitution", "wisdom", "intelligence", "charisma"};
		
		while(rolledStats.length > 0) {
			System.out.println("Here are your rolls, select what stat you want them in");
			for(int i = 0; i < rolledStats.length; i++) {
				System.out.printf("%d\n", rolledStats[i]);
			}
			
			System.out.println("Please choose one of the following");
			for(int i = 0; i < abilities.length; i++) {
				System.out.printf("%s\n", abilities[i]);
			}
			
			String selectedStat = input.nextLine();
			boolean availableAbility = false;
			
			for(int i = 0; i < abilities.length; i++) {
				if(selectedStat.toLowerCase() == abilities[i]) availableAbility = true;
			}
			
			if(availableAbility) ArrayUtils.remove(abilities);
			
		}*/
		
	}

}
