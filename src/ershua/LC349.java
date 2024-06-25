package ershua;

import java.util.ArrayList;
import java.util.HashSet;

public class LC349 {

  public int[] intersection(int[] nums1, int[] nums2) {

    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }

    HashSet<Integer> record = new HashSet<>();

    for (int i : nums1) {
      record.add(i);
    }

    HashSet<Integer> res = new HashSet<>();

    for (int i : nums2) {
      if (record.contains(i)) {
        res.add(i);
      }
    }

    int[] result = new int[res.size()];

    int index = 0;
    for (int i : res) {
      result[index] = i;
      index++;
    }

    return result;
  }


}
