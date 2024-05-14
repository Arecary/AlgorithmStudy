package graphtheory;

public class NumberOfEnclaves_1020 {



  public int numEnclaves(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int maxArea = 0;
    for (int i = 0; i <= grid.length - 1; i++) {
      for (int j = 0; j <= grid[0].length - 1; j++) {
        if (grid[i][j] == 1) {
          int[] currentArea = dfs(grid, i, j);
          if (currentArea[1] == 1) {
            maxArea += currentArea[0];
          }
        }
      }
    }
    return maxArea;
  }


  // 加一个判断条件，如果当前格子在边界上，那么res就设为0，因为不满足孤岛的条件
  public int[] dfs(int[][] grid, int i, int j) {
    int flag = 1;
    // 检查是否越界或者已经访问过
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return new int[]{0, 0}; // 已经在边界外，返回面积为0，标记为接触边界
    }
    if (grid[i][j] != 1) {
      return new int[]{0, 1}; // 如果是水或已经访问过，返回面积0，孤岛标记1
    }
    grid[i][j] = 0;
    int res = 1;
    if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
      flag = 0;
    }

    int[][] result = new int[][] {
            dfs(grid, i - 1, j),
            dfs(grid, i + 1, j),
            dfs(grid, i, j - 1),
            dfs(grid, i, j + 1)
    };

    for (int[] r : result) {
      res += r[0];
      flag = flag * r[1];
    }

    return new int[]{res, flag};
  }


}
