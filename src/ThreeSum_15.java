import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {


  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> a = threeSum(nums);
    System.out.println(a);


  }

  static public List<List<Integer>> threeSum(int[] nums) {
    int[] orderedNums = nums.clone();
    java.util.Arrays.sort(orderedNums);
    List<List<Integer>> result = new ArrayList<>();


    for (int i = 0; i < orderedNums.length; i++) {
      // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
      if (orderedNums[i] > 0) {
        return result;
      }

      if (i > 0 && orderedNums[i] == orderedNums[i - 1]) {  // 去重a
        continue;
      }
      int index1 = i;
      int index2 = i + 1;
      int index3 = orderedNums.length - 1;
//      int a = orderedNums[index1];
//      int b = orderedNums[index2];
//      int c = orderedNums[index3];

      while (index2 < index3) {
        int a = orderedNums[index1]; // 加在while开头是因为保证不会越界，因为刚经过(index2 < index3)的判断
        int b = orderedNums[index2];
        int c = orderedNums[index3];

        if (a + b + c == 0) {
          List<Integer> triplet = new ArrayList<>();
          triplet.add(a);
          triplet.add(b);
          triplet.add(c);
          result.add(triplet);

          while (index3 > index2 && orderedNums[index3] == orderedNums[index3 - 1]) index3--;
          while (index3 > index2 && orderedNums[index3] == orderedNums[index2 + 1]) index2++;
          index2++;
          index3--;
//          a = orderedNums[index1];
//          b = orderedNums[index2];
//          c = orderedNums[index3];
        } else if (a + b + c < 0) {
          index2++;
//          a = orderedNums[index1];
        } else if (a + b + c > 0) {
          index3--;
//          c = orderedNums[index3];
        }
      }
    }
    return result;
  }



  // 答案
  public List<List<Integer>> threeSum1(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    // 找出a + b + c = 0
    // a = nums[i], b = nums[left], c = nums[right]
    for (int i = 0; i < nums.length; i++) {
      // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
      if (nums[i] > 0) {
        return result;
      }

      if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
        continue;
      }

      int left = i + 1;
      int right = nums.length - 1;
      while (right > left) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
          while (right > left && nums[right] == nums[right - 1]) right--;
          while (right > left && nums[left] == nums[left + 1]) left++;

          right--;
          left++;
        }
      }
    }
    return result;
  }


}
