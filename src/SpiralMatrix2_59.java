public class SpiralMatrix2_59 {


  // 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
  //
  //示例:
  //
  //输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
  public static void main(String[] args) {

    int input = 3;
    int[][] result = generateMatrix(input);
    System.out.println(result);
  }

  public static int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int num = 1;
    int loop = 1;
    int start = 0;
    int row;
    int colum;

    while (loop <= n / 2) {
      // 以一圈为一个loop

      // 上面一行
      for (colum = start; colum < n - loop; colum++){
        result[start][colum] = num;
        num++;
      }

      // 右边一行
      for (row = start; row < n - loop; row++) {
        result[row][colum] = num;
        num++;
      }

      // 下面一行
      for (; colum > start; colum--) {
        result[row][colum] = num;
        num++;
      }

      // 左边一行
      for (; row > start; row--) {
        result[row][colum] = num;
        num++;
      }

      start++;
      loop++;
    }

    if (n % 2 == 1) {
      result[start][start] = num;
    }

    return result;
  }


}
