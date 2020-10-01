
public class Dwarf implements CharacterRace {

	@Override
	public String getRaceName() {
		return "Dwarf";
	}

	@Override
	public int getRaceStatModifiers(String stat) {

		return 0;
	}

	@Override
	public int raceAbilityScoreModifiers(String stat) {
		if(stat.equals("constitution")) return 2;
		else if(stat.equals("charisma")) return -2;
		else return 0;
	}

}
