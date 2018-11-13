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

    private void sort(int[] arr, int left, int right) {
        if(right <= left) {
            return;
        }

        int mid = (left + right) / 2;
        this.sort(arr, left, mid);  // geht erst eine Zeile weiter bis der Base Case dieser Rekursion erreicht ist (Array mit nur noch einem Element)
        this.sort(arr, mid + 1, right); // geht erst eine Zeile weiter bis der Base Case dieser Rekursion erreicht ist (Array mit nur noch einem Element)

        // zu diesem Zeitpunkt haben beide vorherigen Rekursionen ihren Base Case erreicht
        // left, mid und right beschreiben nun nur noch zwei Arrays mit je einem Element die nun gemerged werden müssen
        this.merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];     // temp array in das die sortierten Elemente eingetragen werden
        int tempIndex = 0;          // starting index des temp arrays

        int leftIndex = left;       // starting index des linken zu sortierenden Arrays
        int rightIndex = mid + 1;   // starting index des rechten zu sortierenden Arrays


        // solange die indices des linken und rechten Arrays nicht über ihre Grenzen schlagen
        while(leftIndex <= mid && rightIndex <= right) {

            if(arr[leftIndex] < arr[rightIndex]) {
                temp[tempIndex] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[tempIndex] = arr[rightIndex];
                rightIndex++;
            }

            tempIndex++;

        }

        // obrige While loop kann Enden wenn noch nicht alles im Temp Array einsortiert ist
        // z.B. wenn die linken Werte immer kleiner sind als die Rechten
        // daher muss noch einmal geprüft werden ob schon alle Werte von links und Rechts in das
        // temp Array geschrieben werden müssen


        // in diesem Fall ist die rechte Seite schon sortiert, daher muss das Temp Array noch
        // mit Werten aus dem linken aufgefüllt werden
        if(leftIndex <= mid) {
           while(leftIndex <= mid) {
               temp[tempIndex] = arr[leftIndex];
               leftIndex++;
               tempIndex++;
           }

        // in diesem Fall ist die linke Seite schon sortiert, daher muss das Temp Array noch
        // mit Werten aus dem rechten aufgefüllt werden
        } else if(rightIndex <= right) {
            while(rightIndex <= right) {
                temp[tempIndex] = arr[rightIndex];
                rightIndex++;
                tempIndex++;
            }
        }

        // ab diesem Punkt ist das Temp Array sortiert
        // nun müssen nur noch die soritierten Werte ins Original-Array übernommen werden

        for(int i = 0; i < temp.length; i++) {
            arr[left + 1] = temp[i];
        }
    }

}
