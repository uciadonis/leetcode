package com.leetcode;
/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {3,3 };
		int target = 6;
		
		int[] result = twoSum(array, target);
		if (result != null && result.length == 2) {
			System.out.println("Las posiciones son: [" + result[0] +"] [" + result[1] + "]");
		} else {
			System.out.println("No hay resultados");
		}
	}
	
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

}
