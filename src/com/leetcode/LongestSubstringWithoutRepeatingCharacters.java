package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * @author uciad
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the phrase to search: ");
		String input = br.readLine();
		
		System.out.print("Output: " + Integer.toString(lengthOfLongestSubstringSWA(input)));
		
	}
	
	public static int lengthOfLongestSubstringSWA(String s) {
		if (s == null || s.isEmpty()) return 0;		
		int start = 0;
		int maxLength = 0;
		
		Map<Character, Integer> substring = new HashMap<>();
		for (int index = 0; index < s.length(); index++) {
			char cch = s.charAt(index);
			if (substring.containsKey(cch)) {
				if (substring.get(cch) >= start) {
					start = substring.get(cch) + 1;
				}
			}
			maxLength = Math.max(maxLength, index - start + 1);
			substring.put(cch, index);
		}
		return maxLength;
    }
	
	public static int lengthOfLongestSubstringSlidingWindowsAproach(String s) {
		if (s == null || s.isEmpty()) return 0;		
		int length = s.length();		
		if (length == 1) return 1;		
		int start = 0;
		int maxLength = 0;
		Map<Character, Integer> substring = new HashMap<>();
		for (int i = 0; i < length; i++) {
			char cch = s.charAt(i);
			Integer repeatedIdex = substring.get(cch);
			if (repeatedIdex != null) {
				maxLength = Math.max(maxLength, i - start);
				start = repeatedIdex + 1;
				
				Iterator<Map.Entry<Character, Integer>> iter = substring.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry<Character, Integer> item = iter.next();
					if (item.getValue() <= repeatedIdex) {
						iter.remove();
					}
				}
			}
			substring.put(cch, i);
		}
		maxLength = Math.max(maxLength, length - start);
		return maxLength;
    }
	
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) return 0;		
		int length = s.length();		
		if (length == 1) return 1;		
		int maxLength = 0;
		
		for (int i = 0; i < length - 1; i++) {
			Map<Character, Integer> substring = new HashMap<>();
			substring.put(s.charAt(i), i);
			int currentLength = 1;
			for (int c = i + 1; c < length; c++) {
				if (substring.get(s.charAt(c)) != null) {
					i = substring.get(s.charAt(c));
					break;
				}				
				substring.put(s.charAt(c), c);
				currentLength++;
			}
			if (currentLength > maxLength) {
				maxLength = currentLength;
			}
		}		
		return maxLength;
    }
}
