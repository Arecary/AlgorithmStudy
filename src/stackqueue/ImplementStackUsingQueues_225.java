package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {


  static class MyStack {
    Queue<Integer> inQueue;
    Queue<Integer> outQueue;

    public MyStack() {
      inQueue = new LinkedList<>();
      outQueue = new LinkedList<>();
    }

    public void push(int x) {
      inQueue.add(x);

    }

    // 通过交换两个Queue的地址从而减少了一次移动，和top方法形成一个对比
    public int pop() {
      while (inQueue.size() > 1) {
        outQueue.add(inQueue.poll());
      }
      int res = inQueue.poll(); // 获取并移除inQueue中最后一个元素
      Queue<Integer> temp = inQueue; // 交换inQueue和outQueue
      inQueue = outQueue;
      outQueue = temp;
      return res;
    }

    public int top() {
      while (inQueue.size() > 1) {
        outQueue.add(inQueue.poll());
      }
      int res = inQueue.poll();
      outQueue.add(res);
      while (!outQueue.isEmpty()) {
        inQueue.add(outQueue.poll());
      }

      return res;
    }

    public boolean empty() {
      return inQueue.isEmpty();
    }
  }





  // 最好的方法
  // 入栈 (push)
  //
  //将新元素 x 放入 queue2。
  //将 queue1 中的所有元素出队（poll），并依次放入 queue2。这个步骤实际上是将 queue1 中的元素倒序放入 queue2。
  //交换 queue1 和 queue2 的引用。这样，queue1 现在包含了所有元素，且最新添加的元素在队列的前端，符合栈的后进先出特性。
  //
  // 这种实现方式下，push 操作的时间复杂度是 O(n)，因为它涉及将 queue1 中的所有元素移动到 queue2，
  // 然后再将它们移回 queue1。而 pop、top 和 empty 操作的时间复杂度是 O(1)，因为它们只涉及对 queue1 的简单操作。
  static class MyStack2 {

    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列

    /** Initialize your data structure here. */
    public MyStack2() {
      queue1 = new LinkedList<>();
      queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      queue2.offer(x); // 先放在辅助队列中
      while (!queue1.isEmpty()){
        queue2.offer(queue1.poll());
      }
      Queue<Integer> queueTemp;
      queueTemp = queue1;
      queue1 = queue2;
      queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    /** Get the top element. */
    public int top() {
      return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return queue1.isEmpty();
    }
  }
}
