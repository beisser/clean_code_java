package com.github.beisser.aud.search.linear;

/**
 * linear search ist basic suche
 *
 * Diese Suche skaliert linear O(n), da Zeit abhängig von der Größe
 */
class LinearSearch {

    public static void main(String[] args) {
        int[] arr  ={1, 2, 3, 4, 5, 6};
        System.out.println(recursiveLinearSearch(arr, 0, 3));
    }

    public static int linearSearch(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                return i;
            }
        }

        return -1;
    }

    public static int recursiveLinearSearch(int[] arr, int i, int x) {
        if(i > arr.length - 1) {
            return -1;
        } else if(arr[i] == x) {
            return i;
        } else {
            return recursiveLinearSearch(arr, i + 1, x);
        }
    }
}
