package ershua;

public class LC977 {


  // nums = [-4,-1,0,3,10]
  public int[] sortedSquares(int[] nums) {
    if (nums == null || nums.length == 0) {
      return nums;
    }

    int[] res = new int[nums.length];
    int index = nums.length-1;

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {

      int num1 = nums[left] * nums[left];
      int num2 = nums[right] * nums[right];

      if (num1 > num2) {
        res[index] = num1;
        index--;
        left++;
      }else {
        res[index] = num2;
        index--;
        right--;
      }
    }

    return res;
  }


}
