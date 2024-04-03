package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {

  /**
   * Definition for a binary tree node.
   */
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


  // 和102一样用BFS，但是只需要把每一层的最后一个加进去就行
  public List<Integer> rightSideView(TreeNode root) {

    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()){
      int temp = 0;
      int len = queue.size();

      while (len > 0) {
        TreeNode tmpNode = queue.poll();
        if (len == 1) {
          temp= tmpNode.val;
        }


        if (tmpNode.left != null) queue.offer(tmpNode.left);
        if (tmpNode.right != null) queue.offer(tmpNode.right);
        len--;
      }
      result.add(temp);

    }
    return result;
  }


}
