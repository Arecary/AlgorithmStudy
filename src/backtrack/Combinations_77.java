package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {


  // 解法1：多层for循环


  // 回溯 回溯问题看成一个n岔树，我们要的答案就是叶子结点
  // 回溯问题一般用递归解决

/*  List<List<Integer>> result= new ArrayList<>(); // 存放最后找到的组合
  LinkedList<Integer> path = new LinkedList<>(); // 找到的一个组合
  public List<List<Integer>> combine(int n, int k) {
    backtracking(n,k,1); // StartIndex 录下一层递归，搜索的起始位置
    return result;
  }

  public void backtracking(int n,int k,int startIndex){
    if (path.size() == k){
      result.add(new ArrayList<>(path)); // 回溯终止条件，把找到的组合加入到result里，同时返回上一层
      return;
    }
    for (int i =startIndex;i<=n;i++){
      path.add(i);
      backtracking(n,k,i+1);
      path.removeLast(); // 此时下一层的结果已经被添加到result里了，同时返回到了这一层，这时就要回溯，把刚才添加的元素撤销。
    }
  }*/


  // 带有剪枝的回溯
  List<List<Integer>> result = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();
  public List<List<Integer>> combine(int n, int k) {
    combineHelper(n, k, 1);
    return result;
  }

  /**
   * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
   * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
   */
  private void combineHelper(int n, int k, int startIndex){
    //终止条件
    if (path.size() == k){
      result.add(new ArrayList<>(path));// 注意不能直接add path，
      // 因为path是引用类型，会改变原path
      return;
    }
    for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
      path.add(i);
      combineHelper(n, k, i + 1);
      path.removeLast();
    }
  }



  // 更快地剪枝
  List<List<Integer>> result1;
  public List<List<Integer>> combine1(int n, int k) {
    result1 = new ArrayList<>();
    combineHelper(1, n, k, new ArrayList<>());
    return result1;
  }
  public void combineHelper(int start, int n, int k, ArrayList<Integer> combination) {
    if (k == 0) {
      result1.add(new ArrayList<>(combination));
      return;
    }
    for (int i = start; i <= n - k + 1; i++) {
      combination.add(i);
      combineHelper(i + 1, n, k - 1, combination);
      combination.remove(combination.size() - 1);
    }
  }
}
