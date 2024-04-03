package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree_501 {


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


  // 方法1：遍历，然后用一个map记录每个数字出现的次数，最后找出出现次数最多的数字
  // 此方法要遍历两次map，可以改进：每次找到maxTime时先把对应元素放进list，
  // 如果之后碰到更大的maxTime，更新maxtime时，同时清空结果list再重新放元素进去
  // 这样只需要遍历一次map
  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> res = new HashMap<>();
    inorder(root, res);

    int maxTime = 0;
    List<Integer> modes = new ArrayList<>();

    // 先找到map里最大的value值，即tree里出现最多元素的次数
    for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
      maxTime = Math.max(maxTime, entry.getValue());
//      if (entry.getValue() > maxTime) {
//        maxTime = entry.getValue();
//      }
    }

    // 再把这个or这些元素本身找出来放进arraylist
    for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
      if (entry.getValue() == maxTime) {
        modes.add(entry.getKey());
      }
    }

    // 把arraylist转成list，这样节省空间，不然如果一开始就创建list[res.size]，有可能会很浪费
    int[] resArr = new int[modes.size()];
    for (int i = 0; i < modes.size(); i++) {
      resArr[i] = modes.get(i);
    }

    return resArr;

  }

  // inorder
  public void inorder(TreeNode root, Map<Integer, Integer> res) {
    if (root == null) {
      return;
    }
    //左
    inorder(root.left, res);
    //中
    res.put(root.val, res.getOrDefault(root.val, 0) + 1);
    //右
    inorder(root.right, res);

  }



  // 方法2: 根据BST的性质写
  ArrayList<Integer> resList;
  int maxCount;
  int count;
  TreeNode pre;

  public int[] findModeBST(TreeNode root) {
    resList = new ArrayList<>();
    maxCount = 0;
    count = 0;
    pre = null;
    findMode1(root);
    int[] res = new int[resList.size()];
    for (int i = 0; i < resList.size(); i++) {
      res[i] = resList.get(i);
    }
    return res;
  }

  public void findMode1(TreeNode root) {
    if (root == null) {
      return;
    }
    findMode1(root.left);

    int rootValue = root.val;
    // 计数
    if (pre == null || rootValue != pre.val) {
      count = 1;
    } else {
      count++;
    }
    // 更新结果以及maxCount
    if (count > maxCount) {
      resList.clear();
      resList.add(rootValue);
      maxCount = count;
    } else if (count == maxCount) {
      resList.add(rootValue);
    }
    pre = root;

    findMode1(root.right);
  }

}
