package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_51 {

  // 搜索过程抽象为一棵树, 每一层就是棋盘的一行
  // 比如3X3棋盘，第一层是OXX, XOX, XXO


  List<List<String>> result = new ArrayList<>();


  public List<List<String>> solveNQueens(int n) {
    char[][] chessboard = new char[n][n];
    for (char[] c : chessboard) {
      Arrays.fill(c, '.');
    }
    backTrack(n, 0, chessboard);
    return result;

  }

  private void backTrack(int n, int row, char[][] chessboard) {
    // 终止条件
    // 当递归到最后一行的时候就终止
    if (row == n) {
      result.add(arrayToList(chessboard));
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isValid(row, col, n, chessboard)) {
        chessboard[row][col] = 'Q';
        backTrack(n, row + 1, chessboard);
        chessboard[row][col] = '.';
      }
    }

  }


  private List<String> arrayToList(char[][] chessboard) {
    List<String> res = new ArrayList<>();
    for (char[] c : chessboard) {
      res.add(new String(c));
    }
    return res;
  }

  private boolean isValid(int row, int col, int n, char[][] chessboard) {
    // 检查列
    for (int i = 0; i < row; ++i) { // 相当于剪枝
      if (chessboard[i][col] == 'Q') {
        return false;
      }
    }

    // 检查45度对角线
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (chessboard[i][j] == 'Q') {
        return false;
      }
    }

    // 检查135度对角线
    for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
      if (chessboard[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }


}
