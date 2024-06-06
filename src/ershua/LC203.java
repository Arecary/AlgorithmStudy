package ershua;

public class LC203 {

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

  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode current = dummy.next;
    ListNode pre = dummy;

    while (current != null) { // Check current instead of current.next
      if (current.val == val) {
        pre.next = current.next; // Skip the current node
      } else {
        pre = current; // Move pre only if current node is not deleted
      }
      current = current.next; // Always move current
    }

    return dummy.next;
  }


}
