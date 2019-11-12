import java.util.*;

public class removeItem {
	
	public String[] removeElements(String[] input, String deleteMe) {
		
		String[] result = new String[input.length - 1];
		
		for(int i = 0; i < input.length; i++) {
			if(!(input[i].equals(deleteMe))) {
				result[i] = input[i];
			}
			else {
				i++;
				result[i-1] = input[i];
			}
		}
		
		
		return result;
	}

}
