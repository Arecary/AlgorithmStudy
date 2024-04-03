public class LinkedListCycle2_142 {


  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {
    // edge case
    if (head == null || head.next == null) {
      return null;
    }

    int pos = -1;
    int count = 0;
    ListNode entrance = head;
    ListNode intersection = head;
    ListNode fast = head;
    ListNode slow = head;

    while (fast.next != null && fast.next.next != null) {

      fast = fast.next.next;
      slow = slow.next;

      if (count != 0 && fast == slow) {
        intersection = fast;
        pos = -2;
        break;
      }
      count++;
    }

    if (pos == -1) {
      return null;
    }

    while (entrance != intersection) {
      entrance = entrance.next;
      intersection = intersection.next;
    }

    return entrance;
  }


  public ListNode detectCycle1(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {// 有环
        ListNode index1 = fast;
        ListNode index2 = head;
        // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
        while (index1 != index2) {
          index1 = index1.next;
          index2 = index2.next;
        }
        return index1;
      }
    }
    return null;
  }




}
