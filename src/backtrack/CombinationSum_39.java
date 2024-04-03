package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {


  // 1. 递归公式
  // 2. 终止条件
  // 3. 单层搜索的逻辑


  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    backtrack(candidates, target, 0); // 防止同时出现23和32这样的情况，当candidates数组为[2,3,6,7]
    return result;
  }

  private void backtrack(int[] candidates, int target, int start) {
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = start; i < candidates.length; i++) { // 当前递归深度选取的每个元素都不会回头去选择之前已经考虑过的元素
      path.add(candidates[i]);
      backtrack(candidates, target- candidates[i], i);
      path.removeLast();
    }

  }

}

