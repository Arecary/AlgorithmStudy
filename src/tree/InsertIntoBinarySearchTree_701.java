package tree;

public class InsertIntoBinarySearchTree_701 {

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


  // 个人思路：
  // 既然是BST，那么就对比节点大小
  // 如果比当前节点小，就往左走，如果比当前节点大，就往右走
  // 留一个pre节点，如果比pre小，但是大于当前节点，就说明找到位置了，位于pre和cur之间
  // 如果cur == null，pre就是插入位置


  // 答案：
  // 个人思路最后两行冗余错误了，在BST里我们不需要破坏原树的结构
  // ex：原树是 7
  //           |
  //           3
  //          / \
  //         1   5
  // 插入 4，不是插入3和5中间，而是加入5的左子结点
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
      return new TreeNode(val);

    if (root.val < val){
      root.right = insertIntoBST(root.right, val); // 递归创建右子树
    }else if (root.val > val){
      root.left = insertIntoBST(root.left, val); // 递归创建左子树
    }
    return root;
  }
}
