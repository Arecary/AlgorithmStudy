package tree;

public class LowestCommonAncestorOfBinaryTree_236 {

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  // 后序遍历（左右中）就是天然的回溯过程，可以根据左右子树的返回值，来处理中节点的逻辑。
  // 判断逻辑是 如果递归遍历遇到q，就将q返回，遇到p 就将p返回，
  // 那么如果 左右子树的返回值都不为空，说明此时的中节点，一定是q 和p 的最近祖先。
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) { // 递归结束条件
      return root;
    }

    // 后序遍历
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null && right == null) { // 若未找到节点 p 或 q
      return null;
    } else if (left == null && right != null) { // 若找到一个节点
      return right;
    } else if (left != null && right == null) { // 若找到一个节点
      return left;
    } else { // 若找到两个节点，说明当前root就是公共祖先
      return root;
    }
  }

  
}
