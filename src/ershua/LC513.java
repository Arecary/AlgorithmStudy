package ershua;

import java.util.LinkedList;
import java.util.Queue;

public class LC513 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue1(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }


    // 层序遍历 好理解
  public int findBottomLeftValue(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int res = 0;
      while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              TreeNode poll = queue.poll();
              if (i == 0) {
                  res = poll.val;
              }
              if (poll.left != null) {
                  queue.offer(poll.left);
              }
              if (poll.right != null) {
                  queue.offer(poll.right);
              }
          }
      }
      return res;
  }






}
