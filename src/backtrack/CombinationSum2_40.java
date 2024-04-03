package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_40 {


  // 和39一样，但是要去重
  // 我们要去重的是同一树层上的“使用过”，同一树枝上的都是一个组合里的元素，不用去重。
  // 比如candidates = [1, 1, 2], target = 3
  // 树的第二层里，会有两个节点都是选取了1，这里要去掉一个
  // 1号树枝上的1已经用过了，同一树层上不能继续使用
  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates); // 排序后可以对比前一个元素是否相同，从而判断要不要跳过。
    backtrack(candidates, target, 0);
    return result;
  }

  private void backtrack(int[] candidates, int target, int startIndex) {
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      if (i > startIndex && candidates[i] == candidates[i - 1]) {
       continue;
      }
      // 剪枝操作
      // 如果当前元素已经大于目标值，后续的元素也不会满足条件，直接终止循环
      if (candidates[i] > target) break;
      path.add(candidates[i]);
      backtrack(candidates, target - candidates[i], i + 1);
      path.removeLast();
    }
  }


}
