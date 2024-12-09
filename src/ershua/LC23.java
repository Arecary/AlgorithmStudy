package ershua;

import java.util.PriorityQueue;

public class LC23 {

  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length <= 1) {
      return lists[0];
    }

    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    int len = lists.length;
    for (ListNode item : lists) {
      if (item != null) {
        minHeap.add(item);
      }
    }

    ListNode dummy = new ListNode();
    ListNode current = dummy;

    while (!minHeap.isEmpty()) {
      current.next = minHeap.poll();
      if (current.next.next != null){
        minHeap.offer(current.next.next);
      }
      current = current.next;
    }

    return dummy.next;

  }





}





