package com.github.beisser.challenges.array;

/**
 * Ziel: 2 Arrays sind gegeben. Hier gilt es herauszufinden ob das eine Array eine Rotation eines anderen ist
 * Eine Rotation enthält die gleiche Anzahl von Elementen gleich sortiert, beginnt jedoch eventuell an einer anderen Stelle
 */
class ArrayRotation {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        // isRotation(array1, array2a) should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        // isRotation(array1, array2b) should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        // isRotation(array1, array2c) should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        // isRotation(array1, array2d) should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        // isRotation(array1, array2e) should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        // isRotation(array1, array2f) should return true.

        System.out.println(isRotation(array1,array2b));
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] array1, int[] array2) {

        // wenn nicht gleich lang dann keine Rotation
        if(array1.length != array2.length) {
            return false;
        }

        // Erstes Lement von array1
        int element1 = array1[0];
        // Index des ersten Elements von array1 in array2;
        int distance = -1;

        // Index von element1 in array2 suchen
        for(int i = 0; i < array2.length; i++) {
            if(array2[i] == element1) {
                distance = i;
            }
        }

        // wenn key2 immernoch -1 dann wurde das Element nicht gefunden
        if(distance == -1) {
            return false;
        }

        // nun in beiden Arrays von der Startposition immer um 1 weiter prüfen
        // ob die beiden Werte gleich sind
        for(int i = 0; i < array1.length; i++) {

            // i ist die Position des aktuellen Wertes in array1
            // j ist die Position des aktuellen Wertes in array2
            // j ergibt sich aus der Position in array1 + distance
            // der Modulo-Operator sorgt dafür dass wenn j größer als die ArrayLength ist
            // j wieder bei 0 anfängt
            int j = (i + distance) % array1.length;
            if(array1[i] != array2[j]) {
                return false;
            }
        }

        return true;

    }


}
