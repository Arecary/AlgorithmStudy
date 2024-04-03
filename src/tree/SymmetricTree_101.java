package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 对称二叉树
public class SymmetricTree_101 {


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


  // 基于102 BFS层序遍历的变种
  // 把每层的所有节点放进一个list包括null，然后检查这个list是否对称
  // 注意：这里需要把每层的所有节点都放进list，不能只放非空节点，因为如果某一层只有右节点没有左节点，那么这个list长度就不对了
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> values = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        // 对于空节点，我们添加一个特殊值（如null）来代表空
        if (node == null) {
          values.add(null);
        } else {
          values.add(node.val);
          // 即使子节点为空，也加入到队列中，以保持正确的结构
          queue.add(node.left);
          queue.add(node.right);
        }
      }

      // 检查当前层的列表是否对称
      if (!isListSymmetric(values)) {
        return false;
      }
    }
    return true;
  }

  private boolean isListSymmetric(List<Integer> list) {
    int start = 0, end = list.size() - 1;
    while (start < end) {
      if (list.get(start) != list.get(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }




  /**
   * 递归法
   */
  public boolean isSymmetric1(TreeNode root) {
    return compare(root.left, root.right);
  }

  private boolean compare(TreeNode left, TreeNode right) {

    if (left == null && right != null) {
      return false;
    }
    if (left != null && right == null) {
      return false;
    }

    if (left == null && right == null) {
      return true;
    }
    if (left.val != right.val) {
      return false;
    }
    // 比较外侧
    boolean compareOutside = compare(left.left, right.right);
    // 比较内侧
    boolean compareInside = compare(left.right, right.left);
    return compareOutside && compareInside;
  }

}
