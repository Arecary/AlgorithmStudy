package ershua;

public class LC121 {



  public int maxProfit(int[] prices) {
    int res = 0;
    int minPrice = Integer.MAX_VALUE; // 初始最小价格设置为一个很大的值

    for (int i = 0; i < prices.length; i++) {
      // 更新最小价格
      minPrice = Math.min(minPrice, prices[i]);
      // 计算当前的最大利润
      res = Math.max(res, prices[i] - minPrice);
    }

    return res;
  }


}
