package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

  public static void main(String[] args) {
    MyQueue mq = new MyQueue();
    mq.push(1);
    mq.push(2);
    mq.push(3);
    mq.push(4);
    mq.printString();
//    System.out.println(mq.toString());
//    System.out.println(mq.peek());
//    System.out.println(mq.toString());
//    System.out.println(mq.pop());


  }


  // 常规方法，很繁琐
  // 第二个办法，建立两个stack, 互相倒买倒卖。比如stack1是1,2,3,4 那么stack2.push(stack1.pop()) 就变成了4,3,2,1
  static class MyQueue {

    final Stack<Integer> stack;

    public MyQueue() {
      stack = new Stack<>();
    }

    public void push(int x) {
      stack.push(x);
    }

    public int pop() {
      int size = stack.size();
      int result = 0;
      int[] temp = new int[size - 1];
      for (int i = 0; i < size; i++) {
        if (i < size - 1) {
          temp[i] = stack.pop();
        }
        if (i == size - 1) {
          result = stack.pop();
        }
      }

      for (int i = temp.length - 1; i >= 0; i--) {
        stack.push(temp[i]);
      }

      return result;
    }

    public int peek() {
      int size = stack.size();
      int result = 0;
      int[] temp = new int[size];
      for (int i = 0; i < size; i++) {
        if (i < size - 1) {
          temp[i] = stack.pop();
        }
        if (i == size - 1) {
          result = stack.pop();
          temp[i] = result;
        }
      }

      for (int i = temp.length - 1; i >= 0; i--) {
        stack.push(temp[i]);
      }
      return result;
    }

    public boolean empty() {
      return stack.isEmpty();
    }

    public void printString(){
      System.out.println(stack.toString());
    }

    @Override
    public String toString() {
      int size = stack.size();
      int[] al  = new int[size];
      System.out.println("size: "+ size);
      int[] tempList = new int[size];
      for (int i = 0; i < size; i++) {
        int temp = this.pop();
        tempList[i] = temp;
        al[size - i - 1] =  temp;
      }

      for (int i = 0; i < tempList.length; i++) {
        stack.push(tempList[i]);
      }

      return Arrays.toString(al);
    }
  }


}
