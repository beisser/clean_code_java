package com.github.beisser.aud.sort.merge_sort;

import java.util.Arrays;

class MergeSortExample {

    public static void main(String[] args) {
        int[] arr = {9,7,3,1,6,3,2,6,8,9,2,3,0};
        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(arr);

        Arrays.stream(arr).forEach(System.out::println);

    }

}

class MergeSort {

    public void sort(int[] arr) {
        // pass array and left and right border to the sort method
        this.sort(arr, 0, arr.length -1);
    }

    public void sort(int[] arr, int left, int right) {
        if(right <= left) {
            return;
        }

        int mid = (left + right) / 2;
        this.sort(arr, left, mid);
        this.sort(arr, mid + 1, right);
        this.merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

    }

}
