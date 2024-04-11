package dp;

public class PredictTheWinner_486 {

  // LeetCode原题:
  public boolean predictTheWinner(int[] nums) {

    int res = winScore(nums);
    return res == 1;
  }


  // 非LeetCode原题:
  // 给定一个整数型数组arr，代表数值不同的指派排成一条线，玩家A和B一次拿走每张指派，规定玩家A先拿,背后那。
  // 但是每个玩家每次只能拿走最右边或者最左边。A和B都绝顶聪明，请返回最后获胜者的分数


  // 1. 纯暴力递归方法
  // return win score
  public static int winScore(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    int first = f(arr, 0, arr.length - 1);
    int second = g(arr, 0, arr.length - 1);

    return first >= second ? 1 : 0;
  }


  // 先手函数
  public static int f(int[] arr, int L, int R) {
    if (L == R) {
      return arr[L];
    }

    int card1 = arr[L] + g(arr, L + 1, R);
    int card2 = arr[R] + g(arr, L, R - 1);
    return Math.max(card1, card2);

  }

  // 后手函数
  public static int g(int[] arr, int L, int R) {
    if (L == R) {
      return 0;
    }

    int card1 = f(arr, L + 1, R); // 对手拿走了L上面的卡
    int card2 = f(arr, L, R - 1); // 对手拿走了R上面的卡
    return Math.min(card1, card2);
  }


  // 2. 记忆化 傻缓存方法
  public static int winScore2(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int n = arr.length;
    int[][] fMap = new int[n][n];
    int[][] gMap = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        fMap[i][j] = -1;
        gMap[i][j] = -1;
      }
    }

    int first = f2(arr, 0, arr.length - 1, fMap, gMap);
    int second = g2(arr, 0, arr.length - 1, fMap, gMap);

    return first >= second ? 1 : 0;
  }


  // 先手函数
  public static int f2(int[] arr, int L, int R, int[][] fMap, int[][] gMap) {

    if (fMap[L][R] != -1) {
      return fMap[L][R];
    }

    int ans = 0;

    if (L == R) {
      ans = arr[L];
    } else {
      int card1 = arr[L] + g2(arr, L + 1, R, fMap, gMap);
      int card2 = arr[R] + g2(arr, L, R - 1, fMap, gMap);
      ans = Math.max(card1, card2);
    }

    fMap[L][R] = ans;
    return ans;

  }

  // 后手函数
  public static int g2(int[] arr, int L, int R, int[][] fMap, int[][] gMap) {

    if (gMap[L][R] != -1) {
      return gMap[L][R];
    }

    int ans = 0;
    if (L != R) {
      int card1 = f2(arr, L + 1, R, fMap, gMap); // 对手拿走了L上面的卡
      int card2 = f2(arr, L, R - 1, fMap, gMap); // 对手拿走了R上面的卡
      ans = Math.min(card1, card2);
    }

    gMap[L][R] = ans;
    return ans;
  }


  // 3. 自下而上的，完全依赖构建dp表的动态规划
  public static int winScore3(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int n = arr.length;
    int[][] fMap = new int[n][n];
    int[][] gMap = new int[n][n];

    for (int i = 0; i < n; i++) {
      fMap[i][i] = arr[i];
    }

    // 在dp表里row是L，col是R
    for (int starCol = 1; starCol < n; starCol++) {
      int col = starCol;
      int row = 0;

      while (col < n) {
        fMap[row][col] = Math.max(arr[row] + gMap[row + 1][col], arr[col] + gMap[row][col -1 ]);
        gMap[row][col] = Math.min(fMap[row + 1][col], fMap[row][col - 1]);

        col++;
        row++;
      }
    }

    int first = fMap[0][arr.length - 1];
    int second = gMap[0][arr.length - 1];
    return first >= second ? 1 : 0;
  }

}
