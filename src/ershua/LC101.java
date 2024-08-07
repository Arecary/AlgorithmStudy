package ershua;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC101 {


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

  public boolean isSymmetric2(TreeNode root) {
    if (root == null) {
      return true;
    }
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerFirst(root.left);
    deque.offerLast(root.right);
    while (!deque.isEmpty()) {
      TreeNode leftNode = deque.pollFirst();
      TreeNode rightNode = deque.pollLast();
      if (leftNode == null && rightNode == null) {
        continue;
      }
      // 判断是否对称
      if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
        return false;
      }
      deque.offerFirst(leftNode.left);
      deque.offerFirst(leftNode.right);
      deque.offerLast(rightNode.right);
      deque.offerLast(rightNode.left);
    }
    return true;
  }

}
