package com.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println("Reverse number: " + solution2(2147483647));  // MAX
        System.out.println("Reverse number: " + solution2(-2147483648)); // MIN
        System.out.println("Reverse number: " + solution2(1463847412));
        System.out.println("Reverse number: " + solution2(-1563847412));
    }

    /**
     * Runtime 1 ms
     * Memory 39.4 mb
     * @param x - number
     * @return
     */
    private static int solution1(int x) {
        int temp = x;
        int reverse = 0;
        while(temp <= -10 || temp >= 10) {
            int res = temp % 10;
            reverse = (reverse * 10) + res;
            temp = temp / 10;
        }

        if (reverse > 0) {
            int max = Integer.MAX_VALUE / 10; // 214748364
            int maxRest = Integer.MAX_VALUE % 10; // 7

            if (max < reverse || (max == reverse && maxRest < temp)) {
                return 0;
            }
        }
        else {
            int min = Integer.MIN_VALUE / 10;
            int minRest = Integer.MIN_VALUE % 10;

            if (min > reverse || (min == reverse && minRest > temp)) {
                return 0;
            }
        }

        reverse = (reverse * 10) + temp;
        return reverse;
    }

    /**
     * Runtime 1 ms
     * Memory 39.7 mb
     * @param x - number
     * @return
     */
    private static int solution2(int x) {
        int reverse = 0;
        while(x <= -10 || x >= 10) {
            reverse = (reverse * 10) + x % 10;
            x /= 10;
        }

        if (reverse > 0) {
            return (reverse > Integer.MAX_VALUE / 10) ? 0 : (reverse * 10) + x;
        } else {
            return (reverse < Integer.MIN_VALUE / 10) ? 0 : (reverse * 10) + x;
        }
    }

    private static int solution3(int x) {
        int rev = 0;
        while(x!=0){
            int digit = x%10;
            int newRev = rev*10 + digit;
            if((newRev - digit)/10 != rev){
                return 0;}
            rev = newRev;
            x/=10;
        }
        return rev;
    }

}
