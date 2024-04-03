import java.util.Arrays;
import java.util.Collections;

public class SquaresOfSortedArray_977 {

  public static void main(String[] args) {

    int[] array = {-4, -1, 0, 3, 10};

    System.out.println("Sorted Squares: " + Arrays.toString(new SquaresOfSortedArray_977().sortedSquares(array)));

  }

  // 暴力平方加排序
/*  public int[] sortedSquares1(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i]*nums[i];
    }
    // 很麻烦 因为降序必须得是包装类 ex：Integer []
    Arrays.sort(nums, Collections.reverseOrder());
    return nums;
  }*/



  // 双指针
  public int[] sortedSquares(int[] nums) {

    int left = 0;
    int right = nums.length - 1;
    int[] newNums = new int[nums.length];
    int newRight = nums.length - 1;
    while (left <= right) {
      if (nums[left] * nums[left] > nums[right] * nums[right]) {
        newNums[newRight] = nums[left] * nums[left];
        left++;
        newRight--;
      } else {
        newNums[newRight] = nums[right] * nums[right];
        right--;
        newRight--;
      }
    }
    return newNums;
  }

}
