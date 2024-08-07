package ershua;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC429 {


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


  public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
          return res;
      }

      Deque<Node> queue = new ArrayDeque<>();
      queue.add(root);

      while (!queue.isEmpty()) {
          List<Integer> temp = new ArrayList<>();
          int len = queue.size();
          while (len != 0) {
              Node cur = queue.poll();
              temp.add(cur.val);
              List<Node> child = cur.children;
              if (child == null || child.isEmpty()) {
                  continue;
              }
              for (Node n : child) {
                  if (n != null) {
                      queue.add(n);
                  }
              }
              len --;
          }
          res.add(temp);
      }
      return res;


  }




}
