package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. Check If a String Contains All Binary Codes of Size K
 *
 * Given a binary string s and an integer k, return true if every binary code
 * of length k is a substring of s. Otherwise, return false.
 */
public class BinaryCodesSizeK {

    public static void main(String[] args) {
        System.out.println("Valid: " + hasAllCodes("00110", 2));
        System.out.println("Valid: " + hasAllCodes("00110110", 2));
        System.out.println("Valid: " + hasAllCodes("0110", 1));
        System.out.println("Valid: " + hasAllCodes("0110", 2));
    }

    public static boolean hasAllCodes(String s, int k) {
        // Math.pow(2, k)
        int max = (1 << k);
        Set<String> substrings = new HashSet<>();
        int iterationLength = s.length() - k + 1;
        for (int i = 0; i < iterationLength; i++) {
            String pair = s.substring(i, i + k);
            substrings.add(pair);

            if (substrings.size() == max) {
                return true;
            }
        }
        return false;
    }
}
