package graphtheory;

public class MaxAreaOfIsland_695 {

  public int maxAreaOfIsland(int[][] grid) {

    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int maxArea = 0;
    for (int i = 0; i <= grid.length - 1; i++) {
      for (int j = 0; j <= grid[0].length - 1; j++) {
        if (grid[i][j] == 1) {
          int area = dfs(grid, i, j);
          maxArea = Math.max(maxArea, area);
        }
      }
    }

    return maxArea;
  }

  public int dfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
      return 0;
    }
    grid[i][j] = 0;
    int res = 1;
    res += dfs(grid, i - 1, j);
    res += dfs(grid, i + 1, j);
    res += dfs(grid, i, j - 1);
    res += dfs(grid, i, j + 1);

    return res;
  }

}
