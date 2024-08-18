package ershua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC145 {



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

  public List<Integer> postorderTraversal(TreeNode root) {

    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    helper(root, res);
    return res;

  }

  private void helper(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    helper(root.left, res);
    helper(root.right, res);
    res.add(root.val);
  }


  // 迭代法
  public List<Integer> postorderTraversal1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()){
      TreeNode node = stack.pop();
      res.add(node.val);
      if (node.left != null){
        stack.push(node.left);
      }
      if (node.right != null){
        stack.push(node.right);
      }
    }
    Collections.reverse(res);
    return res;

  }



}
