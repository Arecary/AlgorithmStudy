package ershua;

public class LC538 {


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


  // 节点值貌似是左依赖中右，中依赖右，所以用右中左的顺序遍历
  int sum;
  public TreeNode convertBST(TreeNode root) {
    sum = 0;
    convertBST1(root);
    return root;
  }

  // 按右中左顺序遍历，累加即可
  public void convertBST1(TreeNode root) {
    if (root == null) {
      return;
    }
    convertBST1(root.right);
    sum += root.val;
    root.val = sum;
    convertBST1(root.left);
  }


}
