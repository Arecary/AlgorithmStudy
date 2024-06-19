package ershua;

public class LC19 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode nth = dummy;
    ListNode end = dummy;
    ListNode pre = dummy;

    while (end.next != null) {
      end = end.next;
      n--;

      if (n <= 0) {
        if (n < 0) {
          nth = nth.next;
          pre = pre.next;
        }else {
          nth = nth.next;
        }

      }
    }

    pre.next = nth.next;
    return dummy.next;

  }


}
