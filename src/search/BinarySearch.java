package search;

public class BinarySearch {


  public int search(int[] nums, int target) {
    int result = bSearch(nums, target, 0, nums.length - 1);
    return result;
  }

  public int bSearch(int[] nums, int target, int left, int right) {
    // int mid = (left + right) / 2; 这样当right和left很大的时候，left+right可能会溢出
    int mid = left + (right - left) / 2;
    if (left > right) {
      return -1;
    }
    if (nums[mid] == target) {
      return mid;
    }
    if (nums[mid] > target) {
      return bSearch(nums, target, left, mid - 1);
    } else {
      return bSearch(nums, target, mid + 1, right);
    }
  }


}
