package tree;

public class SearchInBinarySearchTree_700 {


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


  // 注意这是一个BST
  //  解法1：递归
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }

    if (root.val > val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }


  // 迭代，利用二叉搜索树特点，优化，可以不需要栈
  public TreeNode searchBST1(TreeNode root, int val) {
    while (root != null)
      if (val < root.val) root = root.left;
      else if (val > root.val) root = root.right;
      else return root;
    return null;
  }
}
