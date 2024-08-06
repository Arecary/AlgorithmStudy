package ershua;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC637 {

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


  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int len = queue.size();
      long num = 0;
      while (len != 0) {
        TreeNode cur = queue.poll();
        num++;
        temp.add(cur.val);
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
        len --;
      }
      long sum = 0;
      for (Integer i : temp) {
        sum += i;
      }
      double average = (double) sum / num;
      res.add(average);
    }

    return res;
  }


}
