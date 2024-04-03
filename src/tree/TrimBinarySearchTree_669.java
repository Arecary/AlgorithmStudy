package tree;

public class TrimBinarySearchTree_669 {

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


  // 如果root（当前节点）的元素小于low的数值，那么应该递归右子树，并返回右子树符合条件的头结点。
  // 如果root(当前节点)的元素大于high的，那么应该递归左子树，并返回左子树符合条件的头结点。
  // EX:节点0的右孩子（节点2）返回给上一层, 节点3的左孩子 把下一层返回的 节点0的右孩子（节点2）接住
  // 此时节点3的左孩子就变成了节点2，将节点0从二叉树中移除了。
  public TreeNode trimBST(TreeNode root, int low, int high) {
    //终止条件
    if (root == null) {
      return null;
    }
    //单层逻辑
    if (root.val < low) {
      return trimBST(root.right, low, high);
    }
    if (root.val > high) {
      return trimBST(root.left, low, high);
    }

    // root在[low,high]范围内
    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    return root;
  }


}
