package com.leetcode;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = { 4, 7, 10, 12, 20, 25 };
		int[] nums2 = { 2, 3, 6, 15 };
		System.out.println("MED 1: " + findMedianSortedArrays(nums1, nums2));
		System.out.println("MED 3: " + findMedianSortedArraysTwoPointer(nums1, nums2));
	}

	/**
	 * Using binary search Time Complexity O(log(m+n))
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] smallest = nums1, bigest = nums2;
		if (nums1.length > nums2.length) {
			// This way we make sure that binary search is execute on smallest array
			smallest = nums2;
			bigest = nums1;
		}

		// m <= n
		int m = smallest.length;
		int n = bigest.length;
		int total = (m + n);
		int half = (total + 1) >> 1;

		int low = 0, high = m;
		while (low <= high) {
			int sm_partition_size = (low + high) >> 1; // (low + high) / 2
			int bg_partition_size = half - sm_partition_size;

			int sm_lvp = (sm_partition_size <= 0) ? Integer.MIN_VALUE : smallest[sm_partition_size - 1];
			int sm_rvp = (sm_partition_size >= m) ? Integer.MAX_VALUE : smallest[sm_partition_size];

			int bg_lvp = (bg_partition_size <= 0) ? Integer.MIN_VALUE : bigest[bg_partition_size - 1];
			int bg_rvp = (bg_partition_size >= n) ? Integer.MAX_VALUE : bigest[bg_partition_size];

			if (sm_lvp <= bg_rvp && bg_lvp <= sm_rvp) {
				if (total % 2 == 0) {
					return (Math.max(sm_lvp, bg_lvp) + Math.min(sm_rvp, bg_rvp)) / 2.0;
				}
				return Math.max(sm_lvp, bg_lvp);
			}

			if (sm_lvp > bg_rvp) {
				high = sm_partition_size - 1;
			} else {
				low = sm_partition_size + 1;
			}
		}
		return 0;
	}


	// Two pointer approach
	// Time Complexity O((n + m) / 2)
	public static double findMedianSortedArraysTwoPointer(int[] A, int[] B) {

		int half = (A.length + B.length) / 2;

		int i = 0, j = 0, count = 0;
		int middle1 = 0, middle2 = 0;

		while (count <= half) {

			if (A[i] <= B[j]) {
				middle1 = middle2;
				middle2 = A[i];
				i = i + 1;
			} else {
				middle1 = middle2;
				middle2 = B[j];
				j = j + 1;
			}

			if (i == half) {
				middle1 = middle2;
				middle2 = B[0];
				break;
			} else if (j == half) {
				middle1 = middle2;
				middle2 = A[0];
				break;
			}

			count = count + 1;
		}

		if ((A.length + B.length) % 2 != 0) {
			return middle2;
		}
		return (double) (middle1 + middle2) / 2;
	}

}
