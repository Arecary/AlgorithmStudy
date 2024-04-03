package dp;

public class UniquePaths_62 {



  public int uniquePaths(int m, int n) {
    int [][] dp = new int[m][n];

    // init
    for(int i = 0; i < m; i++){ // 初始化第一列
      dp[i][0] = 1;
    }

    for(int i = 0; i < n; i++){ // 初始化第一行
      dp[0][i] = 1;
    }

    // 推导dp
    for(int i = 1; i < m; i++){
      for (int j= 1; j < n; j++){
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }

    return dp[m-1][n-1];
  }

}
