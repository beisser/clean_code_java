package com.github.beisser.aud.sort.selection_sort;

import java.util.Arrays;

class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 13, 87, 12, 99};
        Arrays.stream(selectionSort(arr)).forEach(System.out::println);
    }

    public static int[] selectionSort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            int min = i;

            for(int j = i + 1; j < arr.length; j++) {

                if(arr[j] < arr[min]) {
                    min = j;
                }

            }

            int temp = arr[i];

            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;

    }
}
