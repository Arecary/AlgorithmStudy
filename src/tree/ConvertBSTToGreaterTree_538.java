package tree;

import java.util.Stack;

public class ConvertBSTToGreaterTree_538 {

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


  // 就是反中序遍历，加上累加值
  // 换一个角度来看，这就是一个有序数组[2, 5, 13]，求从后到前的累加数组，也就是[20, 18, 13]
  // 从树中可以看出累加的顺序是右中左，所以我们需要反中序遍历这个二叉树，然后顺序累加就可以了。
  // 需要注意的是，累加的结果需要存储在当前节点的val中，而不是返回。
  // pre指针记录当前遍历节点cur的前一个节点，这样才方便做累加。


  // 递归
  int sum;
  public TreeNode convertBST2(TreeNode root) {
    sum = 0;
    convertBST1(root);
    return root;
  }

  // 按右中左顺序遍历，累加即可
  public void convertBST1(TreeNode root) {
    if (root == null) {
      return;
    }
    convertBST1(root.right);
    sum += root.val;
    root.val = sum;
    convertBST1(root.left);
  }

  // 迭代法
  //DFS iteraion統一迭代法
  public TreeNode convertBST(TreeNode root) {
    int pre = 0;
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) //edge case check
      return null;

    stack.add(root);

    while (!stack.isEmpty()) {
      TreeNode curr = stack.peek();
      //curr != null的狀況，只負責存node到stack中
      if (curr != null) {
        stack.pop();
        if (curr.left != null)       //左
          stack.add(curr.left);
        stack.add(curr);            //中
        stack.add(null);
        if (curr.right != null)      //右
          stack.add(curr.right);
      } else {
        //curr == null的狀況，只負責做單層邏輯
        stack.pop();
        TreeNode temp = stack.pop();
        temp.val += pre;
        pre = temp.val;
      }
    }
    return root;
  }
}
