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

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return res;
      }
      int left = i + 1;
      int right = nums.length - 1;

      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      while (left < right) {
        int a = nums[i];
        int b = nums[left];
        int c = nums[right];
        int sum = a + b + c;
        if (sum > 0) {
          right --;
        }else if(sum < 0) {
          left++;
        }else {
          res.add(Arrays.asList(a, b, c));
          while (right > left && nums[right] == nums[right - 1]) right--;
          while (right > left && nums[left] == nums[left + 1]) left++;
          right --;
          left++;
        }
      }
    }

    return res;
  }


}
