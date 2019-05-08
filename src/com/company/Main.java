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

        boolean flag = false;
        int count = 0;
        int product;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                product = i * j;
                if (stringCheckPalindrome(product) && answer < product){
                    answer = product;
                } else count++;
            }
        }
        System.out.println("count: " + count);
        System.out.println("answer: " + answer);

        /*
            More efficient way. Since we're looking for the largest product, starting from the
            top of our limit will allow us to hit the largest pair of products, which will always
            give us the largest possible number. Then we can set a flag and break since all numbers
            following will always be smaller than the first palindrome found.
         */
        count = 0;
        for (int i = 999; i > 900; i--) {
            for (int j = 999; j > 900; j--) {
                product = i * j;
                if (mathCheckPalindrome(product)){
                    answer = product;
                    flag = true;
                } else count++;
            }
            if (flag) {
                break;
            }
        }
        System.out.println("count: " + count);
        System.out.println("answer: " + answer);
    }

    private static Boolean stringCheckPalindrome(int product) {
        String s1 = String.valueOf(product);
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            sb.append(s1.charAt(i));
        }
        return s1.equalsIgnoreCase(String.valueOf(sb));
    }

    private static Boolean mathCheckPalindrome(int product) {
        int n;
        int total = 0;
        int temp = product;

        while(product > 0){
            n = product % 10;
            total =(total * 10) + n;
            product = product / 10;
        }
        return temp == total;
    }
}
