package greedy;

public class MonotoneIncreasingDigits_738 {


  // 从后向前遍历，凡是前一个比后一个大的，就把前一位减一，同时后一位变成9，比如352此时变成349
  // 再往前遍历
  public int monotoneIncreasingDigits(int n) {
    String s = String.valueOf(n);
    char[] chars = s.toCharArray();
    int start = s.length(); // 初始化成s.length()是防止原n不用变化，这样下面的for循环就不会执行
    for (int i = s.length() - 2; i >= 0; i--) {
      if (chars[i] > chars[i + 1]) {
        chars[i]--;
        start = i+1;
      }
    }
    // 这里的start是一个标记，表示index = start后面的数字都变成9
    for (int i = start; i < s.length(); i++) {
      chars[i] = '9';
    }
    return Integer.parseInt(String.valueOf(chars));
  }
}
