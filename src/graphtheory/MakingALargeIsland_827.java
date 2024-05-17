package graphtheory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland_827 {


  public int largestIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    // 先遍历一次图，找到每个岛的面积，存到map里
    int mark = 2; // 因为地图初始有0和1，所以标记从2开始
    int ans = 0;
    int size = grid.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (grid[i][j] == 1) {
          int areaSize = dfs(grid, i, j, mark);
          map.put(mark, areaSize); // key: 当前遍历到的岛屿的标记，value: 当前遍历到的岛屿的面积
          mark++;
        }
      }
    }

    // 在遍历一次图，此时把当前的格子变为1，然后看四个方向有没有相邻的岛，取最大值。
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (grid[i][j] != 0) { // 当前位置如果不是 0 那么直接跳过，因为我们只能把 0 变成 1
          continue;
        }
        int area = 1;
        Set<Integer> hashSet = new HashSet<>(); // 存放四个方向的mark，防止重复mark存在，比如一个格子上左都是同一个岛屿
        // 判断四个方向有没有相邻的岛
        // 判断上方
        if (i - 1 >= 0) {
          int upMark = grid[i - 1][j];
          hashSet.add(upMark);
        }

        // 判断下方
        if (i + 1 < size) {
          int downMark = grid[i + 1][j];
          hashSet.add(downMark);
        }

        // 判断左方
        if (j - 1 >= 0) {
          int leftMark = grid[i][j - 1];
          hashSet.add(leftMark);
        }

        // 判断右方
        if (j + 1 < size) {
          int rightMark = grid[i][j + 1];
          hashSet.add(rightMark);
        }

        if (!hashSet.isEmpty()){
          for (Integer item : hashSet) {
            if (item != 0) {
              area += map.get(item); // 取四个方向相邻的岛屿面积，然后相加
            }
          }
        }

        ans = Math.max(ans, area);

      }
    }

    return ans == 0 ? size * size : ans; // 处理全是 1 的特殊情况
  }

  // mark: 当前遍历到的岛屿的标记
  public int dfs(int[][] grid, int i, int j, int mark) {
    int size = grid.length;
    if (i < 0 || i >= size || j < 0 || j >= size || grid[i][j] != 1) {
      return 0;
    }
    int res = 1;

    grid[i][j] = mark;
    res += dfs(grid, i - 1, j, mark);
    res += dfs(grid, i + 1, j, mark);
    res += dfs(grid, i, j - 1, mark);
    res += dfs(grid, i, j + 1, mark);
    return res;
  }


}
