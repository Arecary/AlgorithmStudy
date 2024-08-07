package ershua;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC111 {


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

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int depth = 0;

    while (!queue.isEmpty()) {
      int len = queue.size();
      while (len != 0) {
        len--;
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
        if (cur.left == null && cur.right == null) {
          return depth;
        }
      }
      depth++;
    }

    return depth;

  }

}
