package com.leetcode;
/**
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */

public class AddTwoNumbers2 {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode l13 = new ListNode(3);
		ListNode l12 = new ListNode(4, l13);
		ListNode l11 = new ListNode(2, l12);
		
		ListNode l23 = new ListNode(4);
		ListNode l22 = new ListNode(6, l23);
		ListNode l21 = new ListNode(5, l22);
		
		System.out.println("The L1 is : [" + getNumber(l11) + "]");
		System.out.println("The L2 is : [" + getNumber(l21) + "]");
		
		ListNode result = addTwoNumbers(l11, l21);
		if (result != null) {			
			System.out.println("The result is : [" + getNumber(result) + "]");
		} else {
			System.out.println("No hay resultados");
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		long l1Number = getOrderedNumber(l1);
		long l2Number = getOrderedNumber(l2);
		StringBuilder rb = new StringBuilder(String.valueOf(l1Number + l2Number));
		StringBuilder reversed = rb.reverse();
		if (reversed != null && reversed.length() > 0) {
			int length = reversed.length();
			result = new ListNode(Integer.parseInt(String.valueOf(reversed.charAt(0))));
			ListNode lastNode = result;
			for (int i = 1; i < length; i++) {
				ListNode currentNode = new ListNode(Integer.parseInt(String.valueOf(reversed.charAt(i))));
				lastNode.next = currentNode;
				lastNode = currentNode;
			}
		}
		return result;		
	}
	
	public static long getOrderedNumber(ListNode l) {
		StringBuilder reversedNumber = new StringBuilder();
		while (l != null) {
			reversedNumber.append(l.val);
			l = l.next;
		}
		return Long.valueOf(reversedNumber.reverse().toString());		
	}
	
	public static String getNumber(ListNode l) {
		StringBuilder rb = new StringBuilder();
		while (l != null) {
			rb.append(l.val);
			l = l.next;
		}		
		return rb.toString();
	}
}
