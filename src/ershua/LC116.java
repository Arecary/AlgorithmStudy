package ershua;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC116 {


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};



  public Node connect(Node root) {

      Deque<Node> queue = new ArrayDeque<>();
      if (root != null) queue.add(root);

      while (!queue.isEmpty()) {
          int len = queue.size();

          while (len != 0) {
              Node cur = queue.poll();
              if (len == 1) {
                  cur.next = null;
              }else {
                  cur.next = queue.peek();
              }
              if (cur.left != null) {
                  queue.add(cur.left);
              }
              if (cur.right != null) {
                  queue.add(cur.right);
              }
              len--;
          }
      }

      return root;
  }


}
