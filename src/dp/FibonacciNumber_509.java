package dp;

public class FibonacciNumber_509 {
  // good ans 压缩版本，只需要维护3个数字而不是一个数列
  public int fib(int n) {
    if (n < 2) return n;
    int a = 0, b = 1, c = 0;
    for (int i = 1; i < n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }

  // good ans
  public int fib2(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int index = 2; index <= n; index++){
      dp[index] = dp[index - 1] + dp[index - 2];
    }
    return dp[n];
  }


  public int fib1(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    int count = 2;
    while (count != n + 1) {
      dp[count] = dp[count - 2] + dp[count - 1];
      count++;
    }

    return dp[n];
  }


}
