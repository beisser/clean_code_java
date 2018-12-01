package com.github.beisser.challenges.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Ziel: in einem Array die Zahl rausfinden die am häufigsten vorkommt
 */
class MostFrequentExample {


    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};

        System.out.println(mostFreqent(array1));
        System.out.println(mostFreqent(array2));
        System.out.println(mostFreqent(array3));
        System.out.println(mostFreqent(array4));
        System.out.println(mostFreqent(array5));


    }

    public static Integer mostFreqent(int[] givenArray) {
        Integer maxItem = null;
        Integer maxCount = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < givenArray.length; i++) {

            int current = givenArray[i];

            if(!map.containsKey(current)) {
                map.put(current,1);
            } else {
                map.put(current,map.get(current) + 1);
            }

            if(map.get(current) > maxCount) {
                maxItem = current;
                maxCount = map.get(current);
            }
        }


        return maxItem;
    }

}
