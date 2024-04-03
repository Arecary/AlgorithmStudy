package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning_131 {

  // 如何判断是不是回文
  // 可以使用双指针法，一个指针从前向后，一个指针从后向前，如果前后指针所指向的元素是相等的，就是回文字符串了。

  List<List<String>> result = new ArrayList<>();
  LinkedList<String> path = new LinkedList<>();

  public List<List<String>> partition(String s) {

    backtrack(s, 0);
    return result;
  }

  private void backtrack(String s, int startIndex) {
    // 终止条件
    // 如果起始位置大于s的大小，说明找到了一组分割方案
    if (startIndex >= s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int i = startIndex; i < s.length(); i++) {
      // 判断s[startIndex, i]是不是回文
      if (isPalindrome(s, startIndex, i)) {
        path.add(s.substring(startIndex, i + 1));
        backtrack(s, i + 1);
        path.removeLast();
      } else {
        continue;
      }

    }

  }

  private boolean isPalindrome(String s, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
