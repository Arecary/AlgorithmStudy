package ershua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }

    Arrays.sort(nums);


    int right = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return res;
      }
      int left = i + 1;
      int a = nums[i];
      int b = nums[left];
      int c = nums[right];

      while (a + b + c > 0 && left < right) {
        right--;
      }
      while (a + b + c < 0 && left < right) {
        left++;
      }
    }

  }


}
