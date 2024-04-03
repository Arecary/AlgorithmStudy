package tree;

public class ConvertSortedArrayToBinarySearchTree_108 {


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

  // 个人思路：按照中序遍历的顺序，自然可以组成二叉树
  public TreeNode sortedArrayToBST(int[] nums) {
    TreeNode root = traversal(nums, 0, nums.length - 1);
    return root;
  }

  // 左闭右闭区间[left, right]
  private TreeNode traversal(int[] nums, int left, int right) {
    if (left > right) return null;

    int mid = left + ((right - left) >> 1);
    TreeNode root = new TreeNode(nums[mid]);
    root.left = traversal(nums, left, mid - 1);
    root.right = traversal(nums, mid + 1, right);
    return root;
  }


}
