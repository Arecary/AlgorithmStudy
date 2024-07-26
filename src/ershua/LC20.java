package ershua;

import java.util.Stack;

public class LC20 {


  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }

    char [] record = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    stack.push(record[0]);

    for (int i = 1; i < s.length(); i++) {
      char curr = record[i];
      if (curr == '(' || curr == '[' || curr == '{') {
        stack.push(curr);
      }else {
        if (!stack.isEmpty()) {
          return false;
        }
        char c = stack.pop();
        if (c == '(' && curr != ')') {
          return false;
        } else if (c == '[' && curr != ']') {
          return false;
        } else if (c == '{' && curr != '}') {
          return false;
        } else if (c == ')' || c == ']' || c == '}') {
          return false;
        }
      }
    }

    if (stack.isEmpty()) {
      return true;
    }else {
      return false;
    }

  }


}
