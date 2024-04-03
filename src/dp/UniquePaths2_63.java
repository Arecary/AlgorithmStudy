package dp;

import java.util.Arrays;

public class UniquePaths2_63 {

  public static void main(String[] args) {
    int[][] obstacleGrid = {
            {0, 0},
            {1, 1},
            {0, 0}
    };

    int res = uniquePathsWithObstacles1(obstacleGrid);
    System.out.println("res is " + res);

  }



  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    //如果在起点或终点出现了障碍，直接返回0
    if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
      return 0;
    }

    // init
    for(int i = 0; i < m; i++){
      if (obstacleGrid[i][0] == 0) { // 初始化第一列, 如果是障碍就空着默认初始化的0
        dp[i][0] = 1;
      }else {
        break;
      }
    }

    for(int i = 0; i < n; i++){
      if (obstacleGrid[0][i] == 0) { // 初始化第一行, 如果是障碍就空着默认初始化的0
        dp[0][i] = 1;
      }else {
        break;
      }
    }

    // 推导dp
    for(int i = 1; i < m; i++){
      for (int j= 1; j < n; j++){
        if (obstacleGrid[i][j] == 0) {
          dp[i][j] = dp[i-1][j] + dp[i][j-1]; // 如果在原图里不是障碍，再赋值
        }
      }
    }

    return dp[m - 1][n - 1];
  }


  public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    //如果在起点或终点出现了障碍，直接返回0
    if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
      return 0;
    }

    for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
      dp[i][0] = 1;
    }
    for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
      dp[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
      }
    }
    return dp[m - 1][n - 1];
  }

}
