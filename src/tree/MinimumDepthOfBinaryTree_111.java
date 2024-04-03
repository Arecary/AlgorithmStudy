package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {


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


  // 和102一样的思路
  // 只不过这里需要记录层数
  // 需要注意的是，只有当左右孩子都为空的时候，才说明遍历的最低点了。如果其中一个孩子为空则不是最低点
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      depth++;
      TreeNode cur = null;
      for (int i = 0; i < size; i++) {
        cur = queue.poll();
        //如果当前节点的左右孩子都为空，直接返回最小深度
        if (cur.left == null && cur.right == null) {
          return depth;
        }
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
    }
    return depth;
  }
}
