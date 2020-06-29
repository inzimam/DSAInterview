package linkedlist;

import java.util.HashSet;

public class LinkedList {

    public Node head = null;

    public void insertNodeAtFront(int data) {
        Node node = new Node(data);
        if (head == null)
            head = node;
        else {
            node.next = head;
            head = node;
        }
    }

    public void insertNodeAtLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void insertNodeAtPos(int data, int pos) {
        if (pos > getCount(head)) {
            System.out.println("Invalid Position");
        } else if (pos == 0) {
            insertNodeAtFront(data);
        } else if (pos == getCount(head)) {
            insertNodeAtLast(data);
        } else {
            int currPos = 0;
            Node node = new Node(data);
            Node temp = head;
            while (currPos < pos - 1) {
                temp = temp.next;
                currPos++;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteNodeAtFront() {
        if (head != null) {
            head = head.next;
        }
    }

    public void deleteNodeAtLast() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }
        if (temp.next == null) {
            head = null;
        } else if (temp.next.next == null) {
            temp.next = null;
        } else {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void deleteNodeAtPos(int pos) {
        if (pos < 0 || pos >= getCount(head)) {
            System.out.println("Invalid Position");
            return;
        }
        if (pos == 0) {
            deleteNodeAtFront();
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void deleteNodeByKey(int key) {
        if (head == null)
            return;
        if (head.data == key) {
            head = head.next;
        }
        Node temp = head.next;
        Node prev = head;
        while (temp != null) {
            if (temp.data == key) {
                prev.next = temp.next;
            }
            temp = temp.next;
            prev = prev.next;
        }
    }

    public void addLoop() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
    }


    public void reverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head = prev;
    }

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int getNth(int index) {
        Node temp = head;
        int count = 0;
        while (count < index && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp != null)
            return temp.data;
        return -1;
    }

    public int printNthFromLast(int n) {
        if (n < 1 || n > getCount(head)) {
            return -1;
        }
        Node temp = head;
        Node ref = head;
        int count = 0;
        while (count < n && temp != null) {
            count++;
            temp = temp.next;
        }
        if (temp != null) {
            while (temp != null) {
                temp = temp.next;
                ref = ref.next;
            }
        }
        return ref.data;
    }

    public int detectLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return countLoop(slow);
            }
        }
        return 0;
    }

    public int countLoop(Node n) {
        int count = 1;
        Node temp = n;
        while (temp.next != n) {
            temp = temp.next;
            count++;
        }
        return count;
    }


    public int getCount(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void removeDuplicateFromSorted() {
        Node temp = head;
        if (temp == null) {
            return;
        }
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }
    }

    public void removeDuplicateFromUnsorted() {
        if (head == null) {
            return;
        }
        Node curr = head;
        Node prev = null;
        HashSet<Integer> hashSet = new HashSet<>();
        while (curr != null) {

            if (hashSet.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                hashSet.add(curr.data);
                prev = curr;
            }

            curr = curr.next;
        }
    }

    public void swapNodes(int x, int y) {
        if (head == null)
            return;
        Node temp = head;
        Node xPrev = null;
        Node yPrev = null;
        while (temp.next != null) {
            if (temp.next.data == x) {
                xPrev = temp;
            } else if (temp.next.data == y) {
                yPrev = temp;
            }
            temp = temp.next;
        }
        if (xPrev != null && yPrev != null) {
            Node t = xPrev.next;
            xPrev.next = yPrev.next;
            yPrev.next = t;
            t = xPrev.next.next;
            xPrev.next.next = yPrev.next.next;
            yPrev.next.next = t;
        }
    }

    public void pairWiseSwap() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            int data = temp.next.data;
            temp.next.data = temp.data;
            temp.data = data;
            temp = temp.next.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void segregateEvenOdd() {
        if (head == null)
            return;
        Node evenStart = null;
        Node evenHead = null;
        Node oddStart = null;
        Node oddHead = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = temp;
                    evenStart = temp;
                } else {
                    evenStart.next = temp;
                    evenStart = evenStart.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = temp;
                    oddStart = temp;
                } else {
                    oddStart.next = temp;
                    oddStart = oddStart.next;
                }
            }
            temp = temp.next;
        }

        if (evenStart != null) {
            evenStart.next = oddHead;
        }
        head = evenHead;
    }

    public void moveFrontElementToLast() {
        if (head == null)
            return;
        Node first = head;
        Node temp = head;
        head = temp.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = first;
        first.next = null;
    }

    public void reverseLinkedListInGroup(int num) {
        head = reverse(head, num);
        print();
    }

    public Node reverse(Node node, int num) {
        Node temp = null;
        Node prev = null;
        Node curr = node;
        int i = 0;
        while (i < num && curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }
        if (temp != null)
            node.next = reverse(temp, num);
        return prev;
    }

    public void print() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print("[" + temp.data + "] ");
            temp = temp.next;
        }
        System.out.println("");
    }
}
