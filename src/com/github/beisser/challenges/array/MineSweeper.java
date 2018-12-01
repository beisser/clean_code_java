package com.github.beisser.challenges.array;

// Gegeben: Mine Sweeper Feld (zweidimensionales Array) und Bomben-Orte
// Ziel: Bomben Orte in das 2D Array packen und Felder um die Bombe entsprechend kennzeichnen
// Default Feld-Wert: 0, Bomben-Feld -1, An Bombe angrenzendes Feld 1
class MineSweeper {

    public static void main(String[] args) {

        int[][] bombs1 = {{0, 2}, {2, 0}};
        int[][] field = mineSweeper(bombs1, 5, 5);

        for(int i = 0; i < 5; i++) {

            StringBuilder stringBuilder = new StringBuilder();

            for(int j = 0; j < 5; j++) {
                stringBuilder.append(field[i][j] + " ");
            }

            System.out.println(stringBuilder.toString());
        }
    }

    private static int[][] mineSweeper(int[][] bombs, int rows, int columns) {
        int[][] field = new int[rows][columns];

        for(int[] bomb: bombs) {

            int bombRowIndex = bomb[0];
            int bombColIndex = bomb[1];

            field[bombRowIndex][bombColIndex] = -1;

            for(int i = bombRowIndex -1; i < bombRowIndex + 2; i++) {
                for(int j = bombColIndex -1; j < bombColIndex + 2; j++) {
                    if(i >= 0 && i < rows && j >= 0 && j < columns && field[i][j] != -1) {
                        field[i][j] = 1;
                    }
                }
            }

        }

        return field;
    }

}
