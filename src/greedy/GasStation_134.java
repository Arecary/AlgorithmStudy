package greedy;

public class GasStation_134 {



  public int canCompleteCircuit(int[] gas, int[] cost) {
    int curSum = 0;
    int totalSum = 0; // 考虑的是整个环路的总体情况。只有当totalSum最终为正数时，才说明存在至少一个起点可以完成环行，所以也不需要重置。
    int index = 0;
    for (int i = 0; i < gas.length; i++) {
      curSum += gas[i] - cost[i];
      totalSum += gas[i] - cost[i];
      if (curSum < 0) {
        index = (i + 1) % gas.length ; // 当i是数组的最后一个索引（即i = gas.length - 1）时，下一个起点i + 1应该是数组的第一个位置，即0。
        // 这里需要对i + 1取模，确保它是一个有效的索引。确保当i + 1超出数组长度时，我们能够回到数组的开头。
        curSum = 0;
      }
    }
    if (totalSum < 0) return -1;
    return index;
  }
}
