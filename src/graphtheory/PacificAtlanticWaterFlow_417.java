package graphtheory;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {


  // 四个位置
  private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  /**
   * @param heights 题目给定的二维数组
   * @param row 当前位置的行号
   * @param col 当前位置的列号
   * @param sign 记录是哪一条河，两条河中可以一个为 0，一个为 1
   * @param visited 记录这个位置可以到哪条河
   */
  public void dfs(int[][] heights, int row, int col, int sign, boolean[][][] visited) {
    for (int[] current: position) {
      int curRow = row + current[0], curCol = col + current[1];
      // 越界
      if (curRow < 0 || curRow >= heights.length || curCol < 0 || curCol >= heights[0].length)
        continue;
      // 高度不合适或者已经被访问过了
      if (heights[curRow][curCol] < heights[row][col] || visited[curRow][curCol][sign]) continue;
      visited[curRow][curCol][sign] = true;
      dfs(heights, curRow, curCol, sign, visited);
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int rowSize = heights.length, colSize = heights[0].length;
    List<List<Integer>> ans = new ArrayList<>();
    // 记录 [row, col] 位置是否可以到某条河，可以为 true，反之为 false；
    // 假设太平洋的标记为 1，大西洋为 0
    boolean[][][] visited = new boolean[rowSize][colSize][2];
    for (int row = 0; row < rowSize; row++) {
      visited[row][colSize - 1][0] = true;
      visited[row][0][1] = true;
      dfs(heights, row, colSize - 1, 0, visited);
      dfs(heights, row, 0, 1, visited);
    }
    for (int col = 0; col < colSize; col++) {
      visited[rowSize - 1][col][0] = true;
      visited[0][col][1] = true;
      dfs(heights, rowSize - 1, col, 0, visited);
      dfs(heights, 0, col, 1, visited);
    }
    for (int row = 0; row < rowSize; row++) {
      for (int col = 0; col < colSize; col++) {
        // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
        if (visited[row][col][0] && visited[row][col][1])
          ans.add(List.of(row, col));
      }
    }
    return ans;
  }

  ///////////////////////////////////////////

  // 从最外圈出发，把所有能流向太平洋和大西洋的点分别标记
  // 再遍历整个矩阵，找到既能流向太平洋又能流向大西洋的点
  public List<List<Integer>> pacificAtlantic2(int[][] heights) {
    if (heights == null || heights.length == 0 || heights[0].length == 0) {
      return new ArrayList<>();
    }

    int rowSize = heights.length, colSize = heights[0].length;
    List<List<Integer>> ans = new ArrayList<>();
    boolean[][] pacificVisited = new boolean[rowSize][colSize];
    boolean[][] atlanticVisited = new boolean[rowSize][colSize];

    // 先遍历最外圈
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        if (i != 0 && i != rowSize - 1 && j != 0 && j != colSize - 1) {
          continue;
        }
        // 从太平洋边界开始DFS
        if (i == 0 || j == 0) {
          dfs2(heights, i, j, pacificVisited);
        }
        // 从大西洋边界开始DFS
        if (i == rowSize - 1 || j == colSize - 1) {
          dfs2(heights, i, j, atlanticVisited);
        }
      }
    }

    // 再遍历整张图，找出既能流向太平洋又能流向大西洋的点
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        if (pacificVisited[i][j] && atlanticVisited[i][j]) {
          ans.add(List.of(i, j));
        }
      }
    }

    return ans;
  }

  // 深度优先搜索
  public void dfs2(int[][] heights, int i, int j, boolean[][] visited) {
    if (visited[i][j]) {
      return;
    }

    visited[i][j] = true;

    // 向四个方向延伸
    if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
      dfs2(heights, i + 1, j, visited);
    }
    if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
      dfs2(heights, i - 1, j, visited);
    }
    if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
      dfs2(heights, i, j + 1, visited);
    }
    if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
      dfs2(heights, i, j - 1, visited);
    }
  }





}
