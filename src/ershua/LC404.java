package ershua;

public class LC404 {


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

  public int sumOfLeftLeaves(TreeNode root) {
    if(root == null){
      return 0;
    }

    int leftValue = sumOfLeftLeaves(root.left);
    int rightValue = sumOfLeftLeaves(root.right);

    int mindValue = 0;
    if (root.left != null && root.left.left == null && root.left.right == null) {
      mindValue = root.left.val;
    }

    int res = leftValue + rightValue + mindValue;

    return res;

  }


}
