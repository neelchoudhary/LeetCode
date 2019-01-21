import java.util.HashMap;

class SolutionReverseInteger {
	// Solution using HashMaps
	// Time Complexity T(n)
    public int reverse(int x) {
    	HashMap<String, Integer> map = new HashMap<>();
    	
    	map.put("0", 0);
    	map.put("1", 1);
    	map.put("2", 2);
    	map.put("3", 3);
    	map.put("4", 4);
    	map.put("5", 5);
    	map.put("6", 6);
    	map.put("7", 7);
    	map.put("8", 8);
    	map.put("9", 9);

    	String s = Integer.toString(x);
    	
    	if (s.substring(0, 1).equals("-")) {
    		s = s.substring(1);
    	}
    	
    	int sum = 0;
    	for (int i = 0; i < s.length(); i++) {
    		sum += map.get(s.substring(i, i+1)) * Math.pow(10, i);
    	}
    	
		if (sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE+1) {
			return 0;
		}
    	
    	return (0 > x) ? sum*-1 : sum;
    }
}


public class ReverseInteger {
  public static void main(String[] args) {
    SolutionReverseInteger s = new SolutionReverseInteger();
    System.out.println(s.reverse(-34));
    System.out.println(Integer.MIN_VALUE);
  }
}