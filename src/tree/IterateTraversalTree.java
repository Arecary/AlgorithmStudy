package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterateTraversalTree {


  /**
   * Tree node.
   */
  public static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
      val = x;
    }

  }


  /**
   * 前序遍历
   * 前序遍历是中左右，每次先处理的是中间节点，那么先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子。
   * 这样出栈的顺序就是中左右了
   * 前序遍历顺序：中-左-右，入栈顺序：中-右-左
   * @param root TreeNode
   * @return List of node val.
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null){
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()){
      TreeNode node = stack.pop();
      result.add(node.val);
      if (node.right != null){
        stack.push(node.right);
      }
      if (node.left != null){
        stack.push(node.left);
      }
    }
    return result;
  }


  /**
   * 中序遍历
   * 在使用迭代法写中序遍历，就需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素。
   * 中序遍历顺序: 左-中-右 入栈顺序： 左-右
   * @param root TreeNode
   * @return List of node val.
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null){
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()){
      if (cur != null){
        stack.push(cur);
        cur = cur.left;
      }else{
        cur = stack.pop();
        result.add(cur.val);
        cur = cur.right;
      }
    }
    return result;
  }


  // 中序遍历的第二种写法，是遍历树的迭代通用写法，按顺序从root开始把他和子节点放进stack
  // 在中间节点后面塞一个null，这样如果弹出来的是null，那么下一个节点就是中间节点
  // null用于标记一个节点已经被访问过（其左子节点已经被考虑过），现在需要处理这个节点（将其值加入结果集）然后考虑其右子节点。
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> st = new Stack<>();
    if (root != null) st.push(root);
    while (!st.empty()) {
      TreeNode node = st.peek();
      if (node != null) {
        st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
        if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
        st.push(node);                          // 添加中节点
        st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

        if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
      } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
        st.pop();           // 将空节点弹出
        node = st.peek();    // 重新取出栈中元素
        st.pop();
        result.add(node.val); // 加入到结果集
      }
    }
    return result;
  }

  /**
   * 后序遍历
   * 把先序遍历改一下，先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了
   * 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null){
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()){
      TreeNode node = stack.pop();
      result.add(node.val);
      if (node.left != null){
        stack.push(node.left);
      }
      if (node.right != null){
        stack.push(node.right);
      }
    }
    Collections.reverse(result);
    return result;
  }

}
