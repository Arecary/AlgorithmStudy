public class RemoveNthNodeFromEndOfList_19 {

  static public class ListNode {
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
    ListNode dummy = new ListNode(0, head);
    ListNode fast;
    ListNode low;
    ListNode pre = dummy;
    ListNode temp = dummy;
    fast = low = dummy;
    int count =  1;

    while (true) {
      // 防止快指针越界
      if (fast.next == null) {
        pre.next = temp;
        break;
      }
      fast = fast.next;
      if (count >= n) {
        pre = low;
        low = low.next;
        temp = low.next;
      }

      count++;
    }

    return dummy.next;
  }


  // 不需要用到pre和temp，slow设为删除元素的前一个node，所以可以让slow.next=slow.next.next
  public ListNode removeNthFromEnd1(ListNode head, int n){
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;

    ListNode fastIndex = dummyNode;
    ListNode slowIndex = dummyNode;

    // 只要快慢指针相差 n 个结点即可
    for (int i = 0; i <= n  ; i++){
      fastIndex = fastIndex.next;
    }

    while (fastIndex != null){
      fastIndex = fastIndex.next;
      slowIndex = slowIndex.next;
    }

    //此时 slowIndex 的位置就是待删除元素的前一个位置。
    //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
    slowIndex.next = slowIndex.next.next;
    return dummyNode.next;
  }


}
