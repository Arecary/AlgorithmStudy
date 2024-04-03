package tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 这题两个陷阱
// 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。我们要比较的是 左子树所有节点小于中间节点，右子树所有节点大于中间节点。
// 样例中最小节点 可能是int的最小值，如果这样使用最小的int来比较也是不行的。此时可以初始化比较元素为longlong的最小值。
public class ValidateBinarySearchTree_98 {

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

  // 最容易想到的办法是中序遍历返回数组，然后判断是否是升序的。因为这是BST
  public boolean isValidBST2(TreeNode root) {
    List<Integer> res = inorderTraversal(root, new ArrayList<>());
    return isSorted(res);
  }

  private List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
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

  private boolean isSorted(List<Integer> list) {
    long pre = Long.MIN_VALUE; // 初始化pre为long的最小值，这样就可以处理root为null的情况,而且防止原二叉树里有节点值是int的最小值
    for (int element : list) {
      int cur = element;
      if (pre >= cur) {
        return false;
      }
      pre = cur; // 强转
    }
    return true;
  }

  // 递归
  // 复杂版
  TreeNode max;
  public boolean isValidBST3(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 左
    boolean left = isValidBST(root.left);
    if (!left) {
      return false;
    }
    // 中
    if (max != null && root.val <= max.val) {
      return false;
    }
    max = root;
    // 右
    boolean right = isValidBST(root.right);
    return right;
  }

  // 简化版
  public boolean isValidBST(TreeNode root) {
    return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
  }

  boolean validBST(long lower, long upper, TreeNode root) {
    if (root == null) return true;
    if (root.val <= lower || root.val >= upper) return false;
    return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
  }


  // 迭代
  public boolean isValidBST1(TreeNode root) {
    if (root == null) {
      return true;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;// 左
      }
      // 中，处理
      TreeNode pop = stack.pop();
      if (pre != null && pop.val <= pre.val) {
        return false;
      }
      pre = pop;

      root = pop.right;// 右
    }
    return true;
  }

}
