package graphtheory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DfsAndBfs {


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public static void dfs(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode currentNode = stack.pop();
      System.out.print(currentNode.val + " ");

      // 注意，我们先推右孩子，然后推左孩子到栈中
      // 这样可以保证左孩子先被处理（LIFO顺序）
      if (currentNode.right != null) {
        stack.push(currentNode.right);
      }
      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }
    }
  }


  public static void bfs(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      System.out.print(currentNode.val + " ");

      if (currentNode.left != null) {
        queue.offer(currentNode.left);
      }
      if (currentNode.right != null) {
        queue.offer(currentNode.right);
      }
    }
  }


}
