package ershua;

public class LC541 {

  public static void main(String[] args) {
    String s = "abcdefg";
    int k = 8;

    System.out.println(reverseStr(s,k));
  }

  // Input: s = "abcdefg", k = 2
  // Output: "bacdfeg"
  public static String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    int right = 0;
    for (int i = 0; i < chars.length; i = i + 2 * k) {
      right = i + k - 1;
      if (right > chars.length - 1 ) {
        right = chars.length - 1;
        for (int j = i; j < chars.length; j++) {
          if (j > right) {
            break;
          }
          char temp = chars[j];
          chars[j] = chars[right];
          chars[right] = temp;
          right--;
        }
        break;
      }

      for (int j = i; j < i + (k / 2); j++) {
        char temp = chars[j];
        chars[j] = chars[right];
        chars[right] = temp;
        right--;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : chars) {
      sb.append(c);
    }
    return sb.toString();
  }


  public String reverseStr1(String s, int k) {
    char[] chars = s.toCharArray();
    int n = chars.length;

    for (int i = 0; i < n; i += 2 * k) {
      int left = i;
      int right = Math.min(i + k - 1, n - 1);
      while (left < right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
      }
    }

    return new String(chars);
  }

}
