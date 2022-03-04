package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the phrase to convert: ");
		String input = br.readLine();
		
		System.out.print("Enter the total rows: ");
		int numRows = Integer.valueOf(br.readLine());
		
		System.out.println("The converted phrase is: " + convert(input, numRows));
	}
	
	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;
		
		int length = Math.min(s.length(), numRows);
		List<StringBuilder> map = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			map.add(new StringBuilder());
		}
		
		int currentRow = 0;
		boolean walkDown = false;
		length = s.length();
		for (int i = 0; i < length; i++) {
			map.get(currentRow).append(s.charAt(i));			
			if (currentRow == 0 || currentRow == numRows - 1) {
				walkDown = !walkDown;
			}
			currentRow += walkDown ? 1 : -1;
		}
		
		StringBuilder result = new StringBuilder();
		length = map.size();
		for (int i = 0; i < length; i++) {
			result.append(map.get(i));
		}
		return result.toString();
    }
}
