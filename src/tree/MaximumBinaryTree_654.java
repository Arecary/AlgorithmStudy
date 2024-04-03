package tree;

public class MaximumBinaryTree_654 {
  //Definition for a binary tree node.
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


  // 递归
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTree1(nums, 0, nums.length);
  }

  public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
    if (rightIndex - leftIndex < 1) {// 没有元素了
      return null;
    }
    if (rightIndex - leftIndex == 1) {// 只有一个元素
      return new TreeNode(nums[leftIndex]);
    }
    // 下面的for循环是找到数组里的最大值以确定root节点位置
    int maxIndex = leftIndex;// 最大值所在位置
    int maxVal = nums[maxIndex];// 最大值
    for (int i = leftIndex + 1; i < rightIndex; i++) {
      if (nums[i] > maxVal) {
        maxVal = nums[i];
        maxIndex = i;
      }
    }

    // 递归构建左右子树
    TreeNode root = new TreeNode(maxVal);
    // 根据maxIndex划分左右子树
    root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
    root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
    return root;
  }


}
