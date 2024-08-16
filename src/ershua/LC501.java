package ershua;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC501 {


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


  HashMap<Integer, Integer> mod = new HashMap<>();
  public int[] findMode(TreeNode root) {
    if (root == null) {
      return new int[]{};
    }
    int max = Integer.MIN_VALUE;
    Deque<Integer> res = new LinkedList<>();
    help(root);
    for (Map.Entry<Integer, Integer> map : mod.entrySet()) {
      int num = map.getKey();
      int times = map.getValue();
      if (times > max) {
        res.clear();
        res.push(num);
        max = times;
      }else if (times == max){
        res.push(num);
      }
    }

    int[] result = new int[res.size()];
    int i = 0;
    while (!res.isEmpty()) {
      result[i] = res.pop();
      i++;
    }

    return result;
  }

  private void help(TreeNode root) {
    if (root == null) {
      return;
    }
    help(root.left);

    mod.put(root.val, mod.getOrDefault(root.val, 0) + 1);

    help(root.right);

  }

}
