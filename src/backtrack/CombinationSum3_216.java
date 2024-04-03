package backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {


  // 本题就是在[1,2,3,4,5,6,7,8,9]这个集合中找到和为n的k个数的组合。
  // 类似于77题


  List<List<Integer>> result = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {

    backtrack(k, n, 1);
    return result;

  }

  private void backtrack(int k, int n, int startIndex) {

    if (path.size() == k && isValid(path, n)) {
      result.add(new ArrayList<>(path)); // 注意不能直接add path，
      // 因为path是引用类型，会改变原path
      return;
    }
    if (path.size() == k && !isValid(path, n)) {
      return;
    }

    for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
      path.add(i);
      backtrack(k, n, i + 1);
      path.remove(path.size() - 1);
    }

  }

  private boolean isValid(List<Integer> path, int n) {
    int sum = 0;
    for (Integer ele : path) {
      sum += ele;
    }
    return sum == n;
  }
}
