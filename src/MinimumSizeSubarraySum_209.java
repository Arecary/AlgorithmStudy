public class MinimumSizeSubarraySum_209 {

  public static void main(String[] args) {
    int[] array = {10,2,3};
    int target = 6;
    int result = new MinimumSizeSubarraySum_209().minSubArrayLen(target, array);
    System.out.println(result);

  }

  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int sum = 0;
    int result = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];
      while (sum >= target) {
        result = Math.min(result, right - left + 1);
        sum -= nums[left++];
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }


}
