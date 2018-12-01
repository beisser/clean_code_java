package com.github.beisser.challenges.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Ziel: Aus zwei übergebenen Integer Arrays die Werte zurückgeben welche in beiden Arrays vorhanden sind
 *
 *  wichtig: O(n) -> also keine nested Loops!
 */

class CommonElements {

    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        // common_elements(array1C, array2C) should return [] (an empty array).

        Arrays.stream(commonElements(array1A, array2A)).forEach(System.out::println);
    }

    public static Integer[] commonElements(int[] array1, int[] array2) {

        List<Integer> result = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;

        for(int i = 0; i < array1.length; i++) {

            if(array1[pointer1] == array2[pointer2]) {
                result.add(array1[pointer1]);
                pointer1++;
                pointer2++;
            } else if(array1[pointer1] > array2[pointer2]) {
                pointer2++;
            } else {
                pointer1++;
            }

        }

        return result.stream().toArray(Integer[]::new);

    }
}
