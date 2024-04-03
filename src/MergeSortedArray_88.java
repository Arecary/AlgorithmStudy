import java.util.Arrays;

public class MergeSortedArray_88 {


  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};

    merge1(nums1, 3, nums2, 3);

    System.out.println(Arrays.toString(nums1));

  }

  // 双指针，时间复杂度低
  static public void merge(int[] nums1, int m, int[] nums2, int n) {

    int pointer1 = 0;
    int pointer2 = 0;
    int[] nums3 = new int[m + n];

    for (int i = 0; i < m + n; i++) {
      if (pointer1 < m && (pointer2 >= n || nums1[pointer1] <= nums2[pointer2])) {
        nums3[i] = nums1[pointer1];
        pointer1++;
      } else {
        nums3[i] = nums2[pointer2];
        pointer2++;
      }
    }

    for (int i = 0; i < m + n; i++) {
      nums1[i] = nums3[i];
    }

  }


  // 用快速排序做
  static public void merge1(int[] nums1, int m, int[] nums2, int n) {
    int length1 = nums1.length;
    for (int i = 0; i < n; i++) {
      nums1[length1 - n] = nums2[i];
      length1++;
    }
    Arrays.sort(nums1);
  }


}
