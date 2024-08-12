package ershua;

import java.util.ArrayList;
import java.util.List;

public class LC113 {


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

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    List<Integer> path = new ArrayList<>();
    findPath(root, targetSum, res, path);
    return res;

  }

  private void findPath(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
    path.add(root.val);
    if (root.left == null && root.right == null) {
      if (targetSum == root.val) {
        res.add(new ArrayList<>(path));
      }
      return;
    }

    if (root.left != null) {
      findPath(root.left, targetSum - root.val, res, path);
      path.remove(path.size() - 1);
    }

    if (root.right != null) {
      findPath(root.right, targetSum - root.val, res, path);
      path.remove(path.size() - 1);
    }
  }


}
