package ershua;

public class LC912 {


  public int[] sortArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    mergeSort(nums, 0, nums.length-1);

    return nums;
  }

  public void mergeSort(int[] nums, int l, int r){
    if (l == r) {
      return;
    }
    int mid = l + (r-l)/2;
    mergeSort(nums, l, mid);
    mergeSort(nums, mid + 1, r);
    merge(nums, l, r, mid);
  }

  public void merge(int[] nums, int l, int r, int mid){
    int index1 = l;
    int index2 = mid + 1;
    int[] helper = new int[r - l + 1];
    int i = 0;
    while (index1 <= mid && index2 <= r){
      helper[i++] = nums[index1] <= nums[index2] ? nums[index1++] : nums[index2++];
    }

    while (index1 <= mid){
      helper[i++] = nums[index1++];
    }
    while (index2 <= r){
      helper[i++] = nums[index2++];
    }

    for (int j = 0; j < helper.length; j++) {
      nums[l + j] = helper[j];
    }
  }



}
