package ershua;

public class LC142 {


  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public ListNode detectCycle(ListNode head) {

    if (head == null || head.next == null) {
      return null;
    }

    ListNode fast = head;
    ListNode low = head;
    int pos = 0;
    boolean flag = true;

    while (true) {
      if (fast == null || fast.next == null) {
        flag = false;
        break;
      }
      if (pos != 0 && fast == low) {
        break;
      }
      fast = fast.next.next;
      low = low.next;
      pos++;
    }

    if (flag) {
      // 说明有环
      low = head;
      pos = 0;
      while (true) {
        if (low == fast) {
          break;
        }
        low = low.next;
        fast = fast.next;
        pos++;
      }
      return low;
    } else {
      // 说明无环
      return null;
    }

  }


}
