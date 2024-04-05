package dp;

public class BagProblem {

  public static void main(String[] args) {
    int[] weight = {1,3,4};
    int[] value = {15,20,30};
    int bagSize = 4;
    int res = bagProblems(weight,value,bagSize);
    System.out.println(res);
  }

  // 01 背包：
  // 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
  // 物品0：重量1 价值15
  // 物品1：重量3 价值20
  // 物品2：重量4 价值30
  // 背包最大重量为4


  // 二维数组
  // dp[i][j] 表示从下标为[0-i]的物品中任意取出，放进容量为j的背包，价值总和最大是多少。
  // 递推公式：
  // dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])

  public static int bagProblems(int[] weight,int[] value,int bagSize){
    int [][] dp = new int[weight.length][bagSize + 1];
    for (int i = 1; i <= bagSize; i++) {
      dp[0][i] = value[0];
    }

    for (int i = 1; i < weight.length; i++) { // 遍历一次物品
      for (int j = 1; j <= bagSize; j++) { // 背包遍历一次

        if (j < weight[i]) {
          /**
           * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
           * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
           */
          dp[i][j] = dp[i-1][j];
        } else {
          int not = dp[i-1][j];
          int yes = dp[i-1][j-weight[i]] + value[i];
          dp[i][j] = Math.max(not, yes);
        }

      }
    }
    return dp[weight.length-1][bagSize];
  }


  // 一维数组
  // dp[j] 表示从下标为[0-i]的物品中任意取出，放进容量为j的背包，价值总和最大是多少。
  // 递推公式：
  // dp[j] = max(dp[j], dp[j-weight[i]] + value[i])
  // 初始化：



}
