
public class abilityScoreModifying {

	public int Modify(int ability) {
		if(ability % 2 != 0) ability--;
		ability -= 10;
		int modifier = ability/2;
		
		return modifier;
		
	}
	
}
