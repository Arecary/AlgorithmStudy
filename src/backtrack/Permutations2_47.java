package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2_47 {

  // 和46一样，但是数组中有重复元素，所以要去重
  // 去重一定要对元素进行排序，这样我们才方便通过相邻的节点来判断是否重复使用了。


  //存放结果
  List<List<Integer>> result = new ArrayList<>();
  //暂存结果
  List<Integer> path = new ArrayList<>();
  boolean[] used;
  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0){
      return result;
    }
    used = new boolean[nums.length];
    Arrays.fill(used, false);
    Arrays.sort(nums);
    backTrack(nums);
    return result;

  }

  private void backTrack(int[] nums) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过 这个慢
      // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过  这个快，用它
      // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) { // 这里用的是同一层的去重，而且必须得写一个，不能不写。
        // 比如数组112， 第一层递归选1，第二层递归按理说应该从[1,2]里选择，此时used[0]应该是true
        // 如果不加!used[i - 1]判断，当i=1时，迭代到第二个1，此时满足了i > 0 && nums[i] == nums[i - 1]，所以会直接跳过 将会导致我们错过一些有效的排列比如[1, 1, 2]
        // 加了!used[i - 1]判断，当i=1时，迭代到第二个1，此时不满足i > 0 && nums[i] == nums[i - 1] && !used[i - 1]，所以不会跳过
        continue;
      }

      //如果同⼀树⽀nums[i]没使⽤过开始处理
      if (!used[i]) {
        used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
        path.add(nums[i]);
        backTrack(nums);
        path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
        used[i] = false;//回溯
      }
    }
  }


}
