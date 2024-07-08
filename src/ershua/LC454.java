package ershua;

import java.util.HashMap;
import java.util.HashSet;

public class LC454 {

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    int res = 0;

    HashMap<Integer, Integer> record = new HashMap<>();
    for (int i : nums1) {
      for (int j : nums2) {
        record.put(i + j, record.getOrDefault(i + j, 0) + 1);
      }
    }

    for (int i : nums3) {
      for (int j : nums4) {
        int sum = i + j;
        if (record.containsKey(-sum)) {
          res += record.get(-sum);
        }
      }
    }

    return res;
  }


}
