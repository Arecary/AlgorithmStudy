import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {

  public static void main(String[] args) {

    int[] nums = {0,0,1,1,1,2,2,3,3,4};
    int size = removeDuplicates(nums);
    System.out.println(size);
    System.out.println(Arrays.toString(nums));

  }

  static public int removeDuplicates(int[] nums) {

    if (nums.length == 0) return 0;
    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow]) {
        slow++;
        nums[slow] = nums[fast];
      }
    }
    return slow + 1;
  }


}
