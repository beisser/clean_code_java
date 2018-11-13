package com.github.beisser.aud.sort.quick_sort;

class QuickSort {

    public static void main(String[] args) {

        int[] arr = {12,81,74,43,1098,0,8,92,17,754,912,0,6,4};
        quickSort(arr,0,arr.length -1);

    }

    public static void quickSort(int[] arr, int left, int right) {

        // base case der Rekursion
        if(right >left) {
            return;
        }

        // Zunächst wird eine Pivot ermittelt
        // dieses Element ist nach dem Aufruf der Methode garantiert am richtigen Ort
        int pivot = partition(arr,left,right);

        // daher wird anschließend das Array mit diesem Pivot-Punkt in zwei Teile geteilt (ohne den eigentlichen Pivot Punkt
        // für diese beiden Teile wird die Methode rekursiv aufgerufen (sprich weitere Pivots und damit garantierte
        // Positionen werden erstellt)
        quickSort(arr,left,pivot - 1);
        quickSort(arr,pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];     //aktueller Pivot Punkt -> danach garantiert an der richtigen Stelle
        int i = left - 1;           // i -> Pointer für kleinere Elemente, wird immer erhöht wenn ein Element kleiner als Pivot ist

        // j -> wird immer erhöht
        // loop darf nur bis Länge - 1 gehen, da das letzte Element Pivot ist und Pivot am Ende an Position i + 1 gesetzt wird
        for(int j = left; j < arr.length - 1; j++) {

            if(arr[j] <= pivot) {
                i++;
                int jVal = arr[j];
                int iVal = arr[i];
                arr[j] = iVal;
                arr[i] = jVal;
            }

        }

        // Pivot am Ende mit Element an Position i + 1 swappen
        int swap = arr[i + 1];
        arr[right] = swap;
        arr[i + 1] = pivot;

        return i + 1;
    }
}
