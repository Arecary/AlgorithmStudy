package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {


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


  // 102的基础上算一下每层平均值
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int len = queue.size();
      int size = queue.size();
      double sum = 0;

      while (len > 0) {
        TreeNode temp = queue.poll();
        sum += temp.val;

        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
        len--;
      }

      double ave = sum / size;
      result.add(ave);

    }

    return result;
  }



}
