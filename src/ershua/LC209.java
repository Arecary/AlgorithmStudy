package ershua;

public class LC209 {


  // target = 7, nums = [2,3,1,2,4,3]
  public int minSubArrayLen(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0, j = 0; i < nums.length; i++) {
      sum += nums[i];
      while (sum >= target) {
        len = Math.min(i - j + 1, len);
        sum -= nums[j];
        j++;
      }
    }

    return (len == Integer.MAX_VALUE) ? 0 : len;
  }



}
