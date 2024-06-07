package ershua;

public class LC707 {

  public class Node {
    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }

  class MyLinkedList {
    int size;
    Node head;


    public MyLinkedList() {
      head = new Node();
      size = 0;
    }

    public int get(int index) {
      if (index < 0 || index > size - 1) {
        return -1;
      }
      int count = index;
      Node cur = head.next;
      while (count != 0) {
        cur = cur.next;
        count--;
      }
      return cur.val;
    }

    public void addAtHead(int val) {
      Node first = head.next;
      head.next = new Node(val);
      head.next.next = first;
      size++;
    }

    public void addAtTail(int val) {
      Node cur = head;
      while (cur.next!=null) {
        cur = cur.next;
      }
      cur.next = new Node(val);
      size++;
    }

    public void addAtIndex(int index, int val) {
      if (index > size) {
        return;
      }
      if (index == size) {
        addAtTail(val);
      } else {
        Node pre = head;
        while (index > 0) {
          pre = pre.next;
          index--;
        }
        Node newNode = new Node(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
      }
    }

    public void deleteAtIndex(int index) {
      if (index < 0 || index >= size) {
        return;
      }
      Node pre = head;
      Node cur = head.next;
      while (index != 0) {
        pre = cur;
        cur = cur.next;
        index--;
      }
      if (cur.next == null) {
        pre.next = null;
      }else {
        pre.next = cur.next;
      }
      size--;
    }

  }


}
