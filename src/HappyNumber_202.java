import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {


  public static void main(String[] args) {
    int input = 19;
    System.out.println(isHappy(input)); // Output: true
  }

  static public boolean isHappy(int n) {
    Set<Integer> sumSet = new HashSet<>();
    int sum = n;

    while (sum != 1) {
      int temp = sum;
      sum = 0;
      while (temp > 0){
        int digit = temp % 10;
        temp = temp / 10;
        sum = sum + digit * digit;

      }

      if (sumSet.contains(sum)){
        return false;
      }
      sumSet.add(sum);


    }

    return true;

  }







  // solution
  public boolean isHappy1(int n) {
    Set<Integer> record = new HashSet<>();
    while (n != 1 && !record.contains(n)) {
      record.add(n);
      n = getNextNumber(n);
    }
    return n == 1;
  }

  private int getNextNumber(int n) {
    int res = 0;
    while (n > 0) {
      int temp = n % 10;
      res += temp * temp;
      n = n / 10;
    }
    return res;
  }
}
