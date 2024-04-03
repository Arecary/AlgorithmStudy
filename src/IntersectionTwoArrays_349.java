import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoArrays_349 {



  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
      return new int[0];
    }

    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();

    for (int i = 0; i < nums1.length; i++) {
      s1.add(nums1[i]);
    }

    for (int i = 0; i < nums2.length; i++) {
      if (s1.contains(nums2[i])) {
        s2.add(nums2[i]);
      }
    }

    int[] result = new int[s2.size()];

    for (int i = 0; i< s2.size(); i++) {
      result[i] = s2.toArray(new Integer[0])[i];
    }

    return result;

  }


}
