package com.system.reverse;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-13 09:59 AM Monday
 **/
public class Test {
    public static void main(String[] args) {
        LinkedListReverse linkedListReverse = new LinkedListReverse();
        linkedListReverse.addElement(new LinkedListReverse.Node(1));
        linkedListReverse.addElement(new LinkedListReverse.Node(3));
        linkedListReverse.addElement(new LinkedListReverse.Node(5));
        linkedListReverse.addElement(new LinkedListReverse.Node(7));
        linkedListReverse.addElement(new LinkedListReverse.Node(9));
        System.out.println("Before Reverse......");
        linkedListReverse.displayList();
        System.out.println("\n After Reverse......");
        linkedListReverse.reverseLinkedList();
        linkedListReverse.displayList();
    }
}
