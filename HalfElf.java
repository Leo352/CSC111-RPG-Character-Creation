
public class HalfElf implements CharacterRace{

	@Override
	public String getRaceName() {
		return "Half-Elf";
	}


	public boolean ableToUseWeapon(String weapon) {
		boolean usableWeapon = false;
		if(usableWeapon) return true;
		else return false;
	}


	public boolean ableToUseSpell(String spell) {
		return false;
	}

	@Override
	public int getRaceStatModifiers(String stat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int raceAbilityScoreModifiers(String stat) {
		// TODO Auto-generated method stub
		return 0;
	}


}

