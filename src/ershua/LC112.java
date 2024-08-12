package ershua;

public class LC112 {

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

  public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
        return false;
      }
      if (root.val == targetSum && root.left == null & root.right == null) {
        return true;
      }

      if (root.left != null) {
        boolean f1 = hasPathSum(root.left, targetSum - root.val);
        if (f1) {
          return true;
        }
      }
      if (root.right != null) {
        boolean f2 = hasPathSum(root.right, targetSum - root.val);
        if (f2) {
          return true;
        }
      }

      return false;
  }

}
