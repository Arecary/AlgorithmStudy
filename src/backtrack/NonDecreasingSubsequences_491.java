package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
public class NonDecreasingSubsequences_491 {


  // 思路，本题求自增子序列，是不能对原数组进行排序的，排完序的数组都是自增子序列了。

  // 去重：同一父节点下的同层上使用过的元素就不能再使用了，这是为了保证同一个根节点下，不会在下一层出现两个重复的子序列
  // 所取元素如果小于已有path最后一个元素则也舍弃，这个逻辑确保生成的子序列是递增的。
  // 在递归构建子序列的过程中，如果当前考虑的元素小于子序列中最后一个元素，那么添加这个元素就会破坏子序列的递增性，因此这样的元素应该被舍弃。


  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> findSubsequences(int[] nums) {
    backTrack(nums, 0);
    return result;
  }

  private void backTrack(int[] nums, int startIndex) {
    if (path.size() >= 2) {
      result.add(new ArrayList<>(path));
      // 注意这里不要加return，因为要取树上的所有节点, 因为递增子序列的长度至少是2
    }

    Set<Integer> used = new HashSet<>();
    for (int i = startIndex; i < nums.length; i++) {
      // 如果nums[i]已经在这一层使用过，或者是小于当前路径的最后一个数字，则跳过
      if (used.contains(nums[i]) || !path.isEmpty() && path.get(path.size() - 1) > nums[i]) {
        continue;
      }
      used.add(nums[i]);
      path.add(nums[i]);
      backTrack(nums, i + 1);
      path.removeLast();
    }

  }

}
