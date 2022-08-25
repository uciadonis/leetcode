package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {3,2,4};
		int target = 7;
		
		// int[] result = twoSum(array, target);
		int[] result = twoSumMap2(array, target);
		if (result != null && result.length == 2) {
			System.out.println("Las posiciones son: [" + result[0] +"] [" + result[1] + "]");
		} else {
			System.out.println("No hay resultados");
		}
	}

	/**
	 * Runtime 71 ms
	 * Memory 45mb
	 * @param nums - Numbers list
	 * @param target - Sum target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = null;
        for (int i = 0; i < nums.length - 1; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		if (nums[i] + nums[j] == target) {
        			result = new int[] {i , j};
        		}
        	}
        }
        
        return result;
    }

	/**
	 * Runtime 4 ms
	 * Memory 42.6 mb
	 * @param nums - Numbers list
	 * @param target - Sum target
	 * @return
	 */
	public static int[] twoSumMap1(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length - 1; i++) {
			int sumMember = target - nums[i];
			Integer index = map.get(sumMember);
			if (index != null && index != i) {
				return new int[] {i , index};
			}
		}
		return null;
	}

	/**
	 * Runtime 1 ms
	 * Memory 42.7 mb
	 * @param nums - Numbers list
	 * @param target - Sum target
	 * @return
	 */
	public static int[] twoSumMap2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int sumMember = target - nums[i];
			Integer index = map.get(sumMember);
			if (index != null && index != i) {
				return new int[] {i , index};
			}
			map.put(nums[i], i);
		}
		return null;
	}

	/*Map<Integer, Integer> map = Arrays.stream(numbers)
				.boxed()
				.collect(Collectors.toMap(
						k -> k,
						v -> v
				));*/

}
