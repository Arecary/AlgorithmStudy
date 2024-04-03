package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2_107 {

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



  // 相对于102.二叉树的层序遍历，就是最后把result数组反转一下就可以了。
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int len = queue.size();

      while (len > 0) {
        TreeNode tmpNode = queue.poll();
        temp.add(tmpNode.val);

        if (tmpNode.left != null) queue.offer(tmpNode.left);
        if (tmpNode.right != null) queue.offer(tmpNode.right);
        len--;
      }
      result.add(temp);

    }

    List<List<Integer>> resultTure = new ArrayList<>();
    for (int i = result.size() - 1; i >= 0; i-- ) {
      resultTure.add(result.get(i));
    }
    return resultTure;
  }


}
