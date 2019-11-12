
public interface CharacterRace {
	
	String getRaceName();
	
	int getRaceStatModifiers(String stat);
	
	int raceAbilityScoreModifiers(String stat);
}
