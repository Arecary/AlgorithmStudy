package tree;

public class LowestCommonAncestorOfBinarySearchTree_235 {


  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  // 根据BST的特性，当我们从上向下去递归遍历，第一次遇到 cur节点是数值在[q, p]区间中，那么cur就是 q和p的最近公共祖先。
  // 确定递归函数返回值以及参数: 参数就是当前节点，以及两个结点 p、q。
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 终止条件
    if (root == null || (root.val >= p.val && root.val <= q.val) ||(root.val <= p.val && root.val >= q.val)) {
      return root;
    }

    // 确定单层递归的逻辑

    // 根据BST的性质，决定是向左子树递归还是向右子树递归
    if (p.val < root.val && q.val < root.val) {
      // p和q都在root的左侧
      return lowestCommonAncestor(root.left, p, q);
    } else {
      // p和q都在root的右侧
      return lowestCommonAncestor(root.right, p, q);
    }

  }

}
