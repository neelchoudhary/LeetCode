import java.util.HashMap;

class SolutionPalindromeNumber {
  // Time Complexity T(n)
  public boolean isPalindrome(int x) {
    
    if (x < 0) {
      return false;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    while (x != 0) {
      map.put(count, x % 10);
      x = x / 10;
      count++;
    }

    for (int i = 0; i < map.size() / 2; i++) {
      int j = map.size() - 1 - i;
      if (map.get(i) != map.get(j)) {
        return false;
      }
    }
    return true;
  }

}


public class PalindromeNumber {

  public static void main(String[] args) {
    SolutionPalindromeNumber s = new SolutionPalindromeNumber();
    System.out.println(s.isPalindrome(1001));
    System.out.println(s.isPalindrome(43234));
    System.out.println(s.isPalindrome(-121));
    System.out.println(s.isPalindrome(0));
  }

}

