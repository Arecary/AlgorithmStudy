package interviewproblems;

/**
 * Write a function with loops to display the following matrix
 * 9999999999999999999
 * 9888888888888888889
 * 9877777777777777789
 * …
 * …………111.………..
 * …………101….…….
 * …………111…………
 * …
 * 9877777777777777789
 * 9888888888888888889
 * 9999999999999999999
 */
public class PrintMatrix {

  public static void main(String[] args) {
    printMatrix();
  }


  static public void printMatrix() {
    int[][] matrix = new int[19][19];

    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        // 计算当前点到所有四个边缘的最小距离
        int minDistance = Math.min(Math.min(i, 18 - i), Math.min(j, 18 - j));
        // 根据最小距离来确定当前位置的值
        matrix[i][j] = 9 - minDistance;
      }
    }

    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        System.out.printf("%01d ", matrix[i][j]);
      }
      System.out.println();
    }
  }


  static public void printMatrix2() {
    int size = 19; // 矩阵的大小
    int[][] matrix = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        // 计算当前点到所有四个边缘的最小距离
        int minDistance = Math.min(Math.min(i, size - 1 - i), Math.min(j, size - 1 - j));
        // 根据最小距离来确定当前位置的值
        matrix[i][j] = 9 - minDistance;
      }
    }

    // 打印矩阵
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.printf("%1d", matrix[i][j]);
      }
      System.out.println();
    }
  }

  static public void printMatrix1(int size) {
    int[][] matrix = new int[size][size];

    for (int layer = 0; layer <= size / 2; layer++) {
      int num = 9 - layer;
      for (int i = layer; i < size - layer; i++) {
        for (int j = layer; j < size - layer; j++) {
          if (i == layer || i == size - layer - 1 || j == layer || j == size - layer - 1) {
            matrix[i][j] = num;
          }
        }
      }
    }

    // 打印矩阵
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }


}
