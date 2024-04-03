package dp;

public class HouseRobber_198 {


  //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
  //
  //给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
  //
  //示例 1：
  //输入：[1,2,3,1]
  //输出：4
  //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。   偷窃到的最高金额 = 1 + 3 = 4 。
  //
  //示例 2：
  //输入：[2,7,9,3,1]
  //输出：12 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。   偷窃到的最高金额 = 2 + 9 + 1 = 12
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(dp[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }

    return dp[nums.length - 1];
  }


  // 使用滚动数组思想，优化空间
  // 分析本题可以发现，所求结果仅依赖于前两种状态，此时可以使用滚动数组思想将空间复杂度降低为3个空间
  public int rob1(int[] nums) {

    int len = nums.length;

    if (len == 0) return 0;
    else if (len == 1) return nums[0];
    else if (len == 2) return Math.max(nums[0], nums[1]);


    int[] result = new int[3]; //存放选择的结果
    result[0] = nums[0];
    result[1] = Math.max(nums[0], nums[1]);


    for (int i = 2; i < len; i++) {

      result[2] = Math.max(result[0] + nums[i], result[1]);

      result[0] = result[1];
      result[1] = result[2];
    }

    return result[2];
  }


  // 进一步对滚动数组的空间优化 dp数组只存与计算相关的两次数据
  public int rob2(int[] nums) {
    if (nums.length == 1)  {
      return nums[0];
    }
    // 初始化dp数组
    // 优化空间 dp数组只用2格空间 只记录与当前计算相关的前两个结果
    int[] dp = new int[2];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0],nums[1]);
    int res = 0;
    // 遍历
    for (int i = 2; i < nums.length; i++) {
      res = Math.max((dp[0] + nums[i]) , dp[1] );
      dp[0] = dp[1];
      dp[1] = res;
    }
    // 输出结果
    return dp[1];
  }

}
