import java.util.PriorityQueue;

public class MedianHeap {
  private PriorityQueue<Integer> maxHeap;  // Represents the lower half.
  private PriorityQueue<Integer> minHeap;  // Represents the upper half.

  public MedianHeap() {
    maxHeap = new PriorityQueue<>((a, b) -> b - a);  // Max heap
    minHeap = new PriorityQueue<>();  // Min heap by default
  }

  public void build(int[] S) {
    int median = findMedian(S);
    for (int num : S) {
      if (num <= median) {
        maxHeap.offer(num);
      } else {
        minHeap.offer(num);
      }
    }
    rebalance();
  }

  public void insert(int x) {
    if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
      maxHeap.offer(x);
    } else {
      minHeap.offer(x);
    }
    rebalance();
  }

  public int peek() {
    if (maxHeap.isEmpty()) {
      throw new IllegalStateException("Heap is empty");
    }
    return maxHeap.peek();
  }

  public int extract() {
    int median = maxHeap.poll();
    rebalance();
    return median;
  }

  private void rebalance() {
    while (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
    while (maxHeap.size() > minHeap.size() + 1) {
      minHeap.offer(maxHeap.poll());
    }
  }

  private int findMedian(int[] S) {
    // For simplicity, we're just sorting the array to find the median.
    // In practice, you might use a linear-time selection algorithm.
    java.util.Arrays.sort(S);
    return S[S.length / 2];
  }

  public static void main(String[] args) {
    MedianHeap medianHeap = new MedianHeap();
    int[] S = {1, 2, 3, 4, 5};
    medianHeap.build(S);
    System.out.println(medianHeap.peek());  // Should print 5
    medianHeap.insert(2);
    System.out.println(medianHeap.peek());  // Should print 5
//    medianHeap.extract();
//    System.out.println(medianHeap.peek());  // Should print 4
  }
}


