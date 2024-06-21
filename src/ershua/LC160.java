package ershua;

public class LC160 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null) {
      return null;
    }

    int lenA = 0;
    int lenB = 0;
    ListNode curA = headA;
    ListNode curB = headB;

    while (curA != null) {
      curA = curA.next;
      lenA++;
    }

    while (curB != null) {
      curB = curB.next;
      lenB++;
    }

    int dif = Math.abs(lenA - lenB);
    curA = headA;
    curB = headB;
    if (lenA >= lenB) {
      while (dif != 0) {
        curA = curA.next;
        dif--;
      }

      while (curA != null) {
        if (curA == curB) {
          return curA;
        }else {
          curA = curA.next;
          curB = curB.next;
        }
      }

    } else {
      while (dif != 0) {
        curB = curB.next;
        dif--;
      }

      while (curA != null) {
        if (curA == curB) {
          return curA;
        }else {
          curA = curA.next;
          curB = curB.next;
        }
      }
    }

    return null;
  }


}
