public class ReverseLinkedList_206 {


  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */


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


  // recursion 从后向前递归
  public ListNode reverseList(ListNode head) {
    if(head == null) return null;
    if (head.next == null) {
      return head;
    }

    ListNode newHead = reverseList(head.next);

    // 将当前节点连接到反转后的链表尾部
    head.next.next = head;
    head.next = null;

    return newHead;
  }


  // 双指针
  class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode cur = head;
      ListNode temp = null;
      while (cur != null) {
        temp = cur.next;// 保存下一个节点
        cur.next = prev;
        prev = cur;
        cur = temp;
      }
      return prev;
    }
  }
  // 递归
  class Solution1{
    public ListNode reverseList(ListNode head) {
      return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
      if (cur == null) {
        return prev;
      }
      ListNode temp = null;
      temp = cur.next;// 先保存下一个节点
      cur.next = prev;// 反转
      // 更新prev、cur位置
      // prev = cur;
      // cur = temp;
      return reverse(cur, temp);
    }
  }


}
