package tree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
public class N_aryTreeLevelOrderTraversal_429 {




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
}


  // 和102一样，但是每层的size不一样，每个node的孩子不止两个，而是一个list
  // 解法：BFS
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> list = new ArrayList<>();
    Deque<Node> que = new LinkedList<>();

    if (root == null) {
      return list;
    }

    que.offerLast(root);
    while (!que.isEmpty()) {
      int levelSize = que.size();
      List<Integer> levelList = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        Node poll = que.pollFirst();

        levelList.add(poll.val);

        List<Node> children = poll.children;
        if (children == null || children.size() == 0) {
          continue;
        }
        for (Node child : children) {
          if (child != null) {
            que.offerLast(child);
          }
        }
      }
      list.add(levelList);
    }

    return list;
  }


}
