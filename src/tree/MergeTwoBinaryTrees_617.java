package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees_617 {

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


  // 递归，本题使用哪种顺序遍历都是可以的！
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) return root2;
    if (root2 == null) return root1;

    root1.val += root2.val;
    root1.left = mergeTrees(root1.left,root2.left);
    root1.right = mergeTrees(root1.right,root2.right);
    return root1;
  }


  // 类似层序遍历，把每层的节点加起来，但是没有严格的区分每一层
  // 使用队列迭代
  public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
    if (root1 == null) return root2;
    if (root2 ==null) return root1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root1);
    queue.offer(root2);
    while (!queue.isEmpty()) {
      TreeNode node1 = queue.poll();
      TreeNode node2 = queue.poll();
      // 此时两个节点一定不为空，val相加
      node1.val = node1.val + node2.val;
      // 如果两棵树左节点都不为空，加入队列
      if (node1.left != null && node2.left != null) {
        queue.offer(node1.left);
        queue.offer(node2.left);
      }
      // 如果两棵树右节点都不为空，加入队列
      if (node1.right != null && node2.right != null) {
        queue.offer(node1.right);
        queue.offer(node2.right);
      }
      // 若node1的左节点为空，直接赋值
      if (node1.left == null && node2.left != null) {
        node1.left = node2.left;
      }
      // 若node1的右节点为空，直接赋值
      if (node1.right == null && node2.right != null) {
        node1.right = node2.right;
      }
    }
    return root1;
  }
}
