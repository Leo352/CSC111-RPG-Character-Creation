
public class removeItem {
	
	public String[] removeString(String[] input, String deleteMe) {
		
		String[] result = new String[input.length - 1];
		int j = 0;
		
		for(int i = 0; i < (input.length - 1); i++) {
			if(!(input[j].equals(deleteMe))) {
				result[i] = input[j];
			}
			else {
				j++;
				result[i] = input[j];
			}
			j++;
		}
		
		
		return result;
	}
	
	public int[] removeInt(int[] input, int deleteMe) {
		
		int[] result = new int[input.length - 1];
		int j = 0;
		boolean deleted = false;
		
		for(int i = 0; i < (input.length - 1); i++) {
			if(!(input[j] == deleteMe)) {
				result[i] = input[j];
			}
			else if(!(deleted)){
				j++;
				result[i] = input[j];
				deleted = true;
			}
			else {
				result[i] = input[j];
			}
			j++;
		}
		
		
		return result;
	}

}