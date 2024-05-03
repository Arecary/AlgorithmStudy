package monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {


  // 方法1：把数组复制一遍，然后从后往前遍历，找到每个元素右边第一个比它大的元素，并记录下来
  public int[] nextGreaterElements(int[] nums) {
    // 复制数组
    int length = nums.length * 2;
    int[] target = new int[length];
    System.arraycopy(nums, 0, target, 0, nums.length);
    System.arraycopy(nums, 0, target, nums.length, nums.length);

    // 单调栈解题
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[length];
    Arrays.fill(res, -1);
    stack.push(0);

    for (int i = 1; i < length; i++) {
      if (target[i] <= target[stack.peek()]) {
        stack.push(i);
      } else {
        while (!stack.isEmpty() && target[i] > target[stack.peek()]) {
          res[stack.pop()] = target[i];
        }
        stack.push(i);
      }
    }

    int[] result = new int[nums.length];
    // 处理结果
    for (int i = 0; i < nums.length; i++) {
      result[i] = res[i];
    }

    return result;
  }


  // 思路2：i%length，这样当i超出长度时，一取模就又回去了。比如长度是10，当i=2和i=12时，取模得到的结果都是2.
  public int[] nextGreaterElements1(int[] nums) {
    //边界判断
    if (nums == null || nums.length <= 1) {
      return new int[]{-1};
    }
    int size = nums.length;
    int[] result = new int[size];//存放结果
    Arrays.fill(result, -1);//默认全部初始化为-1
    Stack<Integer> st = new Stack<>();//栈中存放的是nums中的元素下标
    for (int i = 0; i < 2 * size; i++) {
      while (!st.empty() && nums[i % size] > nums[st.peek()]) {
        result[st.peek()] = nums[i % size];//更新result
        st.pop();//弹出栈顶
      }
      st.push(i % size);
    }
    return result;
  }

}
