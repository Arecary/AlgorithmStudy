package ershua;

import java.util.List;

public class LC120 {


  /*
  Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
   */


  public int minimumTotal(List<List<Integer>> triangle) {
    // 初始结果设为最大值
    int result = Integer.MAX_VALUE;
    int temp = 0;
    // 从顶点开始回溯
    result = helper(triangle, result, temp, 0, 0); // result是最终结果，temp是每一条路径的临时结果
    return result;
  }

  public int helper(List<List<Integer>> triangle, int result, int temp, int x, int y) {
    // 累加当前节点的值到temp
    temp += triangle.get(x).get(y);

    // 到达底层
    if (x == triangle.size() - 1) {
      // 比较当前路径的和是否比 result 更小，取较小值
      return Math.min(result, temp);
    }

    // 没到底，继续递归：
    // 往下一行的同列（x + 1, y）
    int left = helper(triangle, result, temp, x + 1, y);
    // 往下一行的下一列（x + 1, y + 1）
    int right = helper(triangle, result, temp, x + 1, y + 1);

    // 返回左右两条路径中较小的那个
    return Math.min(left, right);
  }


}
