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

  // return win score
  public static int winScore(int[] arr) {
    if (arr == null || arr.length == 0){
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
  public static int g(int[] arr, int L, int R){
    if (L == R) {
      return 0;
    }

    int card1 = f(arr, L + 1, R); // 对手拿走了L上面的卡
    int card2 = f(arr, L, R - 1); // 对手拿走了R上面的卡
    return Math.min(card1, card2);
  }



}
