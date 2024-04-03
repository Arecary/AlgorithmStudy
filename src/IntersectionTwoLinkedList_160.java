
public class IntersectionTwoLinkedList_160 {


  static public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lengthA = getLength(headA);
    int lengthB = getLength(headB);
    ListNode dummyA = new ListNode(-1);
    ListNode dummyB = new ListNode(-1);
    dummyA.next = headA;
    dummyB.next = headB;
    ListNode currA = dummyA.next;
    ListNode currB = dummyB.next;


    int longer = Math.max(lengthA, lengthB);
    int shorter = Math.min(lengthA, lengthB);

    if (longer != shorter) {
      int gap = Math.abs(longer - shorter);
      // 先让长的走两步
      for (int i = 0; i < gap; i++) {
        if (longer == lengthA) {

          currA = currA.next;

        }
        if (longer == lengthB) {

          currB = currB.next;

        }
      }
    }

    while (currA != null) {
      if (currA == currB) {
        return currA;
      }
      currA = currA.next;
      currB = currB.next;

    }

    return null;

  }

  static public int getLength(ListNode head) {
    if (head == null) {
      return 0;
    }

    int count = 1;

    while (head.next != null) {
      count++;
      head = head.next;
    }
    return count;
  }


}
