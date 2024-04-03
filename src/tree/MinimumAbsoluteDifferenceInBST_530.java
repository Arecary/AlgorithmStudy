package tree;

public class MinimumAbsoluteDifferenceInBST_530 {


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


  // 想法一：BST中序遍历成有序数组，然后找最小差
  // 想法二：BST中序遍历，用一个变量记录上一个节点，然后比较当前节点和上一个节点的差值，这其实和想法一一样，只是省略了变成数组
  TreeNode pre;// 记录上一个遍历的结点
  int result = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    if (root == null) return 0;
    traversal(root);
    return result;
  }

  public void traversal(TreeNode root) {
    if (root == null) return;
    //左
    traversal(root.left);
    //中
    if (pre != null) {
      result = Math.min(result, root.val - pre.val);// 这里其实也是在算有序数组中最小差
    }
    pre = root;
    //右
    traversal(root.right);
  }
}
