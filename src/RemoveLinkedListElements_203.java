public class RemoveLinkedListElements_203 {

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next = new ListNode(6);
    int val = 6;
    ListNode result = removeElements1(head, val);
    System.out.println("result = " + result.toString()); // result = 1->2->3->4->5
  }

  public static class ListNode {

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

    @Override
    public String toString() {
      String result = String.valueOf(val);
      while (next != null) {
        result = result + next.val;
        next =  next.next;
      }
      return result;
    }
  }


  // 1263456, 6
  /**
   * 添加虚节点方式
   * 时间复杂度 O(n)
   * 空间复杂度 O(1)
   * @param head
   * @param val
   * @return
   */
  public static ListNode removeElements1(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
    ListNode dummy = new ListNode(-1, head);
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next;
      } else {
        pre = cur;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
  /**
   * 不添加虚拟节点方式
   * 时间复杂度 O(n)
   * 空间复杂度 O(1)
   * @param head
   * @param val
   * @return
   */
  public static ListNode removeElements2(ListNode head, int val) {
    while (head != null && head.val == val) {
      head = head.next;
    }
    // 已经为null，提前退出
    if (head == null) {
      return head;
    }
    // 已确定当前head.val != val
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next;
      } else {
        pre = cur;
      }
      cur = cur.next;
    }
    return head;
  }

}
