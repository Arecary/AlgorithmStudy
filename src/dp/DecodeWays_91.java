package dp;

public class DecodeWays_91 {


  // 规定1和A对应，2和B对应，3和C对应...，那么一个数字字符串比如"111"就可以转化为"AAA","KA","AK"。
  // 那么给定一个只有数字组成的字符串str，返回有多少种转化结果。
  // 注意0只能组合为10或者20，因为26个字母只能出现10和20两个数字


  // 递归版本
  public int numDecodings(String s) {
    char[] str = s.toCharArray();
    if (str[0] == '0') {
      return 0;
    }
    return process1(str, 0);
  }

  // index 表示现在从第几个字符开始转化，之前的都不管。
  public static int process1(char[] s, int index) {
    if (index == s.length) { // 说明到底了，得出了一种方法
      return 1;
    }


    // 如果没到最后一个字符，就有两种选择
    // 1. 当前字符自己用一个字母表示
    if (s[index] == '0') {
      return 0; // 如果我们只考虑当前字母，且字母为0，则说明之前的考虑出错了，所以返回0
    }

    int way = process1(s, index + 1);


    // 2. 当前字符和下一个字符组成一个字母，但是组成的两位数不能超过26，并且要检查0
    if (index + 1 < s.length && (s[index] - '0') * 10 + (s[index + 1] - '0') <= 26) {
      way += process1(s, index + 2);
    }

    return way;
  }


  // 动态规划版本
  public int numDecodings2(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    char[] str = s.toCharArray();
    if (str[0] == '0') {
      return 0;
    }
    int n = s.length();
    int [] dp = new int[n + 1];
    dp[n] = 1;

    for (int index = n - 1; index >= 0; index--) {

      if (str[index] == '0') {
        dp[index] = 0;
        continue;
      }
      dp[index] = dp[index + 1];
      if (index + 1 < str.length && (str[index] - '0') * 10 + (str[index + 1] - '0') <= 26) {
        dp[index] += dp[index + 2];
      }
    }

    return dp[0];
  }

}
