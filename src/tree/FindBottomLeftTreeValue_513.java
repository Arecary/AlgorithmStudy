package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {
  // Definition for a binary tree node.
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


  // 我的思路是层序遍历到最后一层，然后找第一个值，就是最左边的。
  public int findBottomLeftValue(TreeNode root) {
    int result = 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int len = queue.size();

      for (int i = 0; i < len; i++) {
        TreeNode temp = queue.poll();
        if (i == 0) {
          result = temp.val;
        }

        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
    }

    return result;
  }


}
