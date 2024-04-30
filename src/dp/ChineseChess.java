package dp;

public class ChineseChess {

  public static void main(String[] args) {
    System.out.println(countWays(7,7,10));
    System.out.println(countWays2(7,7,10));

  }

  // 一个象棋棋盘，把整个棋盘放入第一象限，棋盘左下角是0,0位置，
  // 那么整个棋盘就是横坐标上的九条线与纵坐标上的十条线，给你三个参数xyk，求 返回马从0,0出发，走k步走到X,Y位置上的方法有几种。

  // 递归
  public static int countWays(int x, int y, int k) {

    return process1(0, 0, k, x, y);
  }

  /**
   * 递归方法
   *
   * @param a    当前x坐标
   * @param b    当前y坐标
   * @param rest 还剩几步
   * @param x    目标x坐标
   * @param y    目标y坐标
   * @return 几种方法
   */
  public static int process1(int a, int b, int rest, int x, int y) {
    if (a < 0 || a > 9 || b < 0 || b > 8) { // 棋盘是10*9，不能越界
      return 0;
    }
    if (rest == 0) {
      return (a == x && b == y) ? 1 : 0;
    }

    // 马从一个点开始走日字，一共只有八种路径，然后把每种可能性的结果累加
    int ways = process1(a + 2, b + 1, rest - 1, x, y);
    ways += process1(a + 1, b + 2, rest - 1, x, y);
    ways += process1(a - 1, b + 2, rest - 1, x, y);
    ways += process1(a - 2, b + 1, rest - 1, x, y);
    ways += process1(a - 2, b - 1, rest - 1, x, y);
    ways += process1(a - 1, b - 2, rest - 1, x, y);
    ways += process1(a + 1, b - 2, rest - 1, x, y);
    ways += process1(a + 2, b - 1, rest - 1, x, y);

    return ways;
  }


  // DP
  public static int countWays2(int x, int y, int k) {
    // 这是一个三维数组, 但是从递归方法中可以分析出，所有格子都和rest-1有关，所以如果把这个数组看成一个长方体，那么rest是高，x，y是长宽
    // 可以得出，每一层的数值都只和下一层有关，也就是rest高度下x*y组成的一个平面只和rest-1高度下的x*y组成的一个平面有关。
    int[][][] dp = new int[10][9][k+1]; //k from 0-k;
    dp[x][y][0] = 1;
    for (int rest = 1; rest <= k; rest++) {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 9; j++) {
          int ways = pick(dp, i + 2, j + 1, rest - 1);
          ways += pick(dp,i + 1, j + 2, rest - 1);
          ways += pick(dp,i - 1, j + 2, rest - 1);
          ways += pick(dp,i - 2, j + 1, rest - 1);
          ways += pick(dp,i - 2, j - 1, rest - 1);
          ways += pick(dp,i - 1, j - 2, rest - 1);
          ways += pick(dp,i + 1, j - 2, rest - 1);
          ways += pick(dp,i + 2, j- 1, rest - 1);
          dp[i][j][rest] = ways;
        }
      }
    }
    return dp[0][0][k];
  }

  // 为了防止越界，用这个函数取dp里的值
  public static int pick(int[][][] dp, int a, int b, int rest){
    if (a < 0 || a > 9 || b < 0 || b > 8) { // 棋盘是10*9，不能越界
      return 0;
    }

    return dp[a][b][rest];
  }
}
