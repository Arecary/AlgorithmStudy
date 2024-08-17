package ershua;

public class LC669 {

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


  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) {
      return root;
    }

    if (root.val < low) {
      return trimBST(root.right, low, high);  // 修剪右子树
    }
    if (root.val > high) {
      return trimBST(root.left, low, high);  // 修剪右子树
    }

    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);


    return root;
  }




}
