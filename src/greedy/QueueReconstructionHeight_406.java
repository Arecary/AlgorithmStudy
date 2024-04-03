package greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class QueueReconstructionHeight_406 {


  // 按照身高排序之后，优先按身高高的people的k来插入，后序插入节点也不会影响前面已经插入的节点，最终按照k的规则完成了队列。
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> {
      if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
      return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
    });

    LinkedList<int[]> que = new LinkedList<>();

    for (int[] p : people) {
      que.add(p[1],p);   //Linkedlist.add(index, value)，會將value插入到指定index裡。
      // p就是[h,k]一个元素，p[1]就是k值，que.add(p[1],p)，會將p插入到k值的位置
      // 例如：p = [7,0]，p[1] = 0，que.add(0,p)，會將p插入到linkedlist的index = 0的位置
    }

    return que.toArray(new int[people.length][]);
  }


}
