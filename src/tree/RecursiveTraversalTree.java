package tree;

import java.util.List;

public class RecursiveTraversalTree {

  public static void main(String[] args) {


  }

  /**
   * Tree node.
   */
  public static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
      val = x;
    }

  }

  public List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
    // 处理root为null的情况
    if (root == null) {
      return list;
    }


    // 处理root为叶子节点的情况
    list.add(root.val);
    preorderTraversal(root.left, list);
    preorderTraversal(root.right, list);
    return list;
  }


  public List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
    // 处理root为null的情况
    if (root == null) {
      return list;
    }

    // 处理root为叶子节点的情况
    inorderTraversal(root.left, list);
    list.add(root.val);
    inorderTraversal(root.right, list);
    return list;
  }

  public List<Integer> postorderTraversal(TreeNode root, List<Integer> list) {
    // 处理root为null的情况
    if (root == null) {
      return list;
    }

    // 处理root为叶子节点的情况
    postorderTraversal(root.left, list);
    postorderTraversal(root.right, list);
    list.add(root.val);
    return list;
  }


}
