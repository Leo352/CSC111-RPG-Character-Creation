
public class removeItem {
	
	public String[] removeElements(String[] input, String deleteMe) {
		
		String[] result = new String[input.length - 1];
		int j = 0;
		
		for(int i = 0; i < (input.length - 1); i++) {
			if(!(input[j].equals(deleteMe))) {
				result[i] = input[j];
				j++;
			}
			else {
				j++;
				result[i] = input[j];
				j++;
			}
		}
		
		
		return result;
	}

}