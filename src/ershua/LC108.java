package ershua;

public class LC108 {


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


  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }

    int mid = left + (right - left) / 2;  // 中间位置

    TreeNode root = new TreeNode(nums[mid]);  // 以中间元素为根节点
    root.left = helper(nums, left, mid - 1);  // 递归构建左子树
    root.right = helper(nums, mid + 1, right);  // 递归构建右子树

    return root;
  }

}
