import java.util.HashMap;

class SolutionZigZag {
  public String convert(String s, int numRows) {
    
    if (numRows == 1) {
      return s;
    }

    HashMap<Coords, String> map = new HashMap<>();
    int numCols = numberOfCols(s.length(), numRows);
    int index = 0;
    for (int x = 0; x < numCols; x++) {
      if (x % 2 == 0) {
        for (int y = 0; y < numRows; y++) {
          if (index != s.length()) {
            map.put(new Coords(x, y), s.substring(index, index + 1));
          } else {
            break;
          }
          index++;
        }
      } else {
        for (int y = numRows; y > 2; y--) {
          if (index != s.length()) {
            map.put(new Coords(x, y - 2), s.substring(index, index + 1));
          } else {
            break;
          }
          index++;
        }
      }
    }
    return print(map, numRows, numCols);
  }

  private int numberOfCols(int len, int numRows) {
    int total = 0;
    int count = 0;
    while (len - total > 0) {
      if (count % 2 == 0) {
        total += numRows;
      } else {
        total += (numRows - 2);
      }
      count++;
    }
    return count;
  }

  private String print(HashMap<Coords, String> map, int numRows, int numCols) {
    String s = "";

    for (int j = 0; j < numRows; j++) {
      for (int i = 0; i < numCols; i++) {
        s += map.getOrDefault((new Coords(i, j)), "");
      }
    }
    return s;
  }
}

class Coords {
  int x;
  int y;

  Coords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "(" + this.x + ", " + this.y + ")";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Coords other = (Coords) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

}


public class ZigZagConversion {
  
  public static void main(String[] args) {
    SolutionZigZag s = new SolutionZigZag();
    System.out.println(s.convert("AB", 1));
  }

}

