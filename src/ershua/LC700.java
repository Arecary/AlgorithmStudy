package ershua;

import java.util.Deque;
import java.util.LinkedList;

public class LC700 {


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


  // 层序遍历
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int len = queue.size();
      while (len != 0) {
        len--;
        TreeNode cur = queue.poll();
        if (cur.val == val) {
          return cur;
        }
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
    }
    return null;
  }



  // 递归
  public TreeNode searchBST1(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }

    TreeNode left = searchBST1(root.left, val);
    if (left != null) {
      return left;
    }

    return searchBST1(root.right, val);
  }


  // BST递归
  public TreeNode searchBST2(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }

    if (root.val > val) {
      return searchBST2(root.left, val);
    }else {
      return searchBST2(root.right, val);
    }
  }

}
