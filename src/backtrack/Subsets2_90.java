package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2_90 {


  // 在78的基础上多了去重
  // 同一层不能选取重复的数字


  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();


  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backTrack(nums, 0);
    return result;
  }


  private void backTrack(int[] nums, int startIndex) {
    result.add(new ArrayList<>(path));
    if (startIndex >= nums.length) {
      return;
    }

    for (int i = startIndex; i < nums.length; i++) { // 当i == startIndex时，意味着当前元素是这一层递归的第一个元素，即使它与前一个元素相等，我们也应该考虑将其加入到路径中
      if (i > startIndex && nums[i] == nums[i - 1] ) {
        continue;
      }
      path.add(nums[i]);
      backTrack(nums, i + 1);
      path.removeLast();
    }
  }
}
