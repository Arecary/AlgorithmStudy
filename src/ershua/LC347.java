package ershua;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {



  public int[] topKFrequent(int[] nums, int k) {
    int [] res = new int[k];
    Map<Integer, Integer> record = new HashMap<>();

    for (int i : nums) {
      record.put(i, record.getOrDefault(i, 0) + 1);
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> p1[1] - p2[1]);
    for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
      int [] element = new int[]{entry.getKey(), entry.getValue()};
      if (pq.size() < k) {
        pq.add(element);
      }else {
        if (element[1] > pq.peek()[1]) {
          pq.poll();
          pq.add(element);
        }
      }
    }

    for (int i = k - 1; i >= 0; i--) {
      res[i] = pq.poll()[0];
    }
    return res;
  }


}
