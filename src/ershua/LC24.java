package ershua;

public class LC24 {


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


  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode();
    dummy.next = head.next;
    ListNode pre = dummy;
    ListNode current = head;
    ListNode temp = null;

    while (true) {
      temp = current.next;
      current.next = temp.next;
      temp.next = current;
      pre.next = temp;

      if (current.next == null || current.next.next == null){
        break;
      }
      pre = current;
      current = current.next;
      temp = current.next;

    }

    return dummy.next;

  }


}
