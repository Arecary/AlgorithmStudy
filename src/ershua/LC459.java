package ershua;

public class LC459 {

  public static void main(String[] args) {
    String s = "aabaaba";
    System.out.println(repeatedSubstringPattern(s));
  }

  // "abab"
  public static boolean repeatedSubstringPattern(String s) {

    if (s == null || s.isEmpty()) {
      return false;
    }

    for (int i = 0; i < s.length() / 2; i++) {
      boolean flag = true;
      String sub = s.substring(0, i + 1);
      int len = i + 1;
      int a = 0;
      int b = a + len;

      if (s.length() / b != 0) {
        continue;
      }

      while (b <= s.length()) {
        String compare = s.substring(a, b);
        if (!sub.equals(compare)) {
          flag = false;
          break;
        }
        a += len;
        b += len;
      }

      if (flag) {
        return true;
      }
    }
    return false;
  }


}
