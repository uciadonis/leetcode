package com.leetcode;
// https://www.code-recipe.com/post/palindrome-number
public class PalindromeNumber {

	public static void main(String[] args) {
		int number = 999959999;
		System.out.println(isPalindrome(number));
		// System.out.println(Integer.reverse(number));
		
	}
	
	public static boolean isPalindrome(int x) {
        int temp = x;
        int reversed = 0;
        while (temp > 0) {
        	reversed = (reversed * 10) + (temp % 10);
        	temp = temp / 10;
        }
        return x == reversed;
    }
}
