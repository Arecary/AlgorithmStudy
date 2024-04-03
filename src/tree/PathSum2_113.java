package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2_113 {


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


  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res; // 非空判断
    pathSumHelper(root, targetSum, res, new ArrayList<>());
    // preorderdfs(root, targetSum, res, new ArrayList<>());
    return res;

  }

  private void pathSumHelper(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
    path.add(root.val);
    targetSum -= root.val;

    // 说明找到一条root到leaf的有效路径了
    if (root.left == null && root.right == null && targetSum == 0){
      res.add(new ArrayList<>(path));
    }else { // 说明没到leaf或者是leaf但是路径不符合
      if (root.left != null) {
        pathSumHelper(root.left, targetSum, res, path);
      }
      if (root.right != null) {
        pathSumHelper(root.right, targetSum, res, path);
      }
    }
    // 走到这一步说明，要么之前到底了但是没找到符合的路径，所以回溯
    // 要么已经找到一条路径了，但是也要回溯
    path.remove(path.size()- 1);
  }

  // 答案
  // 在每次递归调用返回后执行回溯操作，无论是探索左子树还是右子树。
  public void preorderdfs(TreeNode root, int targetsum, List<List<Integer>> res, List<Integer> path) {
    path.add(root.val);
    // 遇到了叶子节点
    if (root.left == null && root.right == null) {
      // 找到了和为 targetsum 的路径
      if (targetsum - root.val == 0) {
        res.add(new ArrayList<>(path));
      }
      return; // 如果和不为 targetsum，返回
    }

    if (root.left != null) {
      preorderdfs(root.left, targetsum - root.val, res, path);
      path.remove(path.size() - 1); // 回溯
    }
    if (root.right != null) {
      preorderdfs(root.right, targetsum - root.val, res, path);
      path.remove(path.size() - 1); // 回溯
    }
  }

}
