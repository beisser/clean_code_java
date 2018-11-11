package com.github.beisser.aud.sort.insertion_sort;

import java.util.Arrays;

class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 13, 87, 12, 99};
        Arrays.stream(insertionSort(arr)).forEach(System.out::println);
    }

    public static int[] insertionSort(int[] arr) {

        // Wichtig: i=1, weil die erste Stelle schon als sortiert betrachtet wird
        // Index 1 ist somit das erste Element im unsortierten Bereich
        for(int i = 1; i < arr.length; i++) {

            int element = arr[i];   // Wert des ersten Elements im unsortierten Bereich zwischenspeichern
            int j = i - 1;      // Index des letzten Elements im sortierten Bereich

            // Wert des letzten Elements des sortierten Bereichs mit aktuellem Wert vergleichen
            // Wenn größer als neues Elemet müssen wir dieses verschieben, dann sortierten Bereich weiter rückwärts
            // iterieren und die bestehenden Werte nach hinten schieben wenn sie größer sind als das neue Element
            // das macht man bis man den richtigen Slot hat
            while(j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j];    // aktuell betrachtetes sortiertes Element um 1 weiter nach hinten schieben im sortierten Bereich
                i--;
            }

            // nun hat man den Slot des neuen Wertes im sortierten Bereich
            // diesem kann man nun den Wert des neuen Elements hinzufügen
            arr[j + 1] = element;
        }

        return arr;
    }
}
