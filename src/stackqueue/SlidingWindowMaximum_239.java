package stackqueue;

import java.util.ArrayDeque;

public class SlidingWindowMaximum_239 {

  // 时间复杂度太高，leetcode上提交会报错Time Limit Exceeded
  // 暴力解法
  public int[] maxSlidingWindow(int[] nums, int k) {
    int temp = Integer.MIN_VALUE;
    int[] result = new int[nums.length - k + 1];
    int index = 0;

    for (int left = 0; left < nums.length - k + 1; left++) {
      for (int j = 0; j < k; j++) {
        temp = Math.max(temp, nums[left + j]);
      }
      result[index++] = temp;
      temp = Integer.MIN_VALUE;
    }
    return result;
  }

  /**
   * nums = [1, 3, -1, 4, 5, 3, 6, 7] 并且 k = 3
   * 用双端单调递增队列，注意队列存储的是元素的index，这样方便管理窗口的位置
   * 每次先遍历窗口范围内的元素，比如上来看1,3，-1
   * 先把1的index加进队列，再看3。3比1大，所以删除1，把3的index放进队列，再看-1，-1小，所以加在3后面
   * 此时队列里的index应该是1，2，分别代表3，-1。
   * 暂停，把队列第一个元素peek，这个index所代表的元素就是第一个窗口里的最大数字。
   * 第二个窗口现在看到了4, 4比3和-1都大，所以依次把3和-1都删掉，把4的index加进队列。
   * 第二个窗口已满，把队列第一个元素peek，这就是第二个窗口中的最大数。
   */

  public int[] maxSlidingWindow1(int[] nums, int k) {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int n = nums.length;
    int[] res = new int[n - k + 1];
    int idx = 0;
    for(int i = 0; i < n; i++) {
      // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
      // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
      while(!deque.isEmpty() && deque.peek() < i - k + 1){
        deque.poll();
      }
      // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
      while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }

      deque.offer(i);

      // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
      if(i >= k - 1){
        res[idx++] = nums[deque.peek()];
      }
    }
    return res;
  }


}
