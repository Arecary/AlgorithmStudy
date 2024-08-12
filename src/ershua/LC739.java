package ershua;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC739 {

  public int[] dailyTemperatures(int[] temperatures) {

    int[] res = new int[temperatures.length];
    Deque<Integer> monoStack = new ArrayDeque<>();
    int days = 0;
    monoStack.push(0);
    for (int i = 1; i < temperatures.length; i++) {
      if (temperatures[i] < temperatures[monoStack.peek()]) {
        monoStack.push(i);
      }else {
        while (!monoStack.isEmpty()&&temperatures[i]>temperatures[monoStack.peek()]){
          res[monoStack.peek()]=i-monoStack.peek();
          monoStack.pop();
        }
      }
      monoStack.push(i);
    }
    return res;
  }



  public int[] dailyTemperatures1(int[] temperatures) {

    int[] res = new int[temperatures.length];
    Stack<Integer> increaseStack = new Stack<>();
    increaseStack.push(0);

    for (int i = 1; i < temperatures.length; i++) {
      int current = temperatures[i];
      while (!increaseStack.isEmpty()) {
        int top = increaseStack.pop();
        if (current > temperatures[top]) {
          res[top] = i - top;
        }else {
          increaseStack.push(top);
          break;
        }
      }
      increaseStack.push(i);
    }
    return res;
  }
}
