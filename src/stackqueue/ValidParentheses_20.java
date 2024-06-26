package stackqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses_20 {


  public boolean isValid(String s) {
    Stack<Character> deque = new Stack<>();
    char ch;
    for (int i = 0; i < s.length(); i++) {
      ch = s.charAt(i);
      //碰到左括号，就把相应的右括号入栈
      if (ch == '(') {
        deque.push(')');
      }else if (ch == '{') {
        deque.push('}');
      }else if (ch == '[') {
        deque.push(']');
      } else if (deque.isEmpty() || deque.peek() != ch) {
        return false;
      }else {//如果是右括号判断是否和栈顶元素匹配
        deque.pop();
      }
    }
    //最后判断栈中元素是否匹配
    return deque.isEmpty();
  }


}
