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


}
