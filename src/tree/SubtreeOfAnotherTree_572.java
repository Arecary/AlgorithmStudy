package tree;


import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class SubtreeOfAnotherTree_572 {


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


  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    return dfs(root, subRoot);
  }

  public boolean dfs(TreeNode s, TreeNode t) {
    if (s == null) {
      return false;
    }
    return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
  }

  public boolean check(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null || s.val != t.val) {
      return false;
    }
    return check(s.left, t.left) && check(s.right, t.right);
  }


}
