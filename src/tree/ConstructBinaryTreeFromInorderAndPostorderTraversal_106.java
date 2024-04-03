package tree;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {


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

  // 自己写的，跑的很慢，因为用了数组复制Arrays.copyOfRange，这个很慢，建议直接使用索引在原数组上操作。
  // 以 后序数组的最后一个元素为切割点，先切中序数组，根据中序数组，反过来再切后序数组。一层一层切下去，每次后序数组最后一个元素就是节点元素。
  // 后序数组的最后一个元素，就是当前二叉树的根节点
  public TreeNode buildTree(int[] inorder, int[] postorder) {

    if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
      return null;
    }

    if (inorder.length == 1) {
      return new TreeNode(inorder[0]);
    }

    Map<Integer, Integer> mapInorder = new HashMap<>();
    // Map<Integer, Integer> mapPostorder = new HashMap<>(); 没用到这个map

    for (int i = 0; i < inorder.length; i++) {
      mapInorder.put(inorder[i], i);
      // mapPostorder.put(postorder[i], i);
    }

    int rootVal = postorder[postorder.length - 1];
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = mapInorder.get(rootVal);

    int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
    int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
    int leftLength = leftInorder.length;
    int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftLength);
    int[] rightPostorder = Arrays.copyOfRange(postorder, leftLength, postorder.length - 1);


    root.left = buildTree(leftInorder, leftPostorder);
    root.right = buildTree(rightInorder, rightPostorder);

    return root;
  }


  // 答案
  // 使用索引在原数组上直接操作，所以快。
  // 注意：对索引进行 -1 操作的原因是为了正确地分割左右子树，同时确保根节点不被包含在任何子树的遍历数组中。
  public TreeNode buildTree1(int[] inorder, int[] postorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++){
      map.put(inorder[i], i);
    }
    return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
  }
  private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> map){
    if (inStart > inEnd || postStart > postEnd){
      return null;
    }
    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);
    int rootIndex = map.get(rootVal);
    int leftSize = rootIndex - inStart;
    root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1, map);
    root.right = buildTree(inorder, postorder, inStart + leftSize + 1, inEnd, postStart + leftSize, postEnd - 1, map);
    return root;
  }


}
