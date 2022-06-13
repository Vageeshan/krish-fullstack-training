package com.system.reverse;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-13 09:59 AM Monday
 **/
public class LinkedListReverse {
    private Node headElement;

    LinkedListReverse() {
        headElement = null;
    }

    public boolean isEmpty() {
        return headElement == null;
    }

    public void addElement(Node newNode) {
        if (isEmpty()) {
            headElement = newNode;
        } else {
            Node current = headElement;
            // looping through to the last of the linked list
            while (current.nextElement != null) {
                current = current.nextElement;
            }
            // adding new element, current last node
            current.nextElement = newNode;
        }
    }

    public void reverseLinkedList() {
        Node previous = null;
        Node current = headElement;
        Node next;
        while (current != null) {
            next = current.nextElement;
            current.nextElement = previous;
            // Move up by one node
            previous = current;
            current = next;
        }
        headElement = previous;
    }

    public void displayList() {
        Node current = headElement;
        while (current != null) {
            current.printElements();
            current = current.nextElement;
        }
    }

    static class Node {
        int i;
        Node nextElement;

        Node(int i) {
            this.i = i;
            this.nextElement = null;
        }

        public void printElements() {
            System.out.print(" " + i);
        }
    }
}
