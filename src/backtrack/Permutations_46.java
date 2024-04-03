package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 排列问题
public class Permutations_46 {

  // 和组合是不一样的
  // 每层都是从0开始搜索而不是startIndex
  // 需要used数组记录path里都放了哪些元素了
  // 注意这题数组中没有重复元素

/*  以数组[1, 2, 3]为例，来详细说明这个过程：

  第一层递归：选择2（将used[1]标记为true），此时排列中的元素是[2]。

  第二层递归：从数组的开始（index 0）遍历，尽管我们又开始从1考虑，但因为我们使用used数组：

  当i = 0时，used[0]是false（1未被使用），因此1可以被加入当前排列。
  当i = 1时，used[1]是true（2已被使用），因此2会被跳过，避免了[2, 2]这种重复情况。
  当i = 2时，used[2]是false（3未被使用），因此3也可以被加入当前排列。
  这样，通过从每层的index 0开始遍历，并使用used数组来跳过那些已经被使用的元素，我们可以确保在生成排列的过程中，每个元素在每个排列中只出现一次，同时探索所有可能的排列组合。

  此方法的关键在于，used数组允许我们“回头”考虑那些在当前排列尚未使用的元素，这是使用startIndex方法无法做到的。*/

  List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
  LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
  boolean[] used;

  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0){
      return result;
    }
    used = new boolean[nums.length];
    permuteHelper(nums);
    return result;

  }


  private void permuteHelper(int[] nums){
    // 终止条件为，到了叶子节点，也就是path的size == nums的size
    if (path.size() == nums.length){
      result.add(new ArrayList<>(path));
      return;
    }

    // 因为是排列，所以i每次从0开始，可以重复，因为1,2 和 2,1 不是同一个排列
    for (int i = 0; i < nums.length; i++){
      if (used[i]){
        continue;
      }
      used[i] = true;
      path.add(nums[i]);
      permuteHelper(nums);
      path.removeLast();
      used[i] = false;
    }

  }



}
