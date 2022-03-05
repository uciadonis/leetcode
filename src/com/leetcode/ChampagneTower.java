package com.leetcode;

/**
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses,
 * and so on until the 100th row. Each glass holds one cup of champagne.
 * 
 * Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, 
 * any excess liquid poured will fall equally to the glass immediately to the left and right of it. 
 * When those glasses become full, any excess champagne will fall equally to the left and right of 
 * those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)
 * 
 * For example, after one cup of champagne is poured, the top most glass is full.  After two cups of
 * champagne are poured, the two glasses on the second row are half full.  After three cups of 
 * champagne are poured, those two cups become full - there are 3 full glasses total now.
 * After four cups of champagne are poured, the third row has the middle glass half full, and the two 
 * outside glasses are a quarter full, as pictured below.
 * 
 * Input: poured = 1, query_row = 1, query_glass = 1
 * Output: 0.00000
 * Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)).
 * There will be no excess liquid so all the glasses under the top glass will remain empty.
 * 
 * Input: poured = 2, query_row = 1, query_glass = 1
 * Output: 0.50000
 * Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)).
 * There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) 
 * will share the excess liquid equally, and each will get half cup of champange.
 */

public class ChampagneTower {

	public static void main(String[] args) {
		int poured = 100000009, 
			query_row = 33,
			query_glass = 17;
		
		System.out.println("Result: " + champagneTower(poured, query_row, query_glass));
	}
	
	public static double champagneTower(int poured, int query_row, int query_glass) {
		if (query_row == 0) return Math.min(poured, 1);
        double [][] pyramid = new double[query_row + 1][query_row + 1];
        pyramid[0][0] = (double) poured;
        for (int row = 0; row < query_row; row++) {
        	for (int colunm = 0; colunm <= row; colunm++) {
        		double cpoured = (pyramid[row][colunm] - 1) / 2;
        		if (cpoured > 0) {
        			pyramid[row + 1][colunm] += cpoured;
        			pyramid[row + 1][colunm + 1] += cpoured;
        		}
        		// System.out.print(pyramid[row][colunm] + "   ");
        	}
        	// System.out.print(System.lineSeparator());
        }
        // System.out.print(System.lineSeparator());
		return Math.min(pyramid[query_row][query_glass], 1);
    }
	
}
