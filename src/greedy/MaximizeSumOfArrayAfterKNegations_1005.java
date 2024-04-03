package greedy;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MaximizeSumOfArrayAfterKNegations_1005 {


  // 先把所有负数转成整数，如果k还有剩的，那么就把最小的数转化k次
  public int largestSumAfterKNegations(int[] nums, int k) {
    // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
    nums = IntStream.of(nums)
            .boxed()
            .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
            .mapToInt(Integer::intValue).toArray();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0 && k > 0) {
        nums[i] = Math.abs(nums[i]);
        k--;
      }
    }


    if (k % 2 == 1) {
      nums[nums.length - 1] = -nums[nums.length - 1];
    }

    return IntStream.of(nums).sum();
  }



  // 快一点
  public int largestSumAfterKNegations1(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      pq.add(nums[i]);
      sum += nums[i];
    }
    while (k != 0 && !pq.isEmpty()) {
      int x = pq.remove();
      if (x < 0) {
        int y = -x;
        sum = sum + y + y;
      } else {
        sum = sum - x - x;
      }
      pq.add(-x);
      k--;
    }
    return sum;
  }

}
