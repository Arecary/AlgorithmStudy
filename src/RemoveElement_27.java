import java.util.Arrays;

public class RemoveElement_27 {


  public static void main(String[] args) {
    int[] array = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;

    int[] array2 = {3, 2, 2, 3};
    int val2 = 3;

    int num = new RemoveElement_27().removeElement2(array, val);
    System.out.println("num of val = 2 is " + num);
    System.out.println(Arrays.toString(array));


  }


  // 暴力解法
  public int removeElement(int[] nums, int val) {
    int length = nums.length;
    int temp;
    int count = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        for (int j = i; j < nums.length - 1; j++) {
          temp = nums[j + 1];
          nums[j] = temp;
        }
        if (val != 0) {
          nums[nums.length - count] = 0;
        } else {
          nums[nums.length - count] = 1;
        }
        count += 1;
        length -= 1;
        i -= 1;
      }
    }
    return length;
  }


  // 双指针法
  public int removeElement2(int[] nums, int val) {
    int slowIndex = 0;
    for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
      if (nums[fastIndex] != val) {
        nums[slowIndex] = nums[fastIndex];
        slowIndex++;
      }
    }
    return slowIndex;
  }

}
