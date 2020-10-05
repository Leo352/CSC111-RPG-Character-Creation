import java.util.*;

public class PlayerCharacter {	
	
	public enum CharacterCreation{
		CLASS,
		STATS,
		RACE,
		WEAPONS,
		ARMOR
	}
	
	public static void updateAbilities(chooseAbilityRolls ability, CharacterRace playerRace) {
		abilityScoreModifying modify = new abilityScoreModifying();
		
		ability.strength = ability.strength + playerRace.raceAbilityScoreModifiers("strength");
		ability.strengthMod = modify.Modify(ability.strength);
		
		ability.dexterity = ability.dexterity + playerRace.raceAbilityScoreModifiers("dexterity");
		ability.dexterityMod = modify.Modify(ability.dexterity);
		
		ability.constitution = ability.constitution + playerRace.raceAbilityScoreModifiers("constitution");
		ability.constitutionMod = modify.Modify(ability.constitution);
		
		ability.wisdom = ability.wisdom + playerRace.raceAbilityScoreModifiers("wisdom");
		ability.wisdomMod = modify.Modify(ability.wisdom);
		
		ability.intelligence = ability.intelligence + playerRace.raceAbilityScoreModifiers("intelligence");
		ability.intelligenceMod = modify.Modify(ability.intelligence);
		
		ability.charisma = ability.constitution + playerRace.raceAbilityScoreModifiers("charisma");
		ability.charismaMod = modify.Modify(ability.charisma);
	}

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		CharacterClassification playerClass = null;
		CharacterRace playerRace = null;
		
		String[] abilityString;
		chooseAbilityRolls ability = new chooseAbilityRolls();
		
		
		Dictionary<String, Double> store = new Hashtable<String, Double>();
		
		store.put("nothing", 0.0); store.put("gauntlet", 2.0); store.put("unarmed strike", 0.0); store.put("dagger", 2.0); store.put("dagger, punching", 2.0); store.put("gauntlet, spiked", 5.0);
		store.put("mace, light", 5.0); store.put("sickle", 6.0); store.put("club", 0.0); store.put("mace, heavy", 12.0); store.put("morningstar", 8.0); store.put("longspear", 5.0);
		store.put("quarterstaff", 0.0); store.put("spear", 2.0); store.put("crossbow, heavy", 50.0); store.put("crossbow, light", 35.0); store.put("dart", 0.5); store.put("javelin", 1.0);
		store.put("sling", 0.0);
		
