package ershua;

public class LC2016 {


  public int maximumDifference(int[] nums) {
    int minValue = nums[0]; // 初始化为数组的第一个元素
    int maxDifference = -1; // 初始化为-1，表示如果没有找到符合条件的 i 和 j

    // 从第二个元素开始遍历数组
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > minValue) {
        // 计算差值并更新最大差值
        maxDifference = Math.max(maxDifference, nums[i] - minValue);
      } else {
        // 更新最小值
        minValue = nums[i];
      }
    }

    return maxDifference; // 返回最大差值
  }



}
