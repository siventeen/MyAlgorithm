import java.nio.file.NotDirectoryException;

public class LeetCode707 {
    static class MyLinkedList {

        Node<Integer> head;
        Node<Integer> tail;
        int size;

        public MyLinkedList() {
            head = new Node<>(null);
            tail = new Node<>(null);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public int get(int index) {
            if (index >= size || index < 0) {
                return -1;
            }
            Node<Integer> cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            Node<Integer> addNode = new Node<>(val);
            addNode.next = head.next;
            addNode.pre = head;
            head.next.pre = addNode;
            head.next = addNode;
            size++;
        }

        public void addAtTail(int val) {
            Node<Integer> addNode = new Node<>(val);
            addNode.next = tail;
            addNode.pre = tail.pre;
            tail.pre.next = addNode;
            tail.pre = addNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            Node<Integer> befor = head;
            for (int i = 0; i < index; i++) {
                befor = befor.next;
            }
            Node<Integer> after = befor.next;
            Node<Integer> newNode = new Node<>(val);
            newNode.next = after;
            newNode.pre = befor;
            befor.next = newNode;
            after.pre = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node<Integer> befor = head;
            for (int i = 0; i < index; i++) {
                befor = befor.next;
            }
            Node<Integer> toDelete = befor.next;
            toDelete.next.pre = befor;
            befor.next = toDelete.next;
            toDelete.next = null;
            toDelete.pre = null;
            size--;
        }



    }

    private static class Node<E> {
        Node<E> next;
        Node<E> pre;
        E val;

        public Node(E val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtTail(7);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtHead(0);
        myLinkedList.get(5);
        myLinkedList.addAtHead(0);
        myLinkedList.get(2);
        myLinkedList.get(5);
        myLinkedList.addAtTail(4);
    }
}
