package ershua;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC515 {


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


  public List<Integer> largestValues(TreeNode root) {

    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int len = queue.size();
      int max = Integer.MIN_VALUE;
      while (len != 0) {
        TreeNode cur = queue.poll();
        max = Math.max(max, cur.val);
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
        len --;
      }
      res.add(max);
    }
    return res;

  }


}
