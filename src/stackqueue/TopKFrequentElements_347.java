package stackqueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {

  public static void main(String[] args) {
    int[] nums = {5, 2, 5, 3, 5, 3, 1, 1, 3};
    int k = 2;
    System.out.println(Arrays.toString(topKFrequent1(nums, k)));
  }


  // 快
  public int[] topKFrequent(int[] nums, int k) {
    int[] res = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        int value = map.get(num) + 1;
        map.put(num, value);
      } else {
        map.put(num, 1);
      }
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int[] element = new int[]{entry.getKey(), entry.getValue()};
      if (pq.size() < k) {
        pq.add(element);
      } else {
        if (entry.getValue() > pq.peek()[1]) {//当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
          pq.poll();//弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
          pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
      }
    }

    for (int i = k - 1; i >= 0; i--) {//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
      res[i] = pq.poll()[0];
    }

    return res;
  }


  // 慢，因为每次pq满了我都直接弹出旧的再add新的，没有比较当前元素和小顶堆里堆顶元素的大小。
  static public int[] topKFrequent1(int[] nums, int k) {
    int[] res = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        int value = map.get(num) + 1;
        map.put(num, value);
      } else {
        map.put(num, 1);
      }
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int[] element = new int[]{entry.getKey(), entry.getValue()};
      if (pq.size() <= k) {
        pq.add(element);
      } else {
        pq.poll();
        pq.add(element);
      }
    }

    if (pq.size() == k + 1) {
      pq.poll();
    }

    for (int i = k - 1; i >= 0; i--) {//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
      res[i] = pq.poll()[0];
    }

    return res;
  }




}
