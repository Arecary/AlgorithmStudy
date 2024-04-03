package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

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

  // 根据106题
  public TreeNode buildTree(int[] preorder, int[] inorder) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
  }


  private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    int rootVal = preorder[preStart];
    TreeNode root = new TreeNode(rootVal);
    int rootIndex = map.get(rootVal);
    int leftSize = rootIndex - inStart;

    root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1, map);
    root.right = buildTree(preorder, inorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd, map);
    return root;

  }


}
