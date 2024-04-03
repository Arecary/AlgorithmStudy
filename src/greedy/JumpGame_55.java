package greedy;

public class JumpGame_55 {


  /**
   * 不一定非要明确一次究竟跳几步，每次取最大的跳跃步数，这个就是可以跳跃的覆盖范围。
   * <p>
   * 这个范围内，别管是怎么跳的，反正一定可以跳过来。
   */

  public boolean canJump(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
    int coverRange = 0;
    //在覆盖范围内更新最大的覆盖范围，逐步往前试
    for (int i = 0; i <= coverRange; i++) {
      coverRange = Math.max(coverRange, i + nums[i]); // 这里就是在前一个最大范围内，一个index一个index的往前试，直到找到当前元素的覆盖范围比上一个还大。
      if (coverRange >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }


  // 这个方法没有一格一格往前试，每次直接跳到最大范围的边界，所以会出错，比如2，5，0，0
  public boolean canJump1(int[] nums) {
    int cover = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        break;
      }
      cover += nums[i];
      i = cover;
      if (cover >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }


}
