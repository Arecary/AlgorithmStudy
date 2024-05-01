package monotonicstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1_496 {


  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> temp = new Stack<>();
    int[] res = new int[nums1.length];
    Arrays.fill(res, -1);
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      map.put(nums1[i], i);
    }

    temp.push(0);
    for (int i = 1; i < nums2.length; i++) {
      if (nums2[i] <= nums2[temp.peek()]) {
        temp.add(i);
      } else {
        while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]) {
          if (map.containsKey(nums2[temp.peek()])){
            Integer index = map.get(nums2[temp.peek()]);
            res[index] = nums2[i];
          }
          temp.pop();
        }
        temp.add(i);
      }
    }

    return res;
  }


}
