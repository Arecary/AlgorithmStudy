package ershua;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC226 {


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

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int len = queue.size();
      while (len != 0) {
        len--;
        TreeNode cur = queue.poll();
        TreeNode temp;
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }

        temp = cur.right;
        cur.right = cur.left;
        cur.left = temp;

      }
    }

    return root;

  }

}