		CharacterCreation[] state = CharacterCreation.values();
		for(CharacterCreation cc : state) {
			switch(cc) {
			case CLASS:
				System.out.println("Choose your class");
				System.out.println("barbarian, paladin, ranger, fighter, or wizard\n");
				String selectClass = input.nextLine().toLowerCase();
				
				if(selectClass.equals("barbarian")) {
					playerClass = new Barbarian();
				}
				else if(selectClass.equals("paladin")) {
					playerClass = new PaladinClass();
				}
				else if(selectClass.equals("ranger")) {
					playerClass = new Ranger();
				}
				else if(selectClass.equals("wizard")) {
					playerClass = new Wizard();
				}
				else if(selectClass.equals("fighter")) {
					playerClass = new Fighter();
				}
				else {
					System.out.println("You have not chosen a proper class. One will be assigned to you\n");
					playerClass = new Fighter();
				}
				
				System.out.printf("Your class is %s\n\n", playerClass.getClassName());
				
				break;
				
			case STATS:
				abilityString = ability.choose();
				System.out.println("\n");
				for(int i = 0; i < 6; i++) {
					System.out.printf("%s\n", abilityString[i]);
				}
				
				break;
				
			case RACE:
				System.out.println("Choose your race");
				System.out.println("Dwarf, Half Elf, or Human\n");
				String selectRace = input.nextLine().toLowerCase();
				
				if(selectRace.equals("dwarf")) {
					playerRace = new Dwarf();
				}
				else if(selectRace.equals("half elf")) {
					playerRace = new HalfElf();
				}
				else if(selectRace.equals("human")) {
					playerRace = new Human();
				}
				else {
					System.out.println("You have not chosen a proper race. One will be assigned to you\n");
					playerRace = new Dwarf();
				}
				
				System.out.printf("Your race is %s\n\n", playerRace.getRaceName());
				
				updateAbilities(ability, playerRace);
				
				System.out.printf("Your health is %d\n", playerClass.getHealth(ability.constitutionMod));
				
				break;
				
			case WEAPONS:
				double playerGold = playerClass.startingGold();

				boolean choosingEquipment = true;
				while(choosingEquipment) {
					boolean cont = false;
					
					System.out.printf("Here's the simple weapons that you can use, please choose one you can afford. Your gold is %.2f\n", playerGold);
					for(int i = 0; i < CharacterClassification.simpleWeaponsList.length; i++) {
						if(playerClass.ableToUseWeapon(CharacterClassification.simpleWeaponsList[i])) System.out.printf("%s\n", CharacterClassification.simpleWeaponsList[i]);
					}
					System.out.println("Type in the simple weapon you would like to use.");
					String userInput = input.nextLine().toLowerCase();
					for(Enumeration<String> i = store.keys(); i.hasMoreElements();) {
						String next = i.nextElement();
						if(next.equals(userInput)){
							System.out.printf(String.format("%s costs %.2f. You have %.2f gold. Will you buy it? Y or N: \n", next, store.get(next), playerGold));
							cont = true;
						}
					}
	
					if(!(cont)) {
						System.out.println("That's not an option.");
					}
						
					while(cont) {
						String userYN = input.nextLine().toLowerCase();
						if(userYN.equals("y") && playerGold >= store.get(userInput)) {
							playerGold -= store.get(userInput);
							System.out.printf("Purchase successful! You now have %.2f gold.\n", playerGold);
							choosingEquipment = false;
							break;
						}
						else if(userYN.equals("n")) {
							System.out.println("Y U NO BUY! GO AWAY GO AWAY IF NO BUY!");
							choosingEquipment = false;
							break;
						}
						else {
							System.out.println("Invalid response");
						}		
					}
				}
				break;

			case ARMOR:
				///////////////////////////////////
				//Need to make a store for armors//
				///////////////////////////////////

				boolean choosingEquipment = true;
				while(choosingEquipment) {
					boolean cont = false;
					
					System.out.printf("Here's the light armors that you can use, please choose one you can afford. Your gold is %.2f\n", playerGold);
					for(int i = 0; i < CharacterClassification.lightArmorList.length; i++) {
						if(playerClass.ableToUseWeapon(CharacterClassification.lightArmorList[i])) System.out.printf("%s\n", CharacterClassification.lightArmorList[i]);
					}
					System.out.println("Try buying a guantlet. Type \"guantlet\" and see if you can afford it.");
					String userInput = input.nextLine().toLowerCase();
					for(Enumeration<String> i = store.keys(); i.hasMoreElements();) {
						String next = i.nextElement();
						if(next.equals(userInput)){
							System.out.printf(String.format("%s costs %.2f. You have %.2f gold. Will you buy it? Y or N: \n", next, store.get(next), playerGold));
							cont = true;
						}
					}
	
					if(!(cont)) {
						System.out.println("You cannot buy that.");
					}
						
					while(cont) {
						String userYN = input.nextLine().toLowerCase();
						if(userYN.equals("y")) {
							playerGold -= store.get(userInput);
							System.out.printf("Purchase successful! You now have %.2f gold.\n", playerGold);
							choosingEquipment = false;
							break;
						}
						else if(userYN.equals("n")) {
							System.out.println("Y U NO BUY! GO AWAY GO AWAY IF NO BUY!");
							choosingEquipment = false;
							break;
						}
						else {
							System.out.println("Invalid response");
						}		
					}
				}
				break;
			}
		}		
	}		
}
