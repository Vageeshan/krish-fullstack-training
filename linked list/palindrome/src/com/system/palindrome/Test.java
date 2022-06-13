package com.system.palindrome;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-13 09:59 AM Monday
 **/
public class Test {
    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        PalindromeLinkedList.Node headElement = new PalindromeLinkedList.Node(1);
        palindromeLinkedList.addElement(headElement);
        palindromeLinkedList.addElement(new PalindromeLinkedList.Node(0));
        palindromeLinkedList.addElement(new PalindromeLinkedList.Node(0));
        palindromeLinkedList.addElement(new PalindromeLinkedList.Node(1));
        palindromeLinkedList.displayList();
        System.out.println("\n" + PalindromeLinkedList.checkPalindrome(headElement));
    }
}
