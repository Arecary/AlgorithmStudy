package ershua;

import java.util.ArrayList;
import java.util.List;

public class LC257 {


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


  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    List<Integer> path = new ArrayList<>();
    getPath(root, res, path);
    return res;

  }

  private void getPath(TreeNode root, List<String> res, List<Integer> path) {
    path.add(root.val);
    if (root.left == null && root.right == null) {
      StringBuilder sb = new StringBuilder();
      for (int i : path) {
        sb.append(i);
        sb.append("->");
      }
      // sb.deleteCharAt(sb.length() - 1);
      // sb.deleteCharAt(sb.length() - 1);
      sb.delete(sb.length() - 2, sb.length()); // 删除最后的 "->"
      res.add(sb.toString());
      return;
    }

    // 递归和回溯是同时进行，所以要放在同一个花括号里
    if (root.left != null) { // 左
      getPath(root.left, res, path);
      path.remove(path.size() - 1);// 回溯
    }
    if (root.right != null) { // 右
      getPath(root.right, res, path);
      path.remove(path.size() - 1);// 回溯
    }

  }

}
