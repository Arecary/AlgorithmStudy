package ershua;

import java.util.Arrays;

public class LC704 {


  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    

    return bs(nums, target, left, right);

  }


  public int bs(int[] nums, int target, int left, int right){

    if (left > right) {
      return -1;
    }
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
      return mid;
    }else if (nums[mid] > target) {
      return bs(nums, target, left, mid-1);
    }else {
      return bs(nums, target, mid+1, right);
    }
  }


  public int bSearch(int[] nums, int target) {

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] == target) {
        return mid;
      }else if (nums[mid] > target) {
        right = mid - 1;
      }else {
        left = mid + 1;
      }
    }

    return -1;
  }


}
