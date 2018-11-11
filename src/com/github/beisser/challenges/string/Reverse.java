package com.github.beisser.challenges.string;

/**
 * Challenge: Reverse a given String
 */
class Reverse {

    public static void main(String[] args) {

        String str = "Hello World";

        for(int i = str.length() -1 ; i >= 0; i--) {
            System.out.println(str.charAt(i));
        }

        System.out.println(new StringBuilder(str).reverse().toString());
    }

}
