package ershua;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LC150 {


  public int evalRPN(String[] tokens) {

    if (tokens == null || tokens.length == 0) {
      return 0;
    }

    ArrayList<String> notation = new ArrayList<>();
    notation.add("+");
    notation.add("-");
    notation.add("*");
    notation.add("/");

    Deque<String> stack = new ArrayDeque<>();
    for (String s : tokens) {
      if (!notation.contains(s)) {
        stack.push(s);
      }else {
        int second = Integer.parseInt(stack.pop());
        int first = Integer.parseInt(stack.pop());
        int res = switch (s) {
          case "+" -> first + second;
          case "-" -> first - second;
          case "*" -> first * second;
          case "/" -> first / second;
          default -> 0;
        };
        stack.push(Integer.toString(res));
      }
    }

    return Integer.parseInt(stack.pop());
  }



}
