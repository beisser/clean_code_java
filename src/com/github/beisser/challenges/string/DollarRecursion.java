package com.github.beisser.challenges.string;

/**
 * add a dollar sign after each char in a given string using recursion
 *      -> hello should result in h$e$l$l$o
 */
class DollarRecursion {

    public static void main(String[] args) {
        System.out.println(allDollas("hello"));
    }

    public static String allDollas(String str) {

        if(str.length() <= 1) {
            return str;
        }

        return str.charAt(0) + "$" + allDollas(str.substring(1));
    }
}
