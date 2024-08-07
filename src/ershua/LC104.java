package ershua;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC104 {

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


  public int maxDepth(TreeNode root) {
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
      }
      depth++;
    }

    return depth;
  }


}
