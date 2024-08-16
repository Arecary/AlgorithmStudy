package ershua;

import java.util.ArrayList;
import java.util.List;

public class LC98 {


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


  // BST在中序遍历下 是一个递增数组
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    List<Integer> res = new ArrayList<>();
    isVal(root, res);
    for (int i = 1; i < res.size(); i++) {
      if (res.get(i) <= res.get(i - 1)) {
        return false;
      }
    }
    return true;
  }

  private void isVal(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    isVal(root.left,res);
    res.add(root.val);
    isVal(root.right,res);
  }


  // 改进 可以只存储上一个节点值进行比较
  TreeNode max;
  public boolean isValidBST1(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 左
    boolean left = isValidBST(root.left);
    if (!left) {
      return false;
    }
    // 中
    if (max != null && root.val <= max.val) {
      return false;
    }
    max = root;
    // 右
    boolean right = isValidBST(root.right);
    return right;
  }

}
