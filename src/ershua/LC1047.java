package ershua;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC1047 {



  public String removeDuplicates(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }

    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!stack.isEmpty()) {
        char pre = stack.peek();
        if (pre == c) {
          stack.pop();
          continue;
        }
      }
      stack.push(c);
    }

    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()) {
      res.append(stack.pop());
    }

    return res.reverse().toString();
  }


}
