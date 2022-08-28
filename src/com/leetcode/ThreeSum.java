package com.leetcode;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Constraints:
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

public class ThreeSum {

    public static void main(String[] args) {
        int [] array = new int[] {-1,0,1,2,-1,-4};
        /// int [] array = new int[] {-1,0,1,2,-1,-4,-2};
        /// int [] array = new int[] {1,-1,-1,0};
        /// int [] array = new int[] {0,0,0,0};
        /// int [] array = new int[] {0,1,1};
        List<List<Integer>> result = ThreeSum2(array);
        if (result == null || result.isEmpty()) {
            System.out.println("Does not exists triplets");
        } else {
            result.forEach(e -> {
                e.forEach(n -> System.out.print(n + ", "));
                System.out.println();
            });
        }

    }

    /**
     * Runtime 29 ms
     * Memory 46.2 mb
     * @param nums - Numbers list
     * @return
     */
    private static List<List<Integer>> ThreeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && (nums[i] == nums[i - 1])) continue;

            int j = i + 1, k = nums.length - 1;
            while(k > j) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    /**
     * Runtime 340 ms
     * Memory 121.3 mb
     * @param nums - Numbers list
     * @return
     */
    private static List<List<Integer>> ThreeSum2(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) continue;

            int subTarget = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int sumMember3 = subTarget - nums[j];
                Integer index = map.get(sumMember3);
                if (index != null && index != i && index != j) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[index]);
                    Collections.sort(triplet);
                    set.add(triplet);
                    continue;
                }
                map.put(nums[j], j);
            }
        }

        return List.copyOf(set);
    }
}