import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2_80 {


  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3};
    int size = removeDuplicates(nums);
    System.out.println(size);
    System.out.println(Arrays.toString(nums));
  }

  // 当 fast 指针指向的元素与 slow - 2 指向的元素相等时，由于数组已排序，这意味着 slow - 1 和 slow - 2 指向的元素也必然等于 fast 指向的元素。
  // 因此，我们已经有了至少两个相同的元素在新数组中（位于 slow - 2 和 slow - 1 的位置）。
  // 如果我们再把 fast 指针的元素复制到 slow 的位置，就会有三个连续的相同元素出现在新数组中，这违反了问题中“允许最多两个重复元素”的条件。
  static public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;

    int slow = 2;
    for (int fast = 2; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow - 2]) { // 比较当前元素与新数组倒数第二个元素
        nums[slow] = nums[fast];
        slow++;
      }
    }
    return slow;
  }

}
