package ershua;

public class LC141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

  public boolean hasCycle(ListNode head) {
      if (head == null) {
        return false;
      }

      ListNode fast = head;
      ListNode slow = head;

      while (true) {
        fast = fast.next;
        if (fast == null) {
          return false;
        }
        fast = fast.next;
        if (fast == null) {
          return false;
        }
        slow = slow.next;
        if (fast == slow) {
          return true;
        }
      }

  }


}
