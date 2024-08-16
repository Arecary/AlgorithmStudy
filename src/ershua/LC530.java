package ershua;

public class LC530 {


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


  TreeNode pre;
  Integer gap = Integer.MAX_VALUE;
  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return 0;
    }
    help(root);
    return gap;
  }

  private void help(TreeNode root) {
    if (root == null) {
      return;
    }

    help(root.left);

    if (pre!=null) {
      gap = Math.min(gap, root.val - pre.val);
    }
    pre = root;

    help(root.right);
  }

}
