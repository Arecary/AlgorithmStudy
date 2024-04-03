package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116 {

  // Definition for a Node.
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  // base on 102
  // 只不过在单层遍历的时候手动将next指向queue.peek
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int len = queue.size();

      while (len > 0) {
        Node current = queue.poll();
        // 防止每一层最后一个node的next指向下一层，所以当len == 1时，应该不设置next
        if (len > 1) {
          current.next = queue.peek();
        }

        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }

        len--;
      }
    }
    return root;
  }

}
