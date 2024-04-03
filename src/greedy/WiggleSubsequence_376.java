package greedy;

public class WiggleSubsequence_376 {


  public int wiggleMaxLength(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }

    //当前差值
    int curDiff = 0;
    //上一个差值
    int preDiff = 0;
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      //得到当前差值
      curDiff = nums[i] - nums[i - 1];
      //如果当前差值和上一个差值为一正一负
      //等于0的情况表示初始时的preDiff
      if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
        count++;
        // 我们只需要在 这个坡度 摆动变化的时候，更新 prediff 就行，这样 prediff 在 单调区间有平坡的时候 就不会发生变化，造成我们的误判。
        preDiff = curDiff;
      }
    }
    return count;

  }
}
