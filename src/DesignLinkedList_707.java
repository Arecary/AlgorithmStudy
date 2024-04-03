public class DesignLinkedList_707 {

  public static void main(String[] args) {

  }


  static class Node {

    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  static class MyLinkedList {

    int size;
    Node head;

    public MyLinkedList() {
      size = 0;
      head = new Node(0);
    }

    public int get(int index) {
      if (index < 0 || index >= size) {
        return -1;
      }

      Node curr = head;
      for (int i = 0; i <= index; i++) {
        curr = curr.next;
      }

      return curr.val;
    }

    public void addAtHead(int val) {
      Node newNode = new Node(val);
      newNode.next = head.next;
      head.next = newNode;
      size++;
    }

    public void addAtTail(int val) {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = new Node(val);
      size++;
    }

    public void addAtIndex(int index, int val) {
      if (index > size) {
        return;
      }

      if (index < 0) {
        this.addAtHead(val);
      }

      Node newNode = new Node(val);
      Node prev = head;

      for (int i = 0; i < index; i++) {
        prev = prev.next;
      }

      newNode.next = prev.next;
      prev.next = newNode;
      size++;
    }

    public void deleteAtIndex(int index) {
      if (index >= size || index < 0) {
        return;
      }


      Node prev = head;

      for (int i = 0; i < index; i++) {
        prev = prev.next;
      }

      prev.next = prev.next.next;
      size--;
    }

  }
}
