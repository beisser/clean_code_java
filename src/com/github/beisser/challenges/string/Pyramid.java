package com.github.beisser.challenges.string;

class Pyramid {

    public static void main(String[] args) {
        printPyramid(4);
    }

    public static void printPyramid(int level) {

        for(int i = 1; i <= level; i++) {

            StringBuilder stringBuilder = new StringBuilder();

            for(int j = i; j < level; j++) {

                stringBuilder.append(" ");

            }

            for(int k = 0; k <(i * 2) - 1; k++) {
                stringBuilder.append("*");
            }

            System.out.println(stringBuilder.toString());
        }

    }

}
