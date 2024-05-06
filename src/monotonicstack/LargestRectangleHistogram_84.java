package monotonicstack;

import java.util.Stack;

public class LargestRectangleHistogram_84 {

  // 这题是找左右小的值，所以是单调递减栈

  int largestRectangleArea(int[] heights) {
    Stack<Integer> st = new Stack<Integer>();

    // 数组扩容，在头和尾各加入一个元素，为了防止出现数组本来就是单调递增，
    // 那么加入stack时就会直接全部加进去而不走到计算面积的那一步，所以补一个0在末尾，这样一定会触发计算面积的code。
    // 或者数组开头2个元素是递减，直接触发计算面积的code，但是计算面积需要三个元素，所以补一个0在开头。
    int [] newHeights = new int[heights.length + 2];
    newHeights[0] = 0;
    newHeights[newHeights.length - 1] = 0;
    for (int index = 0; index < heights.length; index++){
      newHeights[index + 1] = heights[index];
    }

    heights = newHeights;

    st.push(0);
    int result = 0;
    // 第一个元素已经入栈，从下标1开始
    for (int i = 1; i < heights.length; i++) {
      // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
      if (heights[i] > heights[st.peek()]) {
        st.push(i);
      } else if (heights[i] == heights[st.peek()]) {
        st.pop(); // 这个可以加，可以不加，效果一样，思路不同
        st.push(i);
      } else {
        while (heights[i] < heights[st.peek()]) { // 注意是while
          int mid = st.peek();
          st.pop();
          int left = st.peek();
          int right = i;
          int w = right - left - 1;
          int h = heights[mid];
          result = Math.max(result, w * h);
        }
        st.push(i);
      }
    }
    return result;
  }

}
