package graphtheory;

public class IslandPerimeter_463 {


  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int result = 0;


    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) { // 因为题目中说只有一个岛
          result = dfs(i, j, grid);
        }
      }
    }
    return result;
  }

  private int dfs(int i, int j, int[][] grid) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
      return 1;
    }
    if (grid[i][j] == 2) {
      return 0;
    }
    int res = 0;
    grid[i][j] = 2;
    res += dfs(i - 1, j, grid);
    res += dfs(i + 1, j, grid);
    res += dfs(i, j - 1, grid);
    res += dfs(i, j + 1, grid);


    return res;
  }

  // 这个最快
/*
具体来说，对于每个陆地单元格：

初始周长增加4。
如果上方有相邻的陆地单元格，则减少2，因为它们共享一条边。
如果左边有相邻的陆地单元格，也减少2，因为它们也共享一条边。
这种方法的时间复杂度是 O(m * n)，其中 m 是网格的行数，n 是网格的列数。相比递归方法，这种迭代方法更简单且更高效。

通过只检查上方和左方的单元格就能覆盖所有共享边的情况
 */
  public int islandPerimeter2(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          res += 4;
          if (i > 0 && grid[i - 1][j] == 1) res -= 2;
          if (j > 0 && grid[i][j - 1] == 1) res -= 2;
        }

      }
    }

    return res;
  }



  // 这是检查四条边的方法
  int[] dirx = {-1, 1, 0, 0};
  int[] diry = {0, 0, -1, 1};

  public int islandPerimeter1(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int res = 0; // 岛屿周长
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          for (int k = 0; k < 4; k++) {
            int x = i + dirx[k];
            int y = j + diry[k];
            // 当前位置是陆地，并且从当前位置4个方向扩展的“新位置”是“水域”或“新位置“越界，则会为周长贡献一条边
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
              res++;
              continue;
            }
          }
        }
      }
    }
    return res;
  }


}
