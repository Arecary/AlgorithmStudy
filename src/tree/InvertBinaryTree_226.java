package tree;


import java.util.ArrayDeque;

// 反转二叉树
public class InvertBinaryTree_226 {

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

  // 递归DFS

  /**
   * 前后序遍历都可以
   * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    // 对于反转二叉树，意味着你首先需要反转当前节点的所有子节点的子树，然后才能反转当前节点的直接子节点。
    invertTree(root.left);
    invertTree(root.right);
    swapChildren(root);
    return root;
  }

  private void swapChildren(TreeNode root) {
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
  }


  // 迭代BFS,就是102的层序遍历法levelorder traversal
  public TreeNode invertTree1(TreeNode root) {
    if (root == null) {
      return null;
    }
    ArrayDeque<TreeNode> deque = new ArrayDeque<>();
    deque.offer(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      while (size-- > 0) {
        TreeNode node = deque.poll();
        // 注意这里是先交换，再把孩子进队列
        swap(node);
        if (node.left != null) deque.offer(node.left);
        if (node.right != null) deque.offer(node.right);
      }
    }
    return root;
  }

  public void swap(TreeNode root) {
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }

}
