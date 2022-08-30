package com.leetcode;

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    private boolean containDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    private boolean containDuplicate2(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 1) return false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    private boolean containDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
