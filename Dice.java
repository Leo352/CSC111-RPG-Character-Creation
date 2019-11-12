
public class Dice implements Rolls {

	@Override
	public int RollD4() {
		int d4 = (int)(Math.random() * 4) + 1;
		return d4;
	}

	@Override
	public int RollD6() {
		int d6 = (int)(Math.random() * 6) + 1;
		return d6;
	}

	@Override
	public int RollD8() {
		int d8 = (int)(Math.random() * 8) + 1;
		return d8;
	}

	@Override
	public int RollD10() {
		int d10 = (int)(Math.random() * 10) + 1;
		return d10;
	}

	@Override
	public int RollD12() {
		int d12 = (int)(Math.random() * 12) + 1;
		return d12;
	}

	@Override
	public int RollStats() {
		int stats1 = (int)(Math.random() * 6) + 1;
		int stats2 = (int)(Math.random() * 6) + 1;
		int stats3 = (int)(Math.random() * 6) + 1;
		int stats4 = (int)(Math.random() * 6) + 1;
		
		int[] rolledStats = {stats1, stats2, stats3, stats4};
		int preAdjustedTotal = stats1 + stats2 + stats3 + stats4;
		int smallest = Integer.MAX_VALUE;
		
		//credit to https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
		for(int i = 0; i < 4; i++) {
			if(rolledStats[i] < smallest) smallest = rolledStats[i];
		}
		
		int stats = preAdjustedTotal - smallest;
		
		return stats;
	}

}
