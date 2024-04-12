package dp;

public class BagProblem2 {

  // Ex:
  // 背包最大承重：50 千克
  // 物品清单：
  // 物品 A：重量 10 千克，价值 60 元
  // 物品 B：重量 20 千克，价值 100 元
  // 物品 C：重量 30 千克，价值 120 元

  public static void main(String[] args) {
    int bag = 50;
    int[] weight = new int[]{10, 20, 30};
    int[] value = new int[]{60, 100, 120};
    int res = maxValue(bag, value, weight);
    System.out.println("result is " + res);

  }

  // 递归尝试版本
  /**
   * 返回不超重情况下能装下货物的最大价值。
   *
   * @param bag 背包容量
   * @param v   货物价值数组
   * @param w   货物重量数组
   * @return 返回不超重情况下能装下货物的最大价值。
   */
  public static int maxValue(int bag, int[] v, int[] w) {
    // edge case
    if (v == null || w == null || w.length != v.length || bag <= 0 || w.length == 0) {
      return 0;
    }

    return way(bag, v, w, 0);
  }

  // index 代表我们现在正考虑哪一个index的物品。
  // 返回不考虑之前的货物，仅当前index货物下，背包能装货物的最大价值。


  public static int way(int rest, int[] v, int[] w, int index) {
    // base case
    if (rest < 0) {
      return -1;
    }
    if (index == v.length){
      return 0;
    }

    // 1. 不要当前货物
    int value1 = way(rest, v, w, index + 1);

    // 2. 要当前货物
    int next = way(rest - w[index], v, w, index + 1);
    int value2 = 0;
    if (next != -1) { // 等于-1说明当前货物太重，如果装了它袋子容量就变成负的了，所以无效
      value2 = v[index] + next;
    }

    return Math.max(value1, value2);
  }


  // dp版本
  public static int maxValue2(int bag, int[] v, int[] w) {
    // edge case
    if (v == null || w == null || w.length != v.length || bag <= 0 || w.length == 0) {
      return 0;
    }

    // 递归方法中的可变参数只有
    // 1. 背包容量
    // 2. 货物价值数组
    // 所以我们把dp表设为new int[n + 1][bag + 1]
    int n = v.length;
    int [][] dp = new int[n + 1][bag + 1];

    // 根据递归方法可知，当index == v.length时，dp[index][...] = 0;
    // 所以先填最下面一行为0，java数组初始化自动会填0
    // 再根据递归方法可知，表里的每一行都依赖下一行的值，因为递归方法里都依赖index + 1
    // 所以我们从下而上填表
    for (int index = n -1; index >= 0; index--){
      // 对于每一行来说，从左往右或是从右往左填表都一样，因为原递归方法中并没有规定，这里采用从左往右
        for (int rest = 0; rest <= bag; rest++) {

          // 这里直接抄递归方法里的策略
          int value1 = dp[index + 1][rest];
          int value2 = 0;
          int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
          if (next != -1) { // 等于-1说明当前货物太重，如果装了它袋子容量就变成负的了，所以无效
            value2 = v[index] + next;
          }

          dp[index][rest] = Math.max(value1, value2);

//          int value1 = way(rest, v, w, index + 1);
//          int next = way(rest - w[index], v, w, index + 1);
//          int value2 = 0;
//          if (next != -1) { // 等于-1说明当前货物太重，如果装了它袋子容量就变成负的了，所以无效
//            value2 = v[index] + next;
//          }
//
//          return Math.max(value1, value2);


        }
    }


    return dp[0][bag];
  }



/*
  public static int way1(int bag, int[] v, int[] w, int index) {
    // base case
    if (index == v.length){
      return 0;
    }

    // 1. 不要当前货物
    int value1 = way1(bag, v, w, index + 1);

    // 2. 要当前货物
    int value2;
    if (w[index] > bag) {
      // 当前货物超重了，不能装
      value2 = 0;
    }else {
      value2 = v[index] + way1(bag - w[index], v, w, index + 1);
    }

    return Math.max(value1, value2);
  }*/



}


