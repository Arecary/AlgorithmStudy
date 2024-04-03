package search;

public class BinarySearch_704 {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 3, 5, 9, 12};
    int target = 9;
    int result = new BinarySearch_704().search(nums, target);
    System.out.println(result);


  }

  public int search(int[] nums, int target) {
    return BinarySearch(nums, target, 0, nums.length - 1);
  }


  // Recursion
  public int BinarySearch(int[] nums, int target, int start, int end) {
    if (start > end) {
      return -1;
    }
    // int mid = (left + right) / 2; 这样当right和left很大的时候，left+right可能会溢出
    int mid = (end - start) / 2 + start;

    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] > target) {
      return BinarySearch(nums, target, start, mid - 1);
    }else {
      return BinarySearch(nums, target, mid + 1, end);
    }
  }

  // Loop
  public int search2(int[] nums, int target) {
    int low=0,high=nums.length-1;
    while(low<=high)
    {
      int mid =(low+high)/2;
      if(nums[mid]==target)
        return mid;
      if(nums[mid]<target)
        low=mid+1;
      else
        high=mid-1;
    }
    return -1;
  }


}

