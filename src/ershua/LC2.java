package ershua;

import java.util.ArrayList;


public class LC2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwo(l1, l2, 0);
  }

  // l1 和 l2 为当前遍历的节点，carry 为进位
  private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null) { // 递归边界：l1 和 l2 都是空节点
      return carry != 0 ? new ListNode(carry) : null; // 如果进位了，就额外创建一个节点
    }
    if (l1 == null) { // 如果 l1 是空的，那么此时 l2 一定不是空节点
      l1 = l2;
      l2 = null; // 交换 l1 与 l2，保证 l1 非空，从而简化代码
    }
    int sum = carry + l1.val + (l2 != null ? l2.val : 0); // 节点值和进位加在一起
    l1.val = sum % 10; // 每个节点保存一个数位（直接修改原链表）
    l1.next = addTwo(l1.next, (l2 != null ? l2.next : null), sum / 10); // 进位
    return l1;
  }


  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(); // 哨兵节点
    ListNode cur = dummy;
    int carry = 0; // 进位
    while (l1 != null || l2 != null || carry != 0) { // 有一个不是空节点，或者还有进位，就继续迭代
      if (l1 != null) {
        carry += l1.val; // 节点值和进位加在一起
        l1 = l1.next; // 下一个节点
      }
      if (l2 != null) {
        carry += l2.val; // 节点值和进位加在一起
        l2 = l2.next; // 下一个节点
      }
      cur = cur.next = new ListNode(carry % 10); // 每个节点保存一个数位
      carry /= 10; // 新的进位
    }
    return dummy.next; // 哨兵节点的下一个节点就是头节点
  }


}
