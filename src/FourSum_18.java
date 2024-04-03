import java.util.ArrayList;
import java.util.List;

public class FourSum_18 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    java.util.Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] > target && (nums[i] >= 0 || target >= 0)) {
        return result;
      }

      if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
        continue;
      }

      // 双层for循环，这样循环里的其实就和3sum的题目一样了。
      for (int j = i + 1; j < nums.length; j++) {

        if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对b去重
          continue;
        }

        int left = j + 1;
        int right = nums.length - 1;

        while (left < right) {
          // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
          long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

          if (sum > target) {
            right--;
          } else if (sum < target) {
            left++;
          } else {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(nums[i]);// a
            triplet.add(nums[j]);// b
            triplet.add(nums[left]);// c
            triplet.add(nums[right]);// d
            result.add(triplet);
            while (right > left && nums[right] == nums[right - 1]) right--;
            while (right > left && nums[left] == nums[left + 1]) left++;

            left++;
            right--;
          }
        }
      }
    }
    return result;
  }


}
