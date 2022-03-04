package com.leetcode;
/**
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */

public class AddTwoNumbers {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

	public static void main(String[] args) {
		ListNode l19 = new ListNode(9);
		ListNode l18 = new ListNode(9, l19);
		ListNode l17 = new ListNode(9, l18);
		ListNode l16 = new ListNode(9, l17);
		ListNode l15 = new ListNode(9, l16);
		ListNode l14 = new ListNode(9, l15);
		ListNode l13 = new ListNode(9, l14);
		ListNode l12 = new ListNode(9, l13);
		ListNode l11 = new ListNode(9, l12);
		
		ListNode l24 = new ListNode(9);
		ListNode l23 = new ListNode(9, l24);
		ListNode l22 = new ListNode(9, l23);
		ListNode l21 = new ListNode(9, l22);
		
		System.out.println("The L1 is : [" + getNumber(l11) + "]");
		System.out.println("The L2 is : [" + getNumber(l21) + "]");
		
		ListNode result = addTwoNumbers(l11, l21);
		result = addTwoNumbers(l11, l21);
		// Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
		long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));

		if (result != null) {			
			System.out.println("The result is : [" + getNumber(result) + "]");
		} else {
			System.out.println("No hay resultados");
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode lastNode = result;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			if (result == null) {
				result = new ListNode(sum);
				lastNode = result;
			} else {
				lastNode.next = new ListNode(sum);
				lastNode = lastNode.next;
			}
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		if (carry > 0) {
			lastNode.next = new ListNode(carry);
		}
		return result;
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
