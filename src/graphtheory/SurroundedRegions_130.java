package graphtheory;

public class SurroundedRegions_130 {


  // 从最外圈出发，把所有接触到边界的岛屿都标记成A
  // 再遍历整张图，把x改成0，A改成x

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    // 先遍历最外圈
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i != 0 && i != board.length - 1 && j != 0 && j != board[0].length - 1) {
          continue;
        }

        if (board[i][j] == 'O') {
          dfs(board, i, j);
        }

      }
    }

    // 再遍历整张图，把x改成0，A改成x
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }else if (board[i][j] == 'A') {
          board[i][j] = 'O';
        }

      }
    }

  }


  public void dfs(char[][] board, int i, int j) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'A' || board[i][j] == 'X') {
      return;
    }

    board[i][j] = 'A';
    dfs(board, i + 1, j);
    dfs(board, i - 1, j);
    dfs(board, i, j + 1);
    dfs(board, i, j - 1);

  }

}
