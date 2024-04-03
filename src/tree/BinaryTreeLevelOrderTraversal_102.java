package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

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




  // 这题就是BFS
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()){
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
    return result;
  }

  //DFS--递归方式
  public List<List<Integer>> resList = new ArrayList<List<Integer>>();

  public List<List<Integer>> levelOrder1(TreeNode root) {
    checkFun01(root,0);

    return resList;
  }

    public void checkFun01(TreeNode node, Integer deep) {
    if (node == null) return;
    deep++;

    if (resList.size() < deep) {
      //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
      List<Integer> item = new ArrayList<Integer>();
      resList.add(item);
    }
    resList.get(deep - 1).add(node.val);

    checkFun01(node.left, deep);
    checkFun01(node.right, deep);
  }

}
