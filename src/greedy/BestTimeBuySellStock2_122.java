package greedy;


/**
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class BestTimeBuySellStock2_122 {


  /**
   * 思路是只要看当前减去前一天是不是正的，是的话就收集这个profit，因为只能持有一个股票
   * 假如第 0 天买入，第 3 天卖出，那么利润为：prices[3] - prices[0]。
   *
   * 相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
   *
   * 此时就是把利润分解为每天为单位的维度，而不是从 0 天到第 3 天整体去考虑！
   *
   * 那么根据 prices 可以得到每天的利润序列：(prices[i] - prices[i - 1]).....(prices[1] - prices[0])。
   */
  public int maxProfit(int[] prices) {
    int result = 0;
    for (int i = 1; i < prices.length; i++) {
      result += Math.max(prices[i] - prices[i - 1], 0);
    }
    return result;
  }




}
