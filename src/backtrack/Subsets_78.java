package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {


  List<List<Integer>> result = new ArrayList<>();

  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> subsets(int[] nums) {
    backTrack(nums, 0);
    return result;
  }


  private void backTrack(int[] nums, int startIndex) {
    // 遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合。
    result.add(new ArrayList<>(path));
    if (startIndex >= nums.length) {
      return;
    }

    for (int i = startIndex; i < nums.length; i++){
      path.add(nums[i]);
      backTrack(nums, i + 1);
      path.removeLast();
    }

  }


}
