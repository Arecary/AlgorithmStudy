package greedy;

import java.util.Arrays;

public class AssignCookies_455 {


  // 思路：先排序，然后最大的饼干喂最大的孩子，如果不行就喂第二大的孩子，以此类推


  // 优先考虑胃口，先喂饱大胃口

  /**
   * 给定孩子的胃口和饼干大小，找到能满足孩子胃口的饼干数量
   *
   * @param g 孩子胃口
   * @param s 饼干大小
   * @return 能满足孩子胃口的饼干数量
   */
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;
    int start = s.length - 1;
    // 遍历胃口
    for (int index = g.length - 1; index >= 0; index--) {
      if (start >= 0 && g[index] <= s[start]) {
        start--;
        count++;
      }
    }
    return count;
  }

}
