package stackqueue;

import com.sun.source.tree.CaseTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation_150 {


  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    int result = 0;
    for (String curr : tokens) {
      if (curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {

        switch (curr) {
          case "+" -> {
            result = stack.pop() + stack.pop();
            stack.push(result);
          }
          case "-" -> {
            int subtrahend = stack.pop();
            int minuend = stack.pop();
            result = minuend - subtrahend;
            stack.push(result);
          }
          case "*" -> {
            result = stack.pop() * stack.pop();
            stack.push(result);
          }
          case "/" -> {
            int divisor = stack.pop();
            int dividend = stack.pop();
            result = dividend / divisor;
            stack.push(result);
          }
        }

      } else {
        stack.push(Integer.valueOf(curr));
      }
    }
    return stack.pop();

  }


  // 简化版
  public int evalRPN1(String[] tokens) {
    Deque<Integer> stack = new LinkedList();
    for (String s : tokens) {
      if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
        stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
      } else if ("-".equals(s)) {
        stack.push(-stack.pop() + stack.pop());
      } else if ("*".equals(s)) {
        stack.push(stack.pop() * stack.pop());
      } else if ("/".equals(s)) {
        int temp1 = stack.pop();
        int temp2 = stack.pop();
        stack.push(temp2 / temp1);
      } else {
        stack.push(Integer.valueOf(s));
      }
    }
    return stack.pop();
  }


}
