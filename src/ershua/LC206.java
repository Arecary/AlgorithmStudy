package ershua;

public class LC206 {

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


  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode current = head;
    ListNode pre = null;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = pre;
      pre = current;
      current = next;

    }

    return pre;
  }



}
