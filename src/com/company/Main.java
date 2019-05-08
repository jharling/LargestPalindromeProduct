package com.company;

public class Main {

    public static void main(String[] args) {
	/*
	    https://projecteuler.net/problem=4
	    A palindromic number reads the same both ways.
	    The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
        Find the largest palindrome made from the product of two 3-digit numbers.
	 */
        int answer = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int product = i * j;
                if (checkPalindrome(product) && answer < product){
                    answer = product;
                }
            }
        }
        System.out.println(answer);
    }

    private static Boolean checkPalindrome(int product) {
        String s1 = String.valueOf(product);
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            sb.append(s1.charAt(i));
        }
        return s1.equalsIgnoreCase(String.valueOf(sb));
    }


}
