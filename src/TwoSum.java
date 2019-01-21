import java.util.HashMap;

class SolutionTwoSum {
	// Solution using a HashMap.
	// Time Complexity: T(n)
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < nums.length; i++) {
    		map.put(nums[i], i);
    	}
    	
    	for (int j = 0; j < map.size(); j++) {
    		if (map.containsKey(target - nums[j]) && j != map.get(target-nums[j])) {
    			return new int[] {j, map.get(target-nums[j])};
    		}
    	}
    	return new int[] {0, 0};
    }
}


public class TwoSum {
  public static void main(String[] args) {
    SolutionTwoSum s = new SolutionTwoSum();
    for (int i = 0; i < 2; i++) {
      System.out.print(s.twoSum(new int[] {2, 7, 11, 15}, 9)[i] + ", ");
    }
  }
}
