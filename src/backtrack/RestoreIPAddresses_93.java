package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses_93 {

  // 和131一样，也是切割字符串，然后判断是否valid
  List<String> result = new ArrayList<>();
  LinkedList<String> path = new LinkedList<>();

  public List<String> restoreIpAddresses(String s) {
    if (s.length() > 12) {
      return result;
    }

    backTract(s, 0);
    return result;

  }


  private void backTract(String s, int start) {
    // 终止条件
    // 如果起始位置大于s的大小 并且凑齐了四个整数，说明找到了一组分割方案
    if (start == s.length() && path.size() == 4) {
      result.add(String.join(".", path));
      return;
    }

    if (path.size() > 4 || start > s.length()) {
      return;
    }

    for (int i = start; i < s.length(); i++) {
      String segment = s.substring(start, i + 1);
      if (isValid(segment)) {
        path.add(segment);
        backTract(s, i + 1);
        path.removeLast();
      }

    }

  }

  private boolean isValid(String s) {
    if (s.length() > 3) return false;
    if (s.startsWith("0") && s.length() > 1) return false;
    int value = Integer.parseInt(s);
    return value <= 255;
  }
}
