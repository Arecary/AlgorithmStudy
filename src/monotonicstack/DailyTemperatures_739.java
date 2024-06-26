package monotonicstack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures_739 {

  public int[] dailyTemperatures(int[] temperatures) {

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


  public int[] dailyTemperatures2(int[] temperatures) {

    int lens=temperatures.length;
    int []res=new int[lens];

    /**
     如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
     所以弹出 栈顶元素，并记录
     如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
     否则的话，可以直接入栈。
     注意，单调栈里 加入的元素是 下标。
     */
    Deque<Integer> stack=new LinkedList<>();
    stack.push(0);
    for(int i=1;i<lens;i++){

      if(temperatures[i]<=temperatures[stack.peek()]){
        stack.push(i);
      }else{
        while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
          res[stack.peek()]=i-stack.peek();
          stack.pop();
        }
        stack.push(i);
      }
    }

    return  res;
  }


}
