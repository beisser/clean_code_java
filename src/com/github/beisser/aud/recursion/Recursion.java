package com.github.beisser.aud.recursion;

class Recursion {

    public static void main(String[] args) {
        reduceByOne(10);
    }

    public static void reduceByOne(int start) {
        if(start >= 0) {
            reduceByOne(start - 1);
            System.out.println(start);
        }
    }
}
