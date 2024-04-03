import java.util.HashMap;
import java.util.Map;

public class FourSum2_454 {

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();
    // 计算nums1和nums2的和，统计出现的次数，放入map中
    for (int a : nums1) {
      for (int b : nums2) {

        int sum = a + b;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    int count = 0;

    for (int c : nums3) {
      for (int d : nums4) {

        int rest = 0 - (c + d);
        count +=  map.getOrDefault(rest, 0);

      }
    }

    return count;

  }


}
