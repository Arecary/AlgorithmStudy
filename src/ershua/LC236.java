package ershua;

public class LC236 {


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) { // 递归结束条件  可以直接返回而不是继续查当前root的左右子树，因为题目默认一定存在p，q，‘
      // 所以如果一直递归返回上去都没有找到另一个值，那么另一个值一定在当前root的子树里，即当前root即使两个值之一也是公共祖先
      return root;
    }

    // 后序遍历
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if(left == null && right == null) { // 若未找到节点 p 或 q
      return null;
    }else if(left == null && right != null) { // 若找到一个节点
      return right;
    }else if(left != null && right == null) { // 若找到一个节点
      return left;
    }else { // 若找到两个节点
      return root;
    }
  }

}
