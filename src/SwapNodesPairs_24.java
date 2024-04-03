public class SwapNodesPairs_24 {


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

  public ListNode swapPairs(ListNode head) {
    ListNode  dummy = new ListNode(0);
    dummy.next = head;

    // edge case
    if(head == null || head.next == null){
      return head;
    }
    ListNode pre = dummy;
    ListNode curr = head;
    ListNode next = head.next;
    ListNode temp = next.next;

    while (true){
      pre.next =  next;
      next.next = curr;
      curr.next = temp;
      if (curr.next == null || curr.next.next == null) {
        break;
      }
      pre = curr;
      curr = curr.next;
      next = curr.next;
      temp = next.next;

    }
    return dummy.next;
  }

  // 递归
  public ListNode swapPairs1(ListNode head) {
    // base case 退出提交
    if(head == null || head.next == null) return head;
    // 获取当前节点的下一个节点
    ListNode next = head.next;
    // 进行递归
    ListNode newNode = swapPairs(next.next);
    // 这里进行交换
    next.next = head;
    head.next = newNode;

    return next;
  }


  // 注意奇数个node的链表可能造成空指针异常
  public ListNode swapPairs2(ListNode head) {
    ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
    dumyhead.next = head; // 将虚拟头结点指向head，这样方便后面做删除操作
    ListNode cur = dumyhead;
    ListNode temp; // 临时节点，保存两个节点后面的节点
    ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
    ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
    while (cur.next != null && cur.next.next != null) {
      temp = cur.next.next.next;
      firstnode = cur.next;
      secondnode = cur.next.next;
      cur.next = secondnode;       // 步骤一
      secondnode.next = firstnode; // 步骤二
      firstnode.next = temp;      // 步骤三
      cur = firstnode; // cur移动，准备下一轮交换
    }
    return dumyhead.next;
  }



}
