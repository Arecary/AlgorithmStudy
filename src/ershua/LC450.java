package ershua;

public class LC450 {


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

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return root;

    if (root.val == key) {
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left != null && root.right == null) {
        return root.left;
      }
      if (root.left == null) {
        return root.right;
      }
      TreeNode minNode = getMin(root.right);
      root.val = minNode.val;
      root.right = deleteNode(root.right, minNode.val);
      /*minNode.left = root.left; 难理解，调整了指针
      root = root.right;
      return root;*/
    }


    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    }
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    }
    return root;

  }
  private TreeNode getMin(TreeNode node) {
    while (node.left != null) node = node.left;
    return node;
  }

}
