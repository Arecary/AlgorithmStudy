package tree;

public class BalancedBinaryTree_110 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



  /**
   * 递归法
   */
  public boolean isBalanced(TreeNode root) {
    return getHeight(root) != -1;
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // 自底而上，先从最下面开始慢慢加高度
    // 一开始肯定左右都是0
    // 但凡出现一个节点不平衡，就返回-1，以后的节点高度就都不用加1了，直接返回-1
    int leftHeight = getHeight(root.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = getHeight(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    // 分别求出其左右子树的高度，然后如果差值小于等于1，则返回当前二叉树的高度，否则返回-1，表示已经不是二叉平衡树了。
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
