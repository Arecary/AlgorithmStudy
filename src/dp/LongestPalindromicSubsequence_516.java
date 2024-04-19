package dp;

public class LongestPalindromicSubsequence_516 {
  //最长回文字符串
  /*Input: s = "bbbab"
  Output: 4
  Explanation: One possible longest palindromic subsequence is "bbbb".*/

  // 讨巧的解法
  // 把str逆序一下成str2，求str和str2的最长公共子序列，即1143题，这个最长公共子序列就是str的最长回文子序列。


  // 递归
  public int longestPalindromeSubseq(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    char[] s1 = s.toCharArray();
    return process1(s1, 0, s.length() - 1);

  }

  // 返回到L到R范围上最长会问字符串是多少
  public static int process1(char[] s, int L, int R) {
    if (L == R) {
      return 1;
    }

    if (L == R - 1) {
      return s[L] == s[R] ? 2 : 1;
    }

    // 四种可能性
    // 1. 这个最长回文子序列，既不包含L也不包含R
    int p1 = process1(s, L + 1, R - 1);
    // 2. 包含L不包含R
    int p2 = process1(s, L, R - 1);
    // 3. 不包含L包含R
    int p3 = process1(s, L + 1, R);
    // 4. 既包含L也包含R
    int p4 = s[L] == s[R] ? (2 + process1(s, L + 1, R - 1)) : 0;
    return Math.max(p1, Math.max(p2, Math.max(p3, p4)));
  }


  // dp
  public int longestPalindromeSubseq2(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    char[] s1 = s.toCharArray();

    int N = s.length();
    int[][] dp = new int[N][N];
    dp[N - 1][N - 1] = 1;
    for (int i = 0; i < N - 1; i++) {
      dp[i][i] = 1;
      dp[i][i + 1] = s1[i] == s1[i + 1] ? 2 : 1;
    }

    for (int L = N - 3; L >= 0; L--) {

      for (int R = L + 2; R < N; R++) {
        int p1 = dp[L + 1][R - 1];
        int p2 = dp[L][R - 1];
        int p3 = dp[L + 1][R];
        int p4 = s1[L] == s1[R] ? (2 + dp[L + 1][R - 1]) : 0;
        dp[L][R] = Math.max(p1, Math.max(p2, Math.max(p3, p4)));
      }
    }
    return dp[0][N - 1];
  }

  // 优化DP
  // 上个dp版本中我们发现位置依赖是，依赖当前格子的左，左下和下位置
  // 但是当确定当前格子左边格子时，实际上也依赖了当前格子左下位置(即当前格子左边格子的下方格子)，所以重复依赖了
  // 因为最后是从P1-P4里找最大值，所以左下方的格子无论如何都不会大于左边的格子，自然我们可以省略对比左下的格子
  // 所以我们先对比左和下方格子找最大值，再当s1[L] == s1[R]时对比2 + dp[L + 1][R - 1]即可
  // dp
  public int longestPalindromeSubseq3(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    char[] s1 = s.toCharArray();

    int N = s.length();
    int[][] dp = new int[N][N];
    dp[N - 1][N - 1] = 1;
    for (int i = 0; i < N - 1; i++) {
      dp[i][i] = 1;
      dp[i][i + 1] = s1[i] == s1[i + 1] ? 2 : 1;
    }

    for (int L = N - 3; L >= 0; L--) {
      for (int R = L + 2; R < N; R++) {

       dp[L][R] = Math.max(dp[L + 1][R], dp[L][R - 1]);
       if (s1[L] == s1[R]) {
         dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
       }

      }
    }
    return dp[0][N - 1];
  }


}
