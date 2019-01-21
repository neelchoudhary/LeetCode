
class SolutionContainer {

  // Solution using two pointers
  // Time Complexity T(n)
  
  public int maxArea(int[] height) {

    int left = 0;
    int right = height.length-1;
    int largestArea = 0;

    for (int i = 0; i < height.length; i++) {
      int currArea = Math.min(height[left], height[right]) * (right - left);
      largestArea = Math.max(currArea, largestArea);
      if (height[right] < height[left]) {
        right--;
      } else {
        left++;
      }
    }
    return largestArea;
  }
}


public class Container {

  public static void main(String[] args) {
    SolutionContainer s = new SolutionContainer();
    System.out.println(s.maxArea(new int[] {2,3,4,5,18,17,6}));
  }

}
