package tree;

public class CountCompleteTreeNodes_222 {

    // Definition for a binary tree node.
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


  // 通用递归解法
  public int countNodes(TreeNode root) {
    if(root == null) {
      return 0;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
  }

  // 或者用102那种层序遍历的迭代法，只不过计数nodes。

  /**
   * 针对完全二叉树的解法
   * <p>
   * 满二叉树的结点数为：2^depth - 1
   */
  public int countNodes1(TreeNode root) {
    if (root == null) return 0;
    TreeNode left = root.left;
    TreeNode right = root.right;
    int leftDepth = 0, rightDepth = 0; // 这里初始为0是有目的的，为了下面求指数方便
    while (left != null) {  // 求左子树深度
      left = left.left;
      leftDepth++;
    }
    while (right != null) { // 求右子树深度
      right = right.right;
      rightDepth++;
    }
    // 在完全二叉树中，如果最后一层没有完全填满，那么缺失的节点一定出现在右侧。
    // 所以如果左右深度相等，说明这个树是一个完美的完全二叉树，底层没有缺失，所以可以用公式直接得出答案。
    // 如果左右深度不相等，说明最后一层是缺失了一部分节点，所以需要递归计算左右子树结点数之和。
    if (leftDepth == rightDepth) {
      return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
    }
    // 如果整个树不是满二叉树，就递归其左右孩子，直到遇到满二叉树为止，用公式计算这个子树（满二叉树）的节点数量。
    return countNodes(root.left) + countNodes(root.right) + 1;
  }

}
