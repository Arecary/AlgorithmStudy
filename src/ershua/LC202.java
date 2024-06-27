package ershua;

import java.util.HashSet;

public class LC202 {

  public static void main(String[] args) {
    System.out.println(isHappy(19));
  }

  public static boolean isHappy(int n) {
    HashSet<Integer> record = new HashSet<>();

    while (n != 1) {
      int sum = 0;
      while (n != 0) {
        int i = n % 10;
        n = n / 10;
        sum = sum + i * i;
      }

      if (record.contains(sum)) {
        return false;
      }else {
        record.add(sum);
      }
      n = sum;
    }

    return true;
  }


}
