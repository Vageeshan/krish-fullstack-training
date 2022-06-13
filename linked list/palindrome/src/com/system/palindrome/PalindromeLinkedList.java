package com.system.palindrome;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-13 09:59 AM Monday
 **/
public class PalindromeLinkedList {
    private Node headElement;

    PalindromeLinkedList() {
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

    public static Node reverseLinkedList(Node currentNode) {
        Node previousNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.nextElement;
            currentNode.nextElement = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static Node findMiddleNode(Node head) {
        Node slowPointer, fastPointer;
        slowPointer = fastPointer = head;

        while (fastPointer != null) {
            fastPointer = fastPointer.nextElement;
            if (fastPointer != null && fastPointer.nextElement != null) {
                slowPointer = slowPointer.nextElement;
                fastPointer = fastPointer.nextElement;
            }
        }
        return slowPointer;
    }

    public static boolean checkPalindrome(Node head) {
        // Find middle node
        Node middleNode = findMiddleNode(head);
        Node secondHead = middleNode.nextElement;
        middleNode.nextElement = null;
        Node reverseSecondHead = reverseLinkedList(secondHead);

        while (head != null && reverseSecondHead != null) {
            if (head.i == reverseSecondHead.i) {
                head = head.nextElement;
                reverseSecondHead = reverseSecondHead.nextElement;
                continue;
            } else {
                return false;
            }
        }
        return true;
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
