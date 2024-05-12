package graphtheory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfIslands_200 {

  /*
  Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
   */


  // DFS递归
  public int numIslands(char[][] grid) {
    int res = 0; //记录找到的岛屿数量
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        //找到“1”，res加一，同时淹没这个岛
        if (grid[i][j] == '1') {
          res++;
          dfs(grid, i, j);
        }
      }
    }
    return res;
  }

  //使用DFS“淹没”岛屿
  public void dfs(char[][] grid, int i, int j) {
    //搜索边界：索引越界或遍历到了"0"
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
    //将这块土地标记为"0"
    grid[i][j] = '0';
    //根据"每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成"，对上下左右的相邻顶点进行dfs
    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }


  // DFS stack版本
  public int numIslands2(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int numIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          numIslands++;
          grid[i][j] = '0'; // mark as visited
          Stack<int[]> stack = new Stack<>();
          stack.push(new int[]{i, j});

          while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            // Check all four directions and push to stack if '1' is found
            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
              stack.push(new int[]{row - 1, col});
              grid[row - 1][col] = '0'; // mark as visited
            }
            if (row + 1 < grid.length && grid[row + 1][col] == '1') {
              stack.push(new int[]{row + 1, col});
              grid[row + 1][col] = '0'; // mark as visited
            }
            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
              stack.push(new int[]{row, col - 1});
              grid[row][col - 1] = '0'; // mark as visited
            }
            if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
              stack.push(new int[]{row, col + 1});
              grid[row][col + 1] = '0'; // mark as visited
            }
          }
        }
      }
    }

    return numIslands;
  }


  // BFS
  public int numIslands3(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int res = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        char cur = grid[i][j];
        if (cur == '1') {
          res += 1;
          bfs(grid, i, j);
        }
      }
    }

    return res;

  }


  // 慢一点，因为如果在将元素放入队列时不立即标记它为已访问（即，将其设为 '0'），
  // 那么在队列处理的过程中，相同的元素可能会被多次加入队列。这不仅会导致性能问题（因为同一工作被重复做多次），
  // 还可能在某些情况下导致超时，因为处理队列所需的时间大大增加。
  public void bfs1(char[][] grid, int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{i, j});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int row = cur[0];
      int col = cur[1];


      if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
        grid[row][col] = '0';

        // 上下左右
        if (row + 1 < grid.length) {
          queue.offer(new int[]{row + 1, col});
        }
        if (col + 1 < grid[0].length) {
          queue.offer(new int[]{row, col + 1});
        }
        if (row - 1 >= 0) {
          queue.offer(new int[]{row - 1, col});
        }
        if (col - 1 >= 0) {
          queue.offer(new int[]{row, col - 1});
        }

      }
    }
  }

  // 在这个版本中，每当你从队列中取出一个元素时，你只会将未访问过的 '1' 的邻居入队，并立即标记为 '0'。这样可以有效防止一个单元格被重复处理，从而提高算法的效率。
  public void bfs(char[][] grid, int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{i, j});
    grid[i][j] = '0'; // 初始化时就标记访问过，避免重复入队

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int row = cur[0];
      int col = cur[1];

      // 上
      if (row - 1 >= 0 && grid[row - 1][col] == '1') {
        queue.offer(new int[]{row - 1, col});
        grid[row - 1][col] = '0'; // 标记为已访问
      }
      // 下
      if (row + 1 < grid.length && grid[row + 1][col] == '1') {
        queue.offer(new int[]{row + 1, col});
        grid[row + 1][col] = '0'; // 标记为已访问
      }
      // 左
      if (col - 1 >= 0 && grid[row][col - 1] == '1') {
        queue.offer(new int[]{row, col - 1});
        grid[row][col - 1] = '0'; // 标记为已访问
      }
      // 右
      if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
        queue.offer(new int[]{row, col + 1});
        grid[row][col + 1] = '0'; // 标记为已访问
      }
    }
  }

}
