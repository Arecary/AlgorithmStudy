package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths_257 {

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


  /**
   * 递归法
   */
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();// 存最终的结果
    if (root == null) {
      return res;
    }
    List<Integer> paths = new ArrayList<>();// 作为结果中的路径
    traversal(root, paths, res);
    return res;
  }

  // 这里回溯的意思是，一旦return了，说明已经找到一条路了，返回上一层的时候就要把之前的节点去掉，
  // 因为只要返回上一层，就说明刚刚那层的节点已经在一条已知的path里了，而这个path已经被记录到res里了。
  private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
    paths.add(root.val);// 前序遍历，中
    // 遇到叶子结点
    if (root.left == null && root.right == null) {
      // 输出
      StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
      for (int i = 0; i < paths.size() - 1; i++) {
        sb.append(paths.get(i)).append("->");
      }
      sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
      res.add(sb.toString());// 收集一个路径
      return;
    }
    // 递归和回溯是同时进行，所以要放在同一个花括号里
    if (root.left != null) { // 左
      traversal(root.left, paths, res);
      paths.remove(paths.size() - 1);// 回溯
    }
    if (root.right != null) { // 右
      traversal(root.right, paths, res);
      paths.remove(paths.size() - 1);// 回溯
    }
  }


  /**
   * 迭代法
   */
  public List<String> binaryTreePaths1(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null)
      return result;
    Stack<Object> stack = new Stack<>();
    // 节点和路径同时入栈
    stack.push(root);
    stack.push(root.val + "");
    while (!stack.isEmpty()) {
      // 节点和路径同时出栈
      String path = (String) stack.pop();
      TreeNode node = (TreeNode) stack.pop();
      // 若找到叶子节点
      if (node.left == null && node.right == null) {
        result.add(path);
      }
      //右子节点不为空
      if (node.right != null) {
        stack.push(node.right);
        stack.push(path + "->" + node.right.val);
      }
      //左子节点不为空
      if (node.left != null) {
        stack.push(node.left);
        stack.push(path + "->" + node.left.val);
      }
    }
    return result;
  }
}
