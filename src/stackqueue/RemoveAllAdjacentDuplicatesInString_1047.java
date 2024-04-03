package stackqueue;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {


  public String removeDuplicates(String s) {

    Stack<Character> stack = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      char pre = (!stack.isEmpty()) ? stack.peek() : '#';
      if (cur == pre) {
        stack.pop();
      }else {
        stack.push(cur);
      }
    }
    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }
    return stringBuilder.reverse().toString(); // 注意：reverse
  }


  // 拿字符串直接作为栈，省去了栈还要转为字符串的操作。
  public String removeDuplicates1(String s) {
    // 将 res 当做栈
    // 也可以用 StringBuilder 来修改字符串，速度更快
    // StringBuilder res = new StringBuilder();
    StringBuffer res = new StringBuffer();
    // top为 res 的长度
    int top = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
      if (top >= 0 && res.charAt(top) == c) {
        res.deleteCharAt(top);
        top--;
        // 否则，将该字符 入栈，同时top++
      } else {
        res.append(c);
        top++;
      }
    }
    return res.toString();
  }
}
