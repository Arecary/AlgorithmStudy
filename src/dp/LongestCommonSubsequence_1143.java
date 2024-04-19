package dp;

public class LongestCommonSubsequence_1143 {


  // 递归
  public int longestCommonSubsequence(String text1, String text2) {
    if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
      return 0;
    }
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();

    return process1(s1, s2, s1.length - 1, s2.length - 1);
  }

  // 返回：s1在0-i的范围上和s2到0-j的范围上的最大公共子序列是多长
  public static int process1(char[] s1, char[] s2, int i, int j) {

    if (i == 0 && j == 0) {
      return s1[i] == s2[j] ? 1 : 0;
    } else if (i == 0) {
      if (s1[i] == s2[j]) {
        return 1;
      } else {
        return process1(s1, s2, i, j - 1);
      }
    } else if (j == 0) {
      if (s1[i] == s2[j]) {
        return 1;
      } else {
        return process1(s1, s2, i - 1, j);
      }
    } else { // i和j都不为0
      int p1 = process1(s1, s2, i - 1, j);
      int p2 = process1(s1, s2, i, j - 1);
      int p3 = s1[i] == s2[j] ? (1 + process1(s1, s2, i - 1, j - 1)) : Integer.MIN_VALUE;

      return Math.max(p1, Math.max(p2, p3));
    }
  }

  // dp
  public int longestCommonSubsequence2(String text1, String text2) {
    if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
      return 0;
    }
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();

    int N = s1.length;
    int M = s2.length;
    int[][] dp = new int[N][M]; // 通过分析递归可知，dp表里的任意格子依赖左，上，和左上三个格子，所以只要填完第一行和第一列，剩下的格子都能推导出来
    dp[0][0] = s1[0] == s2[0] ? 1 : 0;
    for (int j = 1; j < M; j++) { // 填第一行
      dp[0][j] = s1[0] == s2[j] ? 1 : dp[0][j - 1];
    }

    for (int i = 1; i < N; i++) { // 填第一列
      dp[i][0] = s1[i] == s2[0] ? 1 : dp[i - 1][0];
    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        int p1 = dp[i - 1][j];
        int p2 = dp[i][j - 1];
        int p3 = s1[i] == s2[j] ? (1 + dp[i - 1][j - 1]) : Integer.MIN_VALUE;

        dp[i][j] = Math.max(p1, Math.max(p2, p3));
      }
    }

    return dp[N - 1][M - 1];
  }

}
