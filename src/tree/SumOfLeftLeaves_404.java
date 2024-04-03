package tree;

public class SumOfLeftLeaves_404 {


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


  // 递归
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }

    // 这是判断节点为左叶子的条件
    if (root.left != null && root.left.left == null && root.left.right == null) {
      return root.left.val + sumOfLeftLeaves(root.right);
    } else {
      return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

  }


}
